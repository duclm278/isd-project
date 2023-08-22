package org.openjfx.hellofx.repository.mongo;

import static com.mongodb.MongoClientSettings.getDefaultCodecRegistry;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import org.openjfx.hellofx.config.Mongo;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoSource {
    private static MongoSource source;
    private static MongoClient client;
    private static MongoDatabase database;

    private MongoSource() {
        client = getClient();
        database = getDatabase(client);
    }

    public static MongoSource getSource() {
        if (source == null) {
            return new MongoSource();
        }
        return source;
    }

    public static MongoClient getClient() {
        if (client == null) {
            client = MongoClients.create(Mongo.URI);
        }
        return client;
    }

    public static MongoDatabase getDatabase(MongoClient client) {
        if (database == null) {
            CodecProvider pojoCodecProvider = PojoCodecProvider.builder()
                    .automatic(true)
                    .register(new OptionalPropertyCodecProvider())
                    .build();
            CodecRegistry pojoCodecRegistry = fromRegistries(getDefaultCodecRegistry(),
                    fromProviders(pojoCodecProvider));
            database = client.getDatabase(Mongo.DATABASE).withCodecRegistry(pojoCodecRegistry);
        }
        return database;
    }
}
