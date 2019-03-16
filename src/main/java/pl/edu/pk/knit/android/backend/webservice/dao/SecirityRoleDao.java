package pl.edu.pk.knit.android.backend.webservice.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pk.knit.android.backend.webservice.model.SecurityRole;

public interface SecirityRoleDao extends CrudRepository<SecurityRole, Long> {

    SecurityRole findDistinctByName(String name);
}
