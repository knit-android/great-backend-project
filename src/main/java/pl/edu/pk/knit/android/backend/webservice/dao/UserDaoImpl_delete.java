package pl.edu.pk.knit.android.backend.webservice.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.edu.pk.knit.android.backend.webservice.model.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class UserDaoImpl_delete {
    /*
    @Autowired
    private EntityManager entityManager;

    @Override
    public List<User> getAllUsers() {
        Query session = entityManager.createQuery("from User", User.class);

        return session.getResultList();
    }

    @Override
    public User getUserById(long id) {
        Query query =  entityManager.createQuery("from User where user_id=:id", User.class);
        query.setParameter("id", id);

        return (User)query.getSingleResult();
    }

    @Override
    public User getUserByName(String username) {
        Query query =  entityManager.createQuery("from User where username=:name", User.class);
        query.setParameter("name", username);

        List<Query> results = query.getResultList();
        if(results.size() == 0)
            return null;
        else
            return (User)results.get(0);

    }

    @Override
    public void save(User newUser) {
        entityManager.persist(newUser);
    }
    */

}
