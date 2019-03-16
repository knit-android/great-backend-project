package pl.edu.pk.knit.android.backend.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pk.knit.android.backend.webservice.dao.LastLocationDao;
import pl.edu.pk.knit.android.backend.webservice.model.LastLocation;

import javax.transaction.Transactional;

@Service
@Transactional
public class LastLocationServiceImpl implements LastLocationService {


    @Autowired
    private LastLocationDao lastLocationDao;

    @Override
    public Iterable<LastLocation> getAllLocations() {
        return lastLocationDao.findAll();
    }

    @Override
    public LastLocation saveLocation(LastLocation newLocation) {

        LastLocation existingLocation = lastLocationDao.getFirstByUserId(newLocation.getUserId());

        if(existingLocation != null){
            newLocation.setId(existingLocation.getId());
        }

        newLocation = lastLocationDao.save(newLocation);

        return newLocation;
    }
}
