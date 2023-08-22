package org.openjfx.hellofx.repository.mongo;

import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.openjfx.hellofx.repository.base.IBaseRepository;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.FindOneAndReplaceOptions;
import com.mongodb.client.model.ReturnDocument;
import com.mongodb.client.result.InsertOneResult;

import lombok.Getter;

@Getter
public class MongoRepository<T, ID> implements IBaseRepository<T, ID> {
    private final MongoClient client;
    private final MongoDatabase database;
    private final MongoCollection<T> collection;

    public MongoRepository(Class<T> entityClass) {
        client = MongoSource.getClient();
        database = MongoSource.getDatabase(client);
        String collectionName = getCollectionName(entityClass);
        collection = database.getCollection(collectionName, entityClass);
    }

    private String getCollectionName(Class<?> entityClass) {
        String simpleName = entityClass.getSimpleName();
        return simpleName.replaceAll("(\\B)([A-Z])", "$1_$2").toLowerCase() + "s";
    }

    @Override
    public T save(T object) {
        InsertOneResult result = collection.insertOne(object);
        return result.wasAcknowledged() ? object : null;
    }

    @Override
    public List<T> find() {
        List<T> objects = new ArrayList<>();
        FindIterable<T> documents = collection.find();
        return documents.into(objects);
    }

    @Override
    public T findById(ID id) {
        if (id instanceof ObjectId) {
            return collection.find(eq("_id", id)).first();
        }
        return null;
    }

    @Override
    public List<T> findByField(String fieldName, Class<?> fieldType, Object fieldValue) {
        List<T> objects = new ArrayList<>();
        FindIterable<T> documents = collection.find(eq(fieldName, fieldType.cast(fieldValue)));
        return documents.into(objects);
    }

    @Override
    public T findByIdAndReplace(ID id, T object) {
        if (id instanceof ObjectId) {
            FindOneAndReplaceOptions options = new FindOneAndReplaceOptions()
                    .returnDocument(ReturnDocument.AFTER);
            return collection.findOneAndReplace(eq("_id", id), object, options);
        }
        return null;
    }

    @Override
    public T findByIdAndDelete(ID id) {
        if (id instanceof ObjectId) {
            return collection.findOneAndDelete(eq("_id", id));
        }
        return null;
    }
}
