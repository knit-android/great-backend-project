package pl.edu.pk.knit.android.backend.webservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "security_privileges")
@ToString @EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
public class SecurityPrivilege implements GrantedAuthority {

  @Id
  @Column(name = "security_privilege_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private long id;

  @Column(name = "security_privilege_name")
  @Getter @Setter
  private String name;


  @Override
  @JsonIgnore
  public String getAuthority() {
    return name;
  }
}
