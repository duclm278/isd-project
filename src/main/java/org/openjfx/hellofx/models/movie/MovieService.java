package org.openjfx.hellofx.models.movie;

import org.openjfx.hellofx.models.common.BaseService;

import com.mongodb.client.MongoCollection;

public class MovieService extends BaseService<Movie> {
    private final MongoCollection<Movie> collection;

    public MovieService() {
        super("movies", Movie.class);
        this.collection = super.getCollection();
    }
}
