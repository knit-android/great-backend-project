package pl.edu.pk.knit.android.backend.webservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;


@Entity
@Table(name = "users")
@ToString @AllArgsConstructor @NoArgsConstructor
public class User implements UserDetails {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    private long userId;

    @Column(name = "username")
    @Getter @Setter
    private String username;

    @Column(name = "password")
    @Getter @Setter
    @JsonIgnore
    private String password;

    @Column(name = "enabled")
    @Getter @Setter
    private boolean enabled;

    @Column(name = "color")
    @Getter @Setter
    private String color;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "security_users_to_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "security_role_id")
    )
    @Getter @Setter
    private List<SecurityRole> securityRoles;





    public User(User user) {
        this.userId = user.userId;
        this.username = user.username;
        this.password = user.password;
        this.enabled = user.enabled;
        this.color = user.color;
    }

    @Override
    @JsonIgnore
    public Collection<GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();

        for(SecurityRole role : securityRoles){

            authorities.add(role);
            authorities.addAll(role.getPrivileges());

        }

        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean equals(Object obj) {
        if( !( obj instanceof User ) )
            return false;

        User other = (User) obj;

        return other.getUsername().equals(this.getUsername());
    }

    @Override
    public int hashCode() {
        int hashCode = 1;

        hashCode *= 37 + this.userId;
        hashCode *= 37 + this.username.hashCode();
        hashCode *= 37 + this.color.hashCode();

        return hashCode;
    }
}
