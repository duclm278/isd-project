package org.openjfx.hellofx.model.common;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.openjfx.hellofx.repository.mongo.MongoSource;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.result.InsertOneResult;

import lombok.Getter;

@Getter
public class OldService<T> {
    private final MongoClient client;
    private final MongoDatabase database;
    private final MongoCollection<T> collection;

    public OldService(String collectionName, Class<T> clazz) {
        client = MongoSource.getClient();
        database = MongoSource.getDatabase(client);
        collection = database.getCollection(collectionName, clazz);
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
                .returnDocument(ReturnDocument.AFTER);
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
