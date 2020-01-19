package datalayer;

import datalayerinterface.IMovie;
import models.Movie;
import models.Profile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MovieDAO implements IMovie {
    private static MovieDAO instance;

    public static MovieDAO getInstance() {
        if(instance == null){
            instance = new MovieDAO();
        }
        return instance;
    }

    @Override
    public List getAllMovies() {
        ArrayList<Movie> allMovies = new ArrayList<Movie>();
        Connection conn = null;
        try{
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement getAllMovies = conn.prepareStatement("SELECT * FROM movie");
            ResultSet resultSet = getAllMovies.executeQuery();

            while(resultSet.next()) {
                //Deze moeten nog aangepast worden voor de uiteindelijke column namen
                int movieID = resultSet.getInt("movieID");
                String movieTitle = resultSet.getString("movieTitle");
                int movieDuration = resultSet.getInt("movieDuration");
                String movieGenre = resultSet.getString("movieGenre");
                String movieLanguage = resultSet.getString("movieLanguage");
                int movieAge = resultSet.getInt("movieAge");

                Movie m = new Movie(movieID, movieTitle, movieDuration, movieGenre, movieLanguage, movieAge);
                allMovies.add(m);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return allMovies;
    }

    @Override
    public Movie getMovieById(int id) {
        Connection conn = null;
        Movie m = null;

        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement getMovieById = conn.prepareStatement("SELECT * FROM movie WHERE movieId = ?");
            getMovieById.setInt(1, id);
            ResultSet resultSet = getMovieById.executeQuery();

            while(resultSet.next()){

                //Deze moeten nog aangepast worden voor de uiteindelijke column namen
                int movieID = resultSet.getInt("movieID");
                String movieTitle = resultSet.getString("movieTitle");
               int movieDuration = resultSet.getInt("movieDuration");
                String movieGenre = resultSet.getString("movieGenre");
                String movieLanguage = resultSet.getString("movieLanguage");
                int movieAge = resultSet.getInt("movieAge");

                m = new Movie(movieID, movieTitle, movieDuration, movieGenre, movieLanguage, movieAge);

            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }

        return m;
    }

    @Override
    public List getMoviesWatchedByProfile(Profile p) {
        ArrayList<Movie> allMoviesWatched = new ArrayList<Movie>();
        Connection conn = null;
        try{
            conn = MysqlDAO.getInstance().connect();
            //tabelnaam zal waarschijnlijk nog veranderd moeten worden. Voor nu is het "movie_profile"
            PreparedStatement getMoviesWatchedByProfile = conn.prepareStatement("SELECT * FROM movie_profile WHERE profileId = ?");
            getMoviesWatchedByProfile.setInt(1, p.getProfileId());
            ResultSet resultSet = getMoviesWatchedByProfile.executeQuery();

            while(resultSet.next()){
                int movieID = resultSet.getInt("movieID");

                allMoviesWatched.add(this.getMovieById(movieID));
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }

        return allMoviesWatched;
    }



}
