/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote ApplicationConfiguration class
 * @created 01/05/2023
 * @since 1.0.0
 */

package com.liniantt.duesclerk.backend_api.configs;

import com.liniantt.duesclerk.backend_api.security.repository.UserAuthenticationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@RequiredArgsConstructor
public class ApplicationConfiguration {

  private final UserAuthenticationRepository userAuthenticationRepository;

  /**
   * Bean to initialize the UserDetailsService
   *
   * @return UserDetailsService
   * @throws UsernameNotFoundException - If user not found
   */
  @Bean
  public UserDetailsService userDetailsService() throws UsernameNotFoundException {
    return username -> userAuthenticationRepository.findByUsername(username)
        .orElseThrow(
            () -> new UsernameNotFoundException("User not found with username : " + username)
        );
  }

  /**
   * Bean data access object responsible for fetching user details and encoding user password
   *
   * @return DaoAuthenticationProvider
   */
  @Bean
  public AuthenticationProvider authenticationProvider() {

    DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();

    // Set what user details service to use to get user details in case of multiple implementations
    // of the user details e.g., getting info from the database, or different profiles fetching data
    // from the in-memory database, LDAP etc.
    daoAuthenticationProvider.setUserDetailsService(userDetailsService());

    daoAuthenticationProvider.setPasswordEncoder(passwordEncoder()); // Set password encoder to be used

    return daoAuthenticationProvider;
  }

  /**
   * Bean to authenticate the passed Authentication object
   *
   * @return AuthenticationManager
   * @throws Exception - exception
   */
  @Bean
  public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
    return authenticationConfiguration.getAuthenticationManager();
  }


  /**
   * Bean for password encoding with BCryptPasswordEncoder
   *
   * @return BCryptPasswordEncoder
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
}
