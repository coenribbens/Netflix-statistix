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
        ArrayList<Account> allProfiles = new ArrayList<Account>();
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
        return null;
    }

    @Override
    public void createNewProfile(Profile p) {

    }

    @Override
    public void updateProfile(Profile p) {

    }

    @Override
    public void deleteProfile(Profile p) {

    }

    @Override
    public List getProfilesOfAccount(Account a) {
        return null;
    }
}
