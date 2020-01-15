package datalayer;

import datalayerinterface.IEpisode;
import models.Account;
import models.Episode;
import models.Profile;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EpisodeDAO implements IEpisode {


    @Override
    public List getAllEpisodes() {


{
        ArrayList<Episode> allEpisodes = new ArrayList<Episode>();
        Connection conn = null;

        try{
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement getAllEpisodes = conn.prepareStatement("SELECT * FROM Episode");
            ResultSet resultSet = getAllEpisodes.executeQuery();

            while(resultSet.next()) {
                String titel = resultSet.getString("titel");
                String duration = resultSet.getString("duration");
                int season = resultSet.getInt("season");
                int programId = resultSet.getInt("programId");


                Episode a = new Episode(programId, titel , duration, season);
                allEpisodes.add(a);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return allEpisodes;
}}
    @Override
    public Episode getEpisodesById(int Id) {
        Connection conn = null;
        Episode a = null;

        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement getAccountById = conn.prepareStatement("SELECT * FROM Episode WHERE programId = ?");
            getAccountById.setInt(1, Id);
            ResultSet resultSet = getAccountById.executeQuery();

            while(resultSet.next()) {

                String titel = resultSet.getString("titel");
                String duration = resultSet.getString("duration");
                int season = resultSet.getInt("season");
                int programId = resultSet.getInt("programId");


                a = new Episode(programId, titel , duration, season);

            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally{
            MysqlDAO.getInstance().closeConnection(conn);
        }

        return a;
    }

    @Override
    public List getEpisodesWatchedByProfile(Profile p) {
        ArrayList<Episode> WatchedEpisodes = new ArrayList<Episode>();
        Connection conn = null;

        try{
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement getepidodeswactchedbyprofile = conn.prepareStatement("select ProgramId, season, titel, duration \n" +
                    "from Episode\n" +
                    "join BekekenEpisode on\n" +
                    " Episode.EpisodeID = BekekenEpisode.EpisodeID\n" +
                    "and BekekenEpisode.ProfielID = ?");
            getepidodeswactchedbyprofile.setInt(1, p.getProfileId());
            ResultSet resultSet = getepidodeswactchedbyprofile.executeQuery();

            while(resultSet.next()){
                String titel = resultSet.getString("titel");
                String duration = resultSet.getString("duration");
                int season = resultSet.getInt("season");
                int programId = resultSet.getInt("programId");
               Episode a = new Episode(programId,titel,duration,season);
               WatchedEpisodes.add(a);

            }


        }
        catch (SQLException e){
            e.printStackTrace();

        }
        finally{
            MysqlDAO.getInstance().closeConnection(conn);
        }

    return WatchedEpisodes;}

    @Override
    public int getAverageWatchTimeForEpisode(Episode e) { // NIET AF
        { return 0;

}}}
