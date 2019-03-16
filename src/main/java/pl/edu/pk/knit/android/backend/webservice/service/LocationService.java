package pl.edu.pk.knit.android.backend.webservice.service;

import pl.edu.pk.knit.android.backend.webservice.model.LastLocation;

public interface LocationService {

    Iterable<LastLocation> getAllLocations();
    void saveLocationForUser(LastLocation location);
}
