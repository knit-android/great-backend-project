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
    public void saveLocation(LastLocation newLocation) {

        LastLocation targetLocation = lastLocationDao.getFirstByUserId(newLocation.getUserId());

        if(targetLocation == null){
            targetLocation = new LastLocation();
        }

        targetLocation.setUserId(newLocation.getUserId());
        targetLocation.setLatitude(newLocation.getLatitude());
        targetLocation.setLongitude(newLocation.getLongitude());
        targetLocation.setAccuracy(newLocation.getAccuracy());
        targetLocation.setReportTime(newLocation.getReportTime());

        lastLocationDao.save(targetLocation);
    }
}
