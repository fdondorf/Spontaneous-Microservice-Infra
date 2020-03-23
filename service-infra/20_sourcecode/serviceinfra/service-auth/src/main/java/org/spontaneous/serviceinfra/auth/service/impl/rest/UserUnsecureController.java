package org.spontaneous.serviceinfra.auth.service.impl.rest;

import java.security.Principal;
import java.util.Arrays;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

import org.spontaneous.serviceinfra.auth.entity.UserEntity;
import org.spontaneous.serviceinfra.auth.repository.api.RoleRepository;
import org.spontaneous.serviceinfra.auth.repository.api.UserRepository;
import org.spontaneous.serviceinfra.auth.service.api.Gender;
import org.spontaneous.serviceinfra.auth.service.api.User;
import org.spontaneous.serviceinfra.auth.service.api.UserService;
import org.spontaneous.serviceinfra.auth.service.api.to.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Florian Dondorf
 *
 */
@RestController
@RequestMapping("/users")
@Consumes(value = MediaType.APPLICATION_JSON_VALUE)
@Produces(value = MediaType.APPLICATION_JSON_VALUE)
public class UserUnsecureController {

  @Inject
  private UserService userService;
  
  @Inject
  private UserRepository userRepository;

  @Inject
  private RoleRepository roleRepository;
  
  @Inject
  private PasswordEncoder passwordEncoder;
  
  /**
   * Method for providing a rest interface for register a new user
   *
   * @param userTO The user to register
   * @return Returns a ResponseEntity
   */
//@PreAuthorize("#oauth2.hasScope('tracking')")
@PostMapping("/createUser")
public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
	//LOG.debug("Calling Controller 'registerUser'");

	//TODO: Validation and Check der App-Version
	
	String password = passwordEncoder.encode(userDto.getPassword());
	
	UserEntity user = new UserEntity(userDto.getFirstname(), userDto.getLastname(), 
			userDto.getEmail(), password, Arrays.asList(roleRepository.findByName("ROLE_USER")),
			userDto.getGender() != null ? Gender.fromName(userDto.getGender()) : Gender.MALE);
	UserEntity savedUser = userRepository.save(user);
	
	UserDto result = new UserDto();
	result.setId(savedUser.getId());
	result.setFirstname(savedUser.getFirstName());
	result.setLastname(savedUser.getLastName());
	
	ResponseEntity<UserDto> response = new ResponseEntity<UserDto>(result, HttpStatus.OK);
	
	return response;
}

//  @PostMapping
//  @PreAuthorize("#oauth2.hasScope('server')")
//  public UserDto createUser(@Valid @RequestBody UserDto userRegistration) {
//
//    User savedUser = this.userRepository.save(userEntity);
//    return toDto(savedUser);
//  }

  private UserDto toDto(User user) {

    UserDto userDto = new UserDto();
    userDto.setId(user.getId());
    userDto.setEmail(user.getEmail());
    return userDto;
  }

  private User toUser(UserDto userRegistration) {
	  //TODO: Mapping via Dozer
	  return null;
  }

}
