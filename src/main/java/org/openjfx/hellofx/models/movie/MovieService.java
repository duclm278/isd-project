package org.openjfx.hellofx.models.movie;

import org.openjfx.hellofx.models.common.BaseService;

public class MovieService extends BaseService<Movie> {
    public MovieService() {
        super("movies", Movie.class);
    }
}
