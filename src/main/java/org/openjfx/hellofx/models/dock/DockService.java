package org.openjfx.hellofx.models.dock;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.openjfx.hellofx.db.DatabaseConnector;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.result.InsertOneResult;

public class DockService {
    private final MongoCollection<Dock> collection;

    public DockService() {
        MongoDatabase database = DatabaseConnector.connect();
        collection = database.getCollection("docks", Dock.class);
    }

    public Dock save(Dock dock) {
        InsertOneResult result = collection.insertOne(dock);
        return collection.find(eq("_id", result.getInsertedId())).first();
    }

    public List<Dock> find() {
        List<Dock> docks = new ArrayList<>();
        FindIterable<Dock> documents = collection.find();
        return documents.into(docks);
    }

    public List<Dock> find(Bson filters) {
        List<Dock> docks = new ArrayList<>();
        FindIterable<Dock> documents = collection.find(filters);
        return documents.into(docks);
    }

    public Dock findById(String id) {
        return collection.find(eq("_id", new ObjectId(id))).first();
    }

    public Dock findByIdAndReplace(String id, Dock dock) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions()
                .returnDocument(com.mongodb.client.model.ReturnDocument.AFTER);
        return collection.findOneAndReplace(eq("_id", new ObjectId(id)), dock, options);
    }

    public Dock findByIdAndDelete(String id) {
        return collection.findOneAndDelete(eq("_id", new ObjectId(id)));
    }
}
