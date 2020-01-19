package datalayer;

import datalayerinterface.ISerie;
import models.Movie;
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

    public static SerieDAO getInstance(){
        if(instance == null){
            instance = new SerieDAO();
        }
        return instance;
    }

    @Override
    public List getAllSeries() {
        ArrayList<Serie> allSeries = new ArrayList<Serie>();
        allSeries.add(new Serie("ss",  3, "d","s","ff"));
//        Connection conn = null;
//        try{
//            conn = MysqlDAO.getInstance().connect();
//            PreparedStatement getAllSeries = conn.prepareStatement("SELECT * FROM serie");
//            ResultSet resultSet = getAllSeries.executeQuery();
//
//            while(resultSet.next()) {
//                //Deze moeten nog aangepast worden voor de uiteindelijke column namen
//                int serieID = resultSet.getInt("serieID");
//                String serieTitle = resultSet.getString("serieTitle");
//                int serieAge = resultSet.getInt("serieAge");
//                String serieLanguage = resultSet.getString("serieLanguage");
//                String serieGenre = resultSet.getString("serieGenre");
//                String serieSuggestions = resultSet.getString("serieSuggestions");
//
//                Serie s = new Serie(serieID, serieTitle, serieAge, serieLanguage, serieGenre, serieSuggestions);
//                allSeries.add(s);
//            }
//        }catch(SQLException e){
//            e.printStackTrace();
//        }finally {
//            MysqlDAO.getInstance().closeConnection(conn);
//        }
        return allSeries;
    }

    @Override
    public Serie getSerieById(int Id) {
        Serie s = null;
        Connection conn = null;
        try{
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement getSeriesById = conn.prepareStatement("SELECT * FROM serie WHERE serieId = ?");
            getSeriesById.setInt(1, Id);
            ResultSet resultSet = getSeriesById.executeQuery();

            while(resultSet.next()) {
                //Deze moeten nog aangepast worden voor de uiteindelijke column namen
                int serieID = resultSet.getInt("serieID");
                String serieTitle = resultSet.getString("serieTitle");
                int serieAge = resultSet.getInt("serieAge");
                String serieLanguage = resultSet.getString("serieLanguage");
                String serieGenre = resultSet.getString("serieGenre");
                String serieSuggestions = resultSet.getString("serieSuggestions");

                s = new Serie(serieID, serieTitle, serieAge, serieLanguage, serieGenre, serieSuggestions);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return s;
    }

    @Override
    public List getAllEpisodesBySerie(Serie s) {
        return null;
    }

    @Override
    public int getAverageWatchTime(Serie s) {
        return 0;
    }

    @Override
    public List getWatchedSeriesByProfile(Profile p) {
        return null;
    }
}
