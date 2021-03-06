package pl.edu.pk.knit.android.backend.webservice.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.knit.android.backend.webservice.model.User;
import pl.edu.pk.knit.android.backend.webservice.service.UserService;

import javax.persistence.NoResultException;
import javax.servlet.http.HttpSession;
import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class UserRestController {

    @Autowired
    private UserService userService;

    @GetMapping(path = "/user")
    public Iterable<User> getUsers(){
        return userService.getAllUsers();
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<?> getUserById(
            @PathVariable Long userId
    ){
        try{
            User user = userService.getUserById(userId);
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (NoResultException exception){
            String errorMessage = "User with id " + userId + " not found";
            return new ResponseEntity<>(errorMessage, HttpStatus.NOT_FOUND);
        }

    }

    @GetMapping(path = "/whoami")
    public User getMyInformation() {
        UserDetails userDetails =
                (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        return userService.getUserByName( userDetails.getUsername() );
    }

    @GetMapping(value = "/logout")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void logout(HttpSession session) {
        session.invalidate();
    }

}
