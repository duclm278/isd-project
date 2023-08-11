package org.openjfx.hellofx.models.common;

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

public class BaseService<T> {
    private final MongoCollection<T> collection;

    public BaseService(String collectionName, Class<T> clazz) {
        MongoDatabase database = DatabaseConnector.connect();
        collection = database.getCollection(collectionName, clazz);
    }

    public MongoCollection<T> getCollection() {
        return collection;
    }

    public T save(T object) {
        InsertOneResult result = collection.insertOne(object);
        return result.wasAcknowledged() ? object : null;
    }

    public List<T> find() {
        List<T> objects = new ArrayList<>();
        FindIterable<T> documents = collection.find();
        return documents.into(objects);
    }

    public List<T> find(Bson filters) {
        List<T> objects = new ArrayList<>();
        FindIterable<T> documents = collection.find(filters);
        return documents.into(objects);
    }

    public T findById(ObjectId id) {
        return collection.find(eq("_id", id)).first();
    }

    public T findByIdAndReplace(ObjectId id, T object) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions()
                .returnDocument(com.mongodb.client.model.ReturnDocument.AFTER);
        return collection.findOneAndReplace(eq("_id", id), object, options);
    }

    public T findByIdAndDelete(ObjectId id) {
        return collection.findOneAndDelete(eq("_id", id));
    }

    public T findById(String id) {
        return this.findById(new ObjectId(id));
    }

    public T findByIdAndReplace(String id, T object) {
        return this.findByIdAndReplace(new ObjectId(id), object);
    }

    public T findByIdAndDelete(String id) {
        return this.findByIdAndDelete(new ObjectId(id));
    }

}
