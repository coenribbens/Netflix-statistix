package datalayer;

import datalayerinterface.IEpisode;
import models.Account;
import models.Episode;
import models.Profile;
import models.Serie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EpisodeDAO implements IEpisode {
    private static EpisodeDAO instance;

    public EpisodeDAO() {
    }

    public static EpisodeDAO getInstance() {
        if (instance == null) {
            instance = new EpisodeDAO();
        }
        return instance;
    }

    @Override
    public List getAllEpisodes() {
        ArrayList<Episode> allEpisodes = new ArrayList<Episode>();
        Connection conn = null;

        try{
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement getAllEpisodes = conn.prepareStatement("SELECT * FROM Episode" +
                    "INNER JOIN Program ON Episode.programId = Program.programId");
            ResultSet resultSet = getAllEpisodes.executeQuery();

            while(resultSet.next()) {
                int programId = resultSet.getInt("programId");
                String title = resultSet.getString("title");
                String duration = resultSet.getString("duration");
                int serie = resultSet.getInt("Serie");

                Episode e = new Episode(programId,title, duration,serie);
                allEpisodes.add(e);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return allEpisodes;
    }

    @Override
    public Episode getEpisodesById(int Id) {
        Connection conn = null;
        Episode ep = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM episode" +
                    "INNER JOIN Program ON Program.programId = episode.programId WHERE Episode.programId = ?");
            statement.setInt(1, Id);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int programId = resultSet.getInt("programId");
                String title = resultSet.getString("title");
                String duration = resultSet.getString("duration");
                int serie = resultSet.getInt("Serie");

                ep = new Episode(programId,title, duration,serie);

            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return ep;
    }

    @Override
    public List getEpisodesWatchedByProfile(Profile p) {
        ArrayList<Episode> episodes = new ArrayList<>();
        Episode ep = null;
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM episode \n" +
                    "INNER JOIN program ON episode.programId = program.programId \n" +
                    "INNER JOIN watched ON watched.programId = episode.programId \n" +
                    "INNER JOIN profile ON profile.profileID = watched.profileID \n " +
                    "WHERE profile.profileID = ?");
            statement.setInt(1, ep.getProgramId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int episodeId = resultSet.getInt("programId");
                String title = resultSet.getString("title");
                String duration = resultSet.getString("duration");
                int season = resultSet.getInt("season");

                ep = new Episode(episodeId, title, duration, season);
                episodes.add(ep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }

        return episodes;
    }

    @Override
    public int getAverageWatchTimeForEpisode(Episode e, Profile p) {
        int watchedTimeInMinutes = 0;
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM watched WHERE programId = ? AND profileID = ?");
            statement.setInt(1, e.getProgramId());
            statement.setInt(2, p.getProfileId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                watchedTimeInMinutes = resultSet.getInt("watchedTime");
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return watchedTimeInMinutes;
    }

    public void addWatchedPercentage(Episode e, Profile p, int percentage) {
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("INSERT INTO `watched`(profileID, programId, percentage) VALUES(?, ?, ?)");
            statement.setInt(1, p.getProfileId());
            statement.setInt(2, e.getProgramId());
            statement.setInt(3, percentage);
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
    }

    public void updateWatchedPercentage(Episode e, Profile p, int percentage) {
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("UPDATE `watched` SET `percentage` = ? WHERE `programId` = ? AND profileID = ?");
            statement.setInt(1, percentage);
            statement.setInt(2, e.getProgramId());
            statement.setInt(3, p.getProfileId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
    }

    public void deleteWatchedPercentage(Episode e, Profile p) {
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("DELETE FROM `watched` WHERE `programId`=? AND profileID = ?");
            statement.setInt(1, e.getProgramId());
            statement.setInt(2, p.getProfileId());
            statement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
    }

    public List<Episode> getEpisodesWatchedPerProfilePerSerie(Profile p, Serie s) {
        ArrayList<Episode> episodes = new ArrayList<>();
        Episode ep = null;
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM episode\n" +
                    "INNER JOIN Program ON episode.programId = program.programId\n" +
                    "INNER JOIN watched ON watched.programId = episode.programId\n" +
                    "INNER JOIN profile ON profile.profileID = watched.profileID\n" +
                    "WHERE profile.profileID = ? AND serie.serieId = ?");
            statement.setInt(1, p.getProfileId());
            statement.setInt(2, s.getSerieId());
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int episodeId = resultSet.getInt("programId");
                String title = resultSet.getString("title");
                String duration = resultSet.getString("duration");
                int season = resultSet.getInt("season");

                ep = new Episode(episodeId, title, duration, season);
                episodes.add(ep);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }

        return episodes;
    }
}

