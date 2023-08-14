package org.openjfx.hellofx.model.movie;

import org.openjfx.hellofx.model.common.BaseService;

public class MovieService extends BaseService<Movie> {
    public MovieService() {
        super("movies", Movie.class);
    }
}
