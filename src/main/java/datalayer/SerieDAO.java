package datalayer;

import datalayerinterface.ISerie;
import models.Episode;
import models.Profile;
import models.Serie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SerieDAO implements ISerie {
    /**
     * This class handles all database interactions for series
     */
    private static SerieDAO instance;

    public SerieDAO() {
    }

    /**
     * Makes sure only one instance of this class can exist at any given time
     * @return
     */
    public static SerieDAO getInstance() {
        if (instance == null) {
            instance = new SerieDAO();
        }
        return instance;
    }

    /**
     * Returns an array with all series
     * @return ArrayList<Serie>
     */
    @Override
    public List getAllSeries() {
        ArrayList<Serie> series = new ArrayList<>();
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM serie");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("serieId");
                String name = resultSet.getString("name");
                int ageRating = resultSet.getInt("ageRating");

                String genre = resultSet.getString("genre");
                String suggestion = resultSet.getString("suggestions");

                Serie s = new Serie(id, name, ageRating,  genre, suggestion);
                series.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return series;
    }

    /**
     * Returns a single series by given id
     * @param Id
     * @return Serie
     */
    @Override
    public Serie getSerieById(int Id) {
        Connection conn = null;
        Serie serie = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM serie WHERE serieId = ?");
            statement.setInt(1, Id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {

                int id = resultSet.getInt("serieId");
                String name = resultSet.getString("serieName");
                int ageRating = resultSet.getInt("ageClassification");
                String language = resultSet.getString("language");
                String genre = resultSet.getString("genre");
                String suggestion = resultSet.getString("suggestion");

                serie = new Serie(id, name, ageRating,  genre, suggestion);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return serie;
    }

    /**
     * Returns an array of all episodes in a serie
     * @param s
     * @return
     */
    @Override
    public List getAllEpisodesBySerie(Serie s) {
        ArrayList<Episode> episodes = new ArrayList<>();
        Connection conn = null;
        Serie serie = null;
        Episode episode = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("SELECT Program.programId, title, duration, season FROM serie\n" +
                    "INNER JOIN episode ON episode.serieID = serie.serieID\n" +
                    "INNER JOIN Program ON Program.episodeId = Episode.programId\n" +
                    "WHERE serie.serieId = ?");
            statement.setInt(1, s.getSerieId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("programID");
                String title = resultSet.getString("title");
                String duration = resultSet.getString("duration");
                int season = resultSet.getInt("season");

                Episode e = new Episode(id, title, duration, season);
                episodes.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return episodes;
    }

    /**
     * Return the average watchtime for a serie
     * @param s
     * @return int
     */
    @Override
    public int getAverageWatchTime(Serie s) {
        Connection conn = null;
        int averageWatchTime = 0;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("SELECT AVG(watchedTime) AS avgPercentage FROM watched\n" +
                    "INNER JOIN episode ON episode.programId = watched.programId\n" +
                    "WHERE SerieId = ?");

            statement.setInt(1, s.getSerieId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                averageWatchTime = resultSet.getInt("avgPercentage");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return averageWatchTime;
    }

    /**
     * Returns an array of all series by a single profile
     * @param p
     * @return ArrayList<Serie>
     */
    @Override
    public List getWatchedSeriesByProfile(Profile p) {
        ArrayList<Serie> series = new ArrayList<>();
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("SELECT DISTINCT serie.serieId, name, ageRating, genre, suggestions FROM serie \n" +
                    "INNER JOIN episode ON episode.serieId = serie.serieId \n" +
                    "INNER JOIN Program ON Program.episodeId = Episode.programId \n" +
                    "INNER JOIN watched ON watched.programId = program.programId \n" +
                    "INNER JOIN profile ON profile.profileId = watched.profileId \n " +
                    "WHERE profile.profileId = ?");
            statement.setInt(1, p.getProfileId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("serieId");
                String name = resultSet.getString("name");
                int ageRating = resultSet.getInt("ageRating");
                String genre = resultSet.getString("genre");
                String suggestion = resultSet.getString("suggestions");

                Serie s = new Serie(id, name, ageRating,  genre, suggestion);
                series.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }

        return series;
    }

    /**
     * Updates a serie by the given serie
     * @param s
     */
    public void updateSerie(Serie s) {
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("UPDATE `serie` SET `serieName` = ?," +
                    " WHERE `serieId` = ?");
            statement.setString(1, s.getName());
            statement.setInt(2,s.getSerieId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
    }

}
