package org.openjfx.hellofx.db;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.openjfx.hellofx.util.Configs;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class DatabaseConnector {
    public static MongoClient create() {
        return MongoClients.create(Configs.MONGO_URI);
    }

    public static MongoDatabase connect(MongoClient mongoClient) {
        CodecProvider pojoCodecProvider = PojoCodecProvider.builder()
                .automatic(true)
                .register(new OptionalPropertyCodecProvider())
                .build();
        CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(), fromProviders(pojoCodecProvider));
        return mongoClient.getDatabase(Configs.MONGO_DATABASE).withCodecRegistry(pojoCodecRegistry);
    }
}
