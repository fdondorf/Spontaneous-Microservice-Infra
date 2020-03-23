package org.spontaneous.serviceinfra.auth.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import javax.inject.Inject;
import javax.inject.Named;

import org.spontaneous.serviceinfra.auth.entity.RoleEntity;
import org.spontaneous.serviceinfra.auth.entity.UserEntity;
import org.spontaneous.serviceinfra.auth.repository.api.UserRepository;
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

  @Inject
  private UserRepository userRepository;

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    
    UserEntity userEntity = this.userRepository.findByEmail(username)
    		.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));

    Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
    grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
    for (RoleEntity roleEntity : userEntity.getRoles()) {
    	GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roleEntity.getName());
        grantedAuthorities.add(grantedAuthority);
    }
        
    UserDetails userDetails = new User(userEntity.getEmail(), userEntity.getPassword(), grantedAuthorities);
    
    return userDetails;
  }

}