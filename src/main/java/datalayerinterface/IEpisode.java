package datalayerinterface;

import models.Episode;
import models.Profile;
import java.util.List;

public interface IEpisode {

    List getAllEpisodes();

    Episode getEpisodesById(int Id);

    List getEpisodesWatchedByProfile(Profile p);

    int getAverageWatchTimeForEpisode(Episode e, Profile p);

    void addWatchedPercentage(Episode e, Profile p, int percentage);

    void updateWatchedPercentage(Episode e, Profile p, int percentage);

    void deleteWatchedPercentage(Episode e, Profile p);

}
