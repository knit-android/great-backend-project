package pl.edu.pk.knit.android.backend.webservice.controler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import pl.edu.pk.knit.android.backend.webservice.model.LastLocation;
import pl.edu.pk.knit.android.backend.webservice.model.User;
import pl.edu.pk.knit.android.backend.webservice.service.LastLocationService;
import pl.edu.pk.knit.android.backend.webservice.service.UserService;

import javax.xml.stream.Location;
import java.time.LocalDate;

@RestController
@RequestMapping("/api/location")
public class LastLocationController {
    @Autowired
    private LastLocationService locationService;
    @Autowired
    private UserService userService;

    @GetMapping
    public Iterable<LastLocation> getAllLocations(){
        return locationService.getAllLocations();
    }

    @PostMapping
    public void saveLocation(@ModelAttribute LastLocation newLocation){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.getUserByName(auth.getName());

        newLocation.setUserId(user.getUserId());
        newLocation.setReportTime(LocalDate.now());

        locationService.saveLocation(newLocation);
    }

}