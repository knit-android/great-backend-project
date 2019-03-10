package pl.edu.pk.knit.android.backend.webservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "security_roles")
@ToString @EqualsAndHashCode
@AllArgsConstructor @NoArgsConstructor
public class SecurityRole {

  @Id
  @Column(name = "security_role_id")
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Getter
  private long id;

  @Column(name = "security_role_name")
  @Getter @Setter
  private String name;

  @ManyToMany(fetch = FetchType.EAGER)
  @JoinTable(name = "security_roles_to_privileges",
      joinColumns = @JoinColumn(name = "security_role_id"),
      inverseJoinColumns = @JoinColumn(name = "security_privilege_id"))
  @Getter @Setter
  private Collection<SecurityPrivilege> privileges;
}
