package datalayerinterface;

import models.Profile;
import models.Serie;

import java.util.List;

public interface ISerie {

    List getAllSeries();

    Serie getSerieById(int Id);

    List getAllEpisodesBySerie(Serie s);

    int getAverageWatchTime(Serie s);

    List getWatchedSeriesByProfile(Profile p);
}
