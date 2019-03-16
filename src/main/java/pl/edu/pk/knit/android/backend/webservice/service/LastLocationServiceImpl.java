package pl.edu.pk.knit.android.backend.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pk.knit.android.backend.webservice.dao.LastLocationDao;
import pl.edu.pk.knit.android.backend.webservice.model.LastLocation;

@Service
public class LastLocationServiceImpl implements LastLocationService {


    @Autowired
    private LastLocationDao lastLocationDao;

    @Override
    public Iterable<LastLocation> getAllLocations() {
        return lastLocationDao.findAll();
    }

    @Override
    public void saveLocation(LastLocation location) {
        lastLocationDao.save(location);
    }
}
