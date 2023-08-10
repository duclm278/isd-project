package org.openjfx.hellofx.db;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnector {
    private static final String DATABASE_URI = "mongodb+srv://admin:admin@cluster0.rni4rdu.mongodb.net/";
    private static final String DATABASE_NAME = "test";

    public static MongoDatabase connect() {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder().automatic(true).build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        MongoClient mongoClient = MongoClients.create(DATABASE_URI);
        return mongoClient.getDatabase(DATABASE_NAME).withCodecRegistry(pojoCodecRegistry);
    }
}
