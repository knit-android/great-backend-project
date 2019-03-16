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

        if(userContainer.isPresent())
            return userContainer.get();
        else
            return null;
    }

    @Override
    public User getUserByName(String username) {

        return userDao.findDistinctByUsername(username);
    }

    @Override
    public void saveNewUser(UserDto userDto) {
        User newUser = new User();

        newUser.setUsername(userDto.getUsername());
        newUser.setPassword(passwordEncoder.encode( userDto.getPassword() ));

        ArrayList<SecurityRole> roles = new ArrayList<SecurityRole>();
            roles.add(securityService.getRoleByName("ROLE_USER"));

        newUser.setSecurityRoles( roles );
        newUser.setEnabled( true );

        userDao.save(newUser);

    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return getUserByName(username);
    }
}
