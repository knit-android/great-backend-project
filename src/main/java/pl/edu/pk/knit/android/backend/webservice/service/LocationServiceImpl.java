package pl.edu.pk.knit.android.backend.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.edu.pk.knit.android.backend.webservice.dao.LastLocationDao;
import pl.edu.pk.knit.android.backend.webservice.model.LastLocation;

public class LocationServiceImpl implements LocationService {


    @Autowired
    private LastLocationDao lastLocationDao;

    @Override
    public Iterable<LastLocation> getAllLocations() {
        return lastLocationDao.findAll();
    }

    @Override
    public void saveLocationForUser(LastLocation location) {
        lastLocationDao.save(location);
    }
}