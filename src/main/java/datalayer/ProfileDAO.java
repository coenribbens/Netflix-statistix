package datalayer;

import datalayerinterface.IProfile;
import models.Account;
import models.Profile;

import java.util.List;

public class ProfileDAO implements IProfile {

    @Override
    public List getAllProfiles() {
        return null;
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
