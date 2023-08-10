package org.openjfx.hellofx.db;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnector {
    private static final String DATABASE_URI =
            "mongodb+srv://admin:admin@cluster0.rni4rdu.mongodb.net/";
    private static final String DATABASE_NAME = "test";

    public static MongoDatabase connect() {
        ConnectionString connString = new ConnectionString(DATABASE_URI);
        MongoClient mongoClient = MongoClients.create(connString);
        return mongoClient.getDatabase(DATABASE_NAME);
    }
}
