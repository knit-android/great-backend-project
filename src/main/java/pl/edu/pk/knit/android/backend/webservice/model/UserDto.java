package pl.edu.pk.knit.android.backend.webservice.model;

import lombok.*;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @Size(min = 3, max = 50)
    private String username;

    @Size(min = 5, max = 50)
    private String password;

    @Pattern(regexp = "^([a-f]|[0-9]){6}$")
    private String color;

}
