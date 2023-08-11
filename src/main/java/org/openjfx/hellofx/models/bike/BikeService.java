package org.openjfx.hellofx.models.bike;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.openjfx.hellofx.db.DatabaseConnector;
import org.openjfx.hellofx.models.bike7.Bike;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.result.InsertOneResult;

public class BikeService {
    private final MongoCollection<Bike> collection;

    public BikeService() {
        MongoDatabase database = DatabaseConnector.connect();
        collection = database.getCollection("bikes", Bike.class);
    }

    public Bike save(Bike bike) {
        InsertOneResult result = collection.insertOne(bike);
        return collection.find(eq("_id", result.getInsertedId())).first();
    }

    public List<Bike> find() {
        List<Bike> bikes = new ArrayList<>();
        FindIterable<Bike> documents = collection.find();
        return documents.into(bikes);
    }

    public List<Bike> find(Bson filters) {
        List<Bike> bikes = new ArrayList<>();
        FindIterable<Bike> documents = collection.find(filters);
        return documents.into(bikes);
    }

    public Bike findById(String id) {
        return collection.find(eq("_id", new ObjectId(id))).first();
    }

    public Bike findByIdAndReplace(String id, Bike bike) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions()
                .returnDocument(com.mongodb.client.model.ReturnDocument.AFTER);
        return collection.findOneAndReplace(eq("_id", new ObjectId(id)), bike, options);
    }

    public Bike findByIdAndDelete(String id) {
        return collection.findOneAndDelete(eq("_id", new ObjectId(id)));
    }
}
