package datalayerinterface;

import models.Movie;
import models.Profile;

import java.util.List;

public interface IMovie {

    List getAllMovies();

    Movie getMovieById(int id);

    List getMoviesWatchedByProfile(Profile p);

}
