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
@RequestMapping("/users/secure")
@Consumes(value = MediaType.APPLICATION_JSON_VALUE)
@Produces(value = MediaType.APPLICATION_JSON_VALUE)
public class UserController {

  
  @Inject
  private UserRepository userRepository;

  @Inject
  private RoleRepository roleRepository;
  
  @Inject
  private PasswordEncoder passwordEncoder;
  
  @GetMapping("/current")
  public Principal getUser(Principal principal) {

    return principal;
  }


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
