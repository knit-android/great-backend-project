package pl.edu.pk.knit.android.backend.webservice.dao;

import pl.edu.pk.knit.android.backend.webservice.model.User;
import java.util.List;


public interface UserDao {

    public List<User> getAllUsers();
    public User getUserById(long id);
    public User getUserByName(String username);

    public void save(User newUser);
}
