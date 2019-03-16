package pl.edu.pk.knit.android.backend.webservice.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pk.knit.android.backend.webservice.model.LastLocation;

public interface LastLocationDao extends CrudRepository<LastLocation, Long> {


    public LastLocation getFirstByUserId(long userId);
}
