package org.spontaneous.serviceinfra.auth.configuration;

import org.spontaneous.serviceinfra.auth.service.impl.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

/**
 * Spring WebSecurity configuration.
 *
 * @author Florian Dondorf
 *
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Autowired
  private CustomUserDetailsService userDetailsService;

  @Override
  protected void configure(HttpSecurity http) throws Exception {

//     http.headers().addHeaderWriter(new StaticHeadersWriter("Server", "Spontaneous Auth Service"));
//     http.requestMatchers().antMatchers("/uaa/spontaneous/secure/**");
//     http.csrf().disable();
//     http.httpBasic();
     
	  http
      .authorizeRequests()
      .anyRequest().authenticated()
      //.antMatchers("/users/**").authenticated()
      //.antMatchers("/users/**").permitAll()
      .and().httpBasic();

     // add this line to use H2 web console
     http.headers().frameOptions().disable();

  }

  @Override
  public void configure(AuthenticationManagerBuilder auth) throws Exception {

    auth.userDetailsService(this.userDetailsService).passwordEncoder(passwordEncoder());
  }

  /**
   * Defines the authenticationManagerBean bean.
   *
   * @return the authenticationManagerBean bean
   */
  @Override
  @Bean
  public AuthenticationManager authenticationManagerBean() throws Exception {

    return super.authenticationManagerBean();
  }

  @Bean
  public PasswordEncoder passwordEncoder() {

    return new BCryptPasswordEncoder();
  }

}
