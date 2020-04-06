package datalayer;

import datalayerinterface.IProfile;
import models.Account;
import models.Profile;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfileDAO implements IProfile {
    private static ProfileDAO instance;

    public ProfileDAO() {
    }

    public static ProfileDAO getInstance() {
        if (instance == null) {
            instance = new ProfileDAO();
        }
        return instance;
    }

    @Override
    public List getAllProfiles() {
        ArrayList<Profile> allProfiles = new ArrayList<Profile>();
        Connection conn = null;

        try{
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement getAllProfiles = conn.prepareStatement("SELECT * FROM profile");
            ResultSet resultSet = getAllProfiles.executeQuery();

            while(resultSet.next()) {
                int profileId = resultSet.getInt("profileId");
                String profileName = resultSet.getString("profileName");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                int accountId = resultSet.getInt("accountId");

                Profile p = new Profile(profileId, profileName, dateOfBirth, accountId);
                allProfiles.add(p);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return allProfiles;
    }

    @Override
    public Profile getProfileById(int Id) {
        Connection conn = null;
        Profile p = null;

        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement getAccountById = conn.prepareStatement("SELECT * FROM profile WHERE profileId = ?");
            getAccountById.setInt(1, Id);
            ResultSet resultSet = getAccountById.executeQuery();

            while(resultSet.next()) {

                int profileId = resultSet.getInt("profileId");
                String profileName = resultSet.getString("profileName");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                int accountId = resultSet.getInt("accountId");

                 p = new Profile(profileId, profileName, dateOfBirth, accountId);


            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally{
            MysqlDAO.getInstance().closeConnection(conn);
        }

        return p;
    }

    @Override
    public void createNewProfile(Profile p) {
        Connection conn = null;

        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement(""
                    + "INSERT INTO profile (profileName, dateOfbirth, accountId) "
                    + "VALUES (?, ?, ?)");
            statement.setString(1, p.getProfileName());
            statement.setDate(2, p.getDateOfBirth());
            statement.setInt(3, p.getAccountId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
    }

    @Override
    public void updateProfile(Profile p) {
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement(""
                    + "UPDATE profile SET profileName = ?, dateOfBirth = ?, accountId = ? WHERE profileId = ?");
            statement.setString(1, p.getProfileName());
            statement.setDate(2, p.getDateOfBirth());
            statement.setInt(3, p.getAccountId());
            statement.setInt(4, p.getProfileId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
    }

    @Override
    public void deleteProfile(Profile p) {
        Connection conn = null;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement(""
                    + "DELETE FROM profile "
                    + "WHERE profileId = ?");
            statement.setInt(1, p.getProfileId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
    }

    @Override
    public List getProfilesOfAccount(Account a) {
        ArrayList<Profile> allProfiles = new ArrayList<Profile>();
        Connection conn = null;

        try{
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement getAllProfiles = conn.prepareStatement("SELECT * FROM profile WHERE accountId = ?");

            getAllProfiles.setInt(1, a.getAccountId());
            ResultSet resultSet = getAllProfiles.executeQuery();

            while(resultSet.next()) {
                int profileId = resultSet.getInt("profileId");
                String profileName = resultSet.getString("profileName");
                Date dateOfBirth = resultSet.getDate("dateOfBirth");
                int accountId = resultSet.getInt("accountId");

                Profile p = new Profile(profileId, profileName, dateOfBirth, accountId);
                allProfiles.add(p);
            }
        }catch(SQLException e) {
            e.printStackTrace();
        }finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return allProfiles;
    }

    public void markSeriesAsWatched(int programId, int profileId, String watchedTime) {
        Connection conn = null;
        //TODO When trying to insert a duplicate value, an SQLException occurs. This happens when trying to watch an episode that has already been watched.
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement(""
                    + "INSERT INTO watched (programId, profileId, watchedTime) "
                    + "VALUES (?, ?, ?)");
            statement.setInt(1, programId);
            statement.setInt(2, profileId);
            statement.setString(3, watchedTime);
            statement.execute();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
    }
}
