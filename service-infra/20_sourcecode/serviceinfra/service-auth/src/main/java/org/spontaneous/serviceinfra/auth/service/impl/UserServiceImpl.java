package org.spontaneous.serviceinfra.auth.service.impl;

import java.util.Random;

import javax.inject.Named;

import org.spontaneous.serviceinfra.auth.service.api.UserService;
import org.spontaneous.serviceinfra.auth.service.api.to.UserDto;

/**
 * @author Florian Dondorf
 *
 */
@Named
public class UserServiceImpl implements UserService {

  @Override
  public UserDto createUser(UserDto userTo) {

    // TODO: Implement me!!!
    userTo.setId(new Random().nextLong());
    return userTo;
  }

}
