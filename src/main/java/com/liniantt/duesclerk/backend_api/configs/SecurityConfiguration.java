/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote SecurityConfiguration class
 * @created 01/05/2023
 * @see
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.configs;

import com.liniantt.duesclerk.backend_api.security.authentication_filter.JwtAuthenticationFilter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  private final JwtAuthenticationFilter jwtAuthenticationFilter;
  private final AuthenticationProvider authenticationProvider;

  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
    httpSecurity
        .csrf()
        .disable()
        .authorizeHttpRequests()

        // Permit requests below without authentication
        .requestMatchers(HttpMethod.POST, "/api/v1/auth/register")
        .permitAll()
        .requestMatchers(HttpMethod.POST, "/api/v1/auth/authenticate")
        .permitAll()

        // Authenticate the rest below
        .anyRequest()
        .authenticated()
        .and()
        .sessionManagement()

        // Create new session for each request
        .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and()
        .authenticationProvider(authenticationProvider)

        // Use JWT before UsernamePasswordAuthenticationFilter to check for all
        // requirements and update
        .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

    return httpSecurity.build();
  }
}
