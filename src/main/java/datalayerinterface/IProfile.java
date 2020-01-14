package datalayerinterface;

import models.Account;
import models.Profile;
import java.util.List;

public interface IProfile {

    public List getAllProfiles();

    Profile getProfileById(int Id);

    void createNewProfile(Profile p);

    void updateProfile(Profile p);

    void deleteProfile(Profile p);

    List getProfilesOfAccount(Account a);
}
