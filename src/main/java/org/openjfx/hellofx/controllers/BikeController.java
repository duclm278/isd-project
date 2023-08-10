package org.openjfx.hellofx.controllers;

import org.bson.Document;
import org.openjfx.hellofx.db.DatabaseConnector;
import org.openjfx.hellofx.models.bike.Bike;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import java.util.List;

public class BikeController {
    private final MongoCollection<Document> collection;

    public BikeController() {
        MongoDatabase database = DatabaseConnector.connect();
        collection = database.getCollection("bikes");
    }

    public void addBike(Bike bike) {
        // Convert Item to Document and insert into collection
    }

    public List<Bike> getAllBikes() {
        // Retrieve all items from the collection and convert to List<Item>
        return null;
    }

    // Other CRUD methods
}
