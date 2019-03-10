package pl.edu.pk.knit.android.backend.webservice.service;

import pl.edu.pk.knit.android.backend.webservice.model.SecurityRole;

public interface SecurityService {

    SecurityRole getRoleByName(String name);

}
