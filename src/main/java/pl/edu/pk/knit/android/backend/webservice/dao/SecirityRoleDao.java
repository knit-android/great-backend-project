package pl.edu.pk.knit.android.backend.webservice.dao;

import pl.edu.pk.knit.android.backend.webservice.model.SecurityRole;

public interface SecirityRoleDao {
    SecurityRole getRoleByName(String name);
}
