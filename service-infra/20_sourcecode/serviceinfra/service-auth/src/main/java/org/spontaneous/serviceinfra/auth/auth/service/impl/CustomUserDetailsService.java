package org.spontaneous.serviceinfra.auth.auth.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Named;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * @author Florian Dondorf
 *
 */
@Named
public class CustomUserDetailsService implements UserDetailsService {

  // @Inject
  // private final UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority("ROLE_USER");
    grantedAuthorities.add(grantedAuthority);

    String password = "$2y$12$8Mh2Fx/plnWPNPpOC7G6CeKabFpQp4Vxd6Wk92kxYUJQOLt.oYgQC";
    UserDetails userDetails = new User(username, password, grantedAuthorities);
    // return this.userRepository.findByUsername(username)
    // .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));

    return userDetails;
  }

}