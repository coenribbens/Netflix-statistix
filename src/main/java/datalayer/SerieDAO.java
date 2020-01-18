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
    private static SerieDAO instance;

    private SerieDAO() {
    }

    public static SerieDAO getInstance() {
        if (instance == null) {
            instance = new SerieDAO();
        }
        return instance;
    }

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
                    String name = resultSet.getString("serieName");
                    int ageRating = resultSet.getInt("ageRating");
                    String language = resultSet.getString("language");
                    String genre = resultSet.getString("genre");
                    String suggestion = resultSet.getString("suggestion");

                    Serie s = new Serie(id, name, ageRating, language, genre, suggestion);
                    series.add(s);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                MysqlDAO.getInstance().closeConnection(conn);
            }
            return series;
        }

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

                serie = new Serie(id, name, ageRating, language, genre, suggestion);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return serie;
    }

    @Override
    public List getAllEpisodesBySerie(Serie s) {
        ArrayList<Episode> episodes = new ArrayList<>();
        Connection conn = null;
        Serie serie = null;
        Episode episode = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM serie\n" +
                    "INNER JOIN episode ON episode.serieID = serie.serieID\n" +
                    "INNER JOIN program ON program.programId = episode.programId\n" +
                    "WHERE serie.serieId = ?");
            statement.setInt(1, s.getSerieId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("episodeID");
                String title = resultSet.getString("videoTitle");
                String duration = resultSet.getString("durage");
                int season = resultSet.getInt("season");

                Episode e = new Episode(id, title, duration, season);
                episodes.add(e);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return episodes;
    }

    @Override
    public int getAverageWatchTime(Serie s) {
        Connection conn = null;
        int averageWatchTime = 0;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("SELECT AVG(percentage) AS avgPercentage FROM watched\n" +
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

    @Override
    public List getWatchedSeriesByProfile(Profile p) {
        ArrayList<Serie> series = new ArrayList<>();
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM serie \n" +
                    "INNER JOIN episode ON episode.programId = serie.serieId \n" +
                    "INNER JOIN watched ON watched.programId = episode.programId \n" +
                    "INNER JOIN profile ON profile.profileId = watched.profileId \n " +
                    "WHERE profile.profileId = ?");
            statement.setInt(1, p.getProfileId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("serieId");
                String name = resultSet.getString("serieName");
                int ageRating = resultSet.getInt("ageRating");
                String language = resultSet.getString("language");
                String genre = resultSet.getString("genre");
                String suggestion = resultSet.getString("suggestion");

                Serie s = new Serie(id, name, ageRating, language, genre, suggestion);
                series.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }

        return series;
    }


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