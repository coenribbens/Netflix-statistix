package datalayer;

import datalayerinterface.IMovie;
import models.Movie;
import models.Profile;

import java.util.List;

public class MovieDAO implements IMovie {

    @Override
    public List getAllMovies() {
        return null;
    }

    @Override
    public Movie getMovieById(int id) {
        return null;
    }

    @Override
    public List getMoviesWatchedByProfile(Profile p) {
        return null;
    }
}
