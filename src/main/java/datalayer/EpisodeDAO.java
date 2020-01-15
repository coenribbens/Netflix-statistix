package datalayer;

import datalayerinterface.IEpisode;
import models.Episode;
import models.Profile;

import java.util.List;

public class EpisodeDAO implements IEpisode {

    @Override
    public List getAllEpisodes() {
        return null;
    }

    @Override
    public Episode getEpisodesById(int Id) {
        return null;
    }

    @Override
    public List getEpisodesWatchedByProfile(Profile p) {
        return null;
    }

    @Override
    public int getAverageWatchTimeForEpisode(Episode e) {
        return 0;
    }
}
