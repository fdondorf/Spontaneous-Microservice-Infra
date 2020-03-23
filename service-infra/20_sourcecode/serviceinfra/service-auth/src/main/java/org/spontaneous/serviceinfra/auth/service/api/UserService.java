package org.spontaneous.serviceinfra.auth.service.api;

import org.spontaneous.serviceinfra.auth.service.api.to.UserDto;

/**
 * @author Florian Dondorf
 *
 */
public interface UserService {

  /**
   * Creates a new user.
   *
   * @param userTo
   * @return
   */
  public UserDto createUser(UserDto userTo);
}
