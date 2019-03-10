package pl.edu.pk.knit.android.backend.webservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.edu.pk.knit.android.backend.webservice.dao.SecirityRoleDao;
import pl.edu.pk.knit.android.backend.webservice.dao.UserDao;
import pl.edu.pk.knit.android.backend.webservice.model.SecurityRole;
import pl.edu.pk.knit.android.backend.webservice.model.User;
import pl.edu.pk.knit.android.backend.webservice.model.UserDto;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

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
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public User getUserById(long id) {
        return userDao.getUserById(id);
    }

    @Override
    public User getUserByName(String username) {

        return userDao.getUserByName(username);
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
