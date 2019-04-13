package pl.edu.pk.knit.android.backend.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.pk.knit.android.backend.webservice.dao.UserDao;
import pl.edu.pk.knit.android.backend.webservice.model.SecurityRole;
import pl.edu.pk.knit.android.backend.webservice.model.User;
import pl.edu.pk.knit.android.backend.webservice.model.UserDto;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;
    @Autowired
    private SecurityService securityService;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Iterable<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User getUserById(long id) {
        Optional<User> userContainer = userDao.findById(id);

        return userContainer.orElse(null);
    }

    @Override
    public User getUserByName(String username) {

        return userDao.findDistinctByUsername(username);
    }

    @Override
    public User saveNewUser(UserDto userDto) {
        User newUser = new User();

        String colorString = userDto.getColor().trim().toLowerCase();


        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(passwordEncoder.encode( userDto.getPassword() ));

        ArrayList<SecurityRole> roles = new ArrayList<>();
            roles.add(securityService.getRoleByName("ROLE_USER"));

        newUser.setSecurityRoles( roles );
        newUser.setEnabled( true );

        return userDao.save(newUser);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserByName(username);
    }
}
