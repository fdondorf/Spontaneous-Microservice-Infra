package org.spontaneous.serviceinfra.auth.service.api.rest.exception;

/**
 * Exception when user not found in db
 *
 * @author fdondorf
 */
public class UserNotFoundException extends ApplicationException {

  private static final long serialVersionUID = -454266469953764370L;

  /**
   * Instantiates a new UserNotFoundException
   *
   * @param msg the msg
   */
  public UserNotFoundException(String msg) {
    super(msg);
  }
  
  public UserNotFoundException(String msg, Throwable t) {
    super(msg, t);
  }

	@Override
	public String getErrorCode() {
		return "no_user";
	}
}
