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
            PreparedStatement getAllMovies = conn.prepareStatement("SELECT * FROM movie join program on movie.programId = program.movieId ");
            ResultSet resultSet = getAllMovies.executeQuery();

            while(resultSet.next()) {
                //Deze moeten nog aangepast worden voor de uiteindelijke column namen
                int movieID = resultSet.getInt("programId");
                String movieTitle = resultSet.getString("title");
               String movieDuration = resultSet.getString("duration");
                String movieGenre = resultSet.getString("genre");
                String movieLanguage = resultSet.getString("language");
                int movieAge = resultSet.getInt("ageRating");

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
            PreparedStatement getMovieById = conn.prepareStatement("SELECT Program.programId, title, duration, genre, language, ageRating\n" +
                    "FROM Program\n" +
                    "INNER JOIN Movie ON Movie.programId = Program.movieId\n" +
                    "WHERE Program.programId = ?");
            getMovieById.setInt(1, id);
            ResultSet resultSet = getMovieById.executeQuery();

            while(resultSet.next()){

                //Deze moeten nog aangepast worden voor de uiteindelijke column namen
                int movieID = resultSet.getInt("programId");
                String movieTitle = resultSet.getString("title");
                String movieDuration = resultSet.getString("duration");
                String movieGenre = resultSet.getString("genre");
                String movieLanguage = resultSet.getString("language");
                int movieAge = resultSet.getInt("ageRating");

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
            PreparedStatement getMoviesWatchedByProfile = conn.prepareStatement("SELECT * FROM watched WHERE profileId = ?");
            getMoviesWatchedByProfile.setInt(1, p.getProfileId());
            ResultSet resultSet = getMoviesWatchedByProfile.executeQuery();

            while(resultSet.next()){
                int movieID = resultSet.getInt("programId");

                Movie movie = this.getMovieById(movieID);
                if (movie != null){
                    allMoviesWatched.add(this.getMovieById(movieID));
                }
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }

        return allMoviesWatched;
    }

    public int getFullywatchedMovies(Movie movie){
        int average;
        Connection conn = null;
        try{
            conn = MysqlDAO.getInstance().connect();
            //tabelnaam zal waarschijnlijk nog veranderd moeten worden. Voor nu is het "movie_profile"


            PreparedStatement Getamountoffullywatched = conn.prepareStatement("select count (profileId)  as DoorHoeveelBekeken \n" +
                    "from watched\n" +
                    "\n" +
                    "join Program on watched.programId = program.programId\n" +
                    "where program.movieId = ?");
            Getamountoffullywatched.setInt(1, movie.getProgramId());
            ResultSet resultSet = Getamountoffullywatched.executeQuery();

            while(resultSet.next()) {

                int DoorHoeveelbekeken = resultSet.getInt("DoorHoeveelBekeken");
                return DoorHoeveelbekeken;


            }}catch (SQLException e){
            e.printStackTrace();
        }finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
   return 0 ; }

    public Movie getLongestMovieForAgeLowerThen16(){
        Movie Longestunder16 = null;
        Connection conn = null;
        try{

            conn = MysqlDAO.getInstance().connect();
            //tabelnaam zal waarschijnlijk nog veranderd moeten worden. Voor nu is het "movie_profile"
            PreparedStatement Getlongestunder16 = conn.prepareStatement("select top 1 *\n" +
                    "from movie\n" +
                    "join program on movie.programId = program.movieId\n" +
                    "where program.movieId IS NOT NULL and movie.ageRating < 16\n" +
                    "ORDER BY DURATION desc ");

            ResultSet resultSet = Getlongestunder16.executeQuery();
            while(resultSet.next()){
            int movieID = resultSet.getInt("programId");
            String movieTitle = resultSet.getString("title");
            String movieDuration = resultSet.getString("duration");
            String movieGenre = resultSet.getString("genre");
            String movieLanguage = resultSet.getString("language");
            int movieAge = resultSet.getInt("ageRating");


            Longestunder16 = new Movie(movieID, movieTitle, movieDuration, movieGenre, movieLanguage, movieAge);
            return Longestunder16;







        }}catch (SQLException e){
            e.printStackTrace();
        }finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return Longestunder16; }



}