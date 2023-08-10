package org.openjfx.hellofx.models.movie;

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

public class MovieService {
    private final MongoCollection<Movie> collection;

    public MovieService() {
        MongoDatabase database = DatabaseConnector.connect();
        collection = database.getCollection("movies", Movie.class);
    }

    public Movie save(Movie movie) {
        InsertOneResult result = collection.insertOne(movie);
        return collection.find(eq("_id", result.getInsertedId())).first();
    }

    public List<Movie> find() {
        List<Movie> movies = new ArrayList<>();
        FindIterable<Movie> documents = collection.find();
        return documents.into(movies);
    }

    public List<Movie> find(Bson filters) {
        List<Movie> movies = new ArrayList<>();
        FindIterable<Movie> documents = collection.find(filters);
        return documents.into(movies);
    }

    public Movie findById(String id) {
        return collection.find(eq("_id", new ObjectId(id))).first();
    }

    public Movie findByIdAndReplace(String id, Movie movie) {
        FindOneAndReplaceOptions options = new FindOneAndReplaceOptions()
                .returnDocument(com.mongodb.client.model.ReturnDocument.AFTER);
        return collection.findOneAndReplace(eq("_id", new ObjectId(id)), movie, options);
    }

    public Movie findByIdAndDelete(String id) {
        return collection.findOneAndDelete(eq("_id", new ObjectId(id)));
    }
}
