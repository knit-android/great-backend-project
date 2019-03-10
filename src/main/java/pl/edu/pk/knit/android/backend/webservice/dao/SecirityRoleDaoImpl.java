package pl.edu.pk.knit.android.backend.webservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.pk.knit.android.backend.webservice.model.SecurityRole;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;

@Repository
public class SecirityRoleDaoImpl implements SecirityRoleDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public SecurityRole getRoleByName(String name) throws EntityNotFoundException {
        Query query = entityManager.createQuery("from SecurityRole where name=:name");
        query.setParameter("name", name);

        return (SecurityRole)query.getSingleResult();
    }
}
