package datalayer;

import datalayerinterface.ISerie;
import models.Profile;
import models.Serie;

import java.util.List;

public class SerieDAO implements ISerie {

    @Override
    public List getAllSeries() {
        return null;
    }

    @Override
    public Serie getSerieById(int Id) {
        return null;
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
