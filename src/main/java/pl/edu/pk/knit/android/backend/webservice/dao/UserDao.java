package pl.edu.pk.knit.android.backend.webservice.dao;

import org.springframework.data.repository.CrudRepository;
import pl.edu.pk.knit.android.backend.webservice.model.User;


public interface UserDao extends CrudRepository<User, Long> {

    User findDistinctByUsername(String username);

}
