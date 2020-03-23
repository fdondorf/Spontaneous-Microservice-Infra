package org.spontaneous.serviceinfra.auth.configuration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;

/**
 * Configuration for the OAuth2 ResourceServer.
 * <p>
 * Protected resources are ...
 *
 * @author Florian Dondorf
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

  @Value("spontaneous/secure")
  private String resourceId;

  @Override
  public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
    resources.resourceId(resourceId);
  }

  @Override
  public void configure(HttpSecurity http) throws Exception {
	  
	  http
      .authorizeRequests()
      .antMatchers("/users/secure/**").authenticated()
      .antMatchers("/users/**").anonymous();
	  
	  // add this line to use H2 web console
	  http.headers().frameOptions().disable();
	  
//	  http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().requestMatchers().antMatchers("/spontaneous/secure/**").and()
//        .authorizeRequests().antMatchers("/secure/**").hasAnyRole("USER", "ADMIN", "SUPERADMIN");
  }

}
