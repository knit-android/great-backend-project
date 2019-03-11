package pl.edu.pk.knit.android.backend.webservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.pk.knit.android.backend.webservice.model.SecurityRole;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.util.List;

@Repository
public class SecirityRoleDaoImpl implements SecirityRoleDao {
    @Autowired
    private EntityManager entityManager;

    @Override
    public SecurityRole getRoleByName(String name) throws EntityNotFoundException {
        Query query = entityManager.createQuery("from SecurityRole where name=:name", SecurityRole.class);
        query.setParameter("name", name);

        List<SecurityRole> result = query.getResultList();

        if(result.size() == 0)
            throw new EntityNotFoundException();

        return result.get(0);
    }
}
