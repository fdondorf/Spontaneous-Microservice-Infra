package org.spontaneous.serviceinfra.auth.service.impl;

import java.util.ArrayList;
import java.util.Collection;


import org.spontaneous.serviceinfra.auth.dataaccess.api.UserEntity;
import org.spontaneous.serviceinfra.auth.dataaccess.api.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author Florian Dondorf
 *
 */
@Service
public class CustomUserDetailsService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserEntity userEntity = this.userRepository.findByEmail(username)
				.orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));

		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>();
		// grantedAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		// for (RoleEntity roleEntity : userEntity.getRoles()) {
		// GrantedAuthority grantedAuthority = new
		// SimpleGrantedAuthority(roleEntity.getName());
		// grantedAuthorities.add(grantedAuthority);
		// }
		//
		UserDetails userDetails = new User(userEntity.getEmail(), userEntity.getPassword(), grantedAuthorities);

		return userDetails;
	}

}