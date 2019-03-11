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
@EqualsAndHashCode @ToString
@AllArgsConstructor @NoArgsConstructor
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
  }

  @Override
  @JsonIgnore
  public Collection<GrantedAuthority> getAuthorities() {
    List<GrantedAuthority> authorities = new ArrayList<>();

    for(SecurityRole role : securityRoles){

      authorities.add(role);

      for(SecurityPrivilege priv : role.getPrivileges())
        authorities.add(priv);

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
}
