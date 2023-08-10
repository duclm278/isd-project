package org.openjfx.hellofx.controllers;

import org.bson.Document;
import org.openjfx.hellofx.db.DatabaseConnector;
import org.openjfx.hellofx.models.bike.Bike;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;

public class BikeService {
    private final MongoCollection<Document> collection;

    public BikeService() {
        MongoDatabase database = DatabaseConnector.connect();
        collection = database.getCollection("bikes");
    }

    public void addBike(Bike bike) {
        // Convert Item to Document and insert into collection
    }

    public List<Bike> getAllBikes() {
        collection.find();
        return null;
    }

    // Other CRUD methods
}
