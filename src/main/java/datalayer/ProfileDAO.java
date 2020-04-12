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

    /**
     * Makes sure only one instance of this class can exist
     * @return
     */
    public static ProfileDAO getInstance() {
        if (instance == null) {
            instance = new ProfileDAO();
        }
        return instance;
    }

    /**
     * Returns an array with all profiles
     * @return
     */
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

    /**
     * Gets a single profile based on the id given
     * @param Id
     * @return
     */
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

    /**
     * Creates a new profile
     * @param p
     */
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

    /**
     * Updates an existing profile in the database
     * @param p
     */
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

    /**
     * Deletes a profile from the database and application
     * @param p
     */
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

    /**
     * Returns an array with the profiles of an account
     * @param a
     * @return
     */
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

    /**
     * Marks a series as watched if it exists
     * @param programId
     * @param profileId
     * @param watchedTime
     */
    public void markSeriesAsWatched(int programId, int profileId, String watchedTime) {
        Connection conn = null;
        //TODO When trying to insert a duplicate value, an SQLException occurs. This happens when trying to watch an episode that has already been watched.
        if(hasMediaBeenWatched(programId, profileId)){

            try {
                conn = MysqlDAO.getInstance().connect();
                PreparedStatement statement = conn.prepareStatement(""
                        + "UPDATE watched SET watchedTime = ? "
                        + "WHERE programId = ? AND profileId = ?");
                statement.setString(1, watchedTime);
                statement.setInt(2, programId);
                statement.setInt(3, profileId);
                statement.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                MysqlDAO.getInstance().closeConnection(conn);
            }
        }
        else {
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

    /**
     * Marks an entry as watched for a profile
     * @param programId
     * @param profileId
     * @return
     */
    public boolean hasMediaBeenWatched(int programId, int profileId){
        Connection conn = null;
        boolean hasBeenWatched = false;
        try {
            conn = MysqlDAO.getInstance().connect();
            PreparedStatement statement = conn.prepareStatement(""
                    + "SELECT * "
                    + "FROM watched "
                    + "WHERE programId = ? AND profileId = ?");
            statement.setInt(1, programId);
            statement.setInt(2, profileId);
            ResultSet resultSet = statement.executeQuery();
            hasBeenWatched = resultSet.next();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            MysqlDAO.getInstance().closeConnection(conn);
        }
        return hasBeenWatched;
    }

    /**
     * Marks a series as unwatched for a single profile
     * @param programId
     * @param profileId
     */
    public void markSeriesAsUnwatched(int programId, int profileId) {
        Connection conn = null;
        if(hasMediaBeenWatched(programId, profileId)){

            try {
                conn = MysqlDAO.getInstance().connect();
                PreparedStatement statement = conn.prepareStatement(""
                        + "DELETE FROM watched "
                        + "WHERE programId = ? AND profileId = ?");
                statement.setInt(1, programId);
                statement.setInt(2, profileId);
                statement.execute();
            } catch (SQLException ex) {
                ex.printStackTrace();
            } finally {
                MysqlDAO.getInstance().closeConnection(conn);
            }
        }
            else{
                MysqlDAO.getInstance().closeConnection(conn);
            }
        }
    }

