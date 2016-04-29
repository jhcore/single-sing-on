package devonfw.SSOSample.general.configuration;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import devonfw.SSOSample.general.common.api.security.UserData;

/**
 * TODO jhcore This type ...
 *
 * @author jhcore
 * @since 0.1
 */
public class UserDetailsServiceImpl implements UserDetailsService {
  // @Inject
  // private AccessControlProvider accessControlProvider;

  private static final Logger LOG = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    ArrayList<String> groups = new ArrayList<>();

    groups.add("Chief");

    // determine granted authorities for spring-security...
    Set<GrantedAuthority> authoritiesAD = new HashSet<>();
    // Collection<String> accessControlIds = groups;
    // Set<AccessControl> accessControlSet = new HashSet<>();
    // for (String id : accessControlIds) {
    // boolean success = false;// this.accessControlProvider.collectAccessControls(id, accessControlSet);
    // if (!success) {
    // LOG.warn("Undefined access control {}.", id);
    // // authorities.add(new SimpleGrantedAuthority(id));
    // }
    // }
    // for (AccessControl accessControl : accessControlSet) {
    // authoritiesAD.add(new AccessControlGrantedAuthority(accessControl));
    // }
    // Buscamos en base de datos
    return new UserData(username, username, authoritiesAD);
  }

}
