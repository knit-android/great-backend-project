package pl.edu.pk.knit.android.backend.webservice.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.knit.android.backend.webservice.model.User;
import pl.edu.pk.knit.android.backend.webservice.model.UserDto;
import pl.edu.pk.knit.android.backend.webservice.service.UserService;

@Controller
@RequestMapping(path = "/panel")
public class PanelController {

    @Autowired
    private UserService userService;


    @GetMapping("/register")
    public String showMyLoginPage(Model theModel) {

        theModel.addAttribute("UserDto", new UserDto());

        return "registration-form";
    }

    @PostMapping("/register")
    public String processRegistrationForm(
            @ModelAttribute("UserDto") UserDto userDto,
            BindingResult theBindingResult,
            Model theModel,
            @RequestParam(name="secret") String secret) {

        if(!secret.equals("2626+56513215621afcsa")){
            theModel.addAttribute("registrationError", "Invalid secret.");
            return "registration-form";
        }


        String userName = userDto.getUsername();

        // check the database if user already exists
        User existing = userService.getUserByName(userName);
        if (existing != null){
            theModel.addAttribute("user-details", new UserDto());
            theModel.addAttribute("registrationError", "User name already exists.");
            return "registration-form";
        }
        // create user account
        userService.saveNewUser(userDto);

        return "registration-confirmation";
    }

    @GetMapping(path = "/")
    public String homePage(Model model){

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
            String username = (String)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            model.addAttribute("user-details", userService.getUserByName(username));
        }

        return "home-page";
    }

}
