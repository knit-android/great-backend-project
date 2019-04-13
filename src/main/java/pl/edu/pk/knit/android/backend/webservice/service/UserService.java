package pl.edu.pk.knit.android.backend.webservice.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import pl.edu.pk.knit.android.backend.webservice.model.User;
import pl.edu.pk.knit.android.backend.webservice.model.UserDto;

public interface UserService extends UserDetailsService {
    Iterable<User> getAllUsers();
    User getUserById(long id);
    User getUserByName(String username);

    User saveNewUser(UserDto userDto);
}
