package pl.edu.pk.knit.android.backend.webservice.service;

import pl.edu.pk.knit.android.backend.webservice.model.LastLocation;

public interface LastLocationService {

    Iterable<LastLocation> getAllLocations();
    void saveLocation(LastLocation location);
}
