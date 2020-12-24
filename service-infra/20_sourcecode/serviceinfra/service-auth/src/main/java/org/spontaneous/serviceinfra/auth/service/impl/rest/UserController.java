package org.spontaneous.serviceinfra.auth.service.impl.rest;

import java.security.Principal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Florian Dondorf
 *
 */
@RestController
@RequestMapping("/users/secure")
public class UserController {

	@GetMapping("/current")
	public Principal getUser(Principal principal) {

		return principal;
	}
}
