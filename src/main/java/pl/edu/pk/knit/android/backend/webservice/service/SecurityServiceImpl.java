package pl.edu.pk.knit.android.backend.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.edu.pk.knit.android.backend.webservice.dao.SecirityRoleDao;
import pl.edu.pk.knit.android.backend.webservice.model.SecurityRole;

import javax.transaction.Transactional;

@Service
@Transactional
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private SecirityRoleDao secirityRoleDao;

    @Override
    public SecurityRole getRoleByName(String name) {
        return secirityRoleDao.getRoleByName(name);
    }
}
