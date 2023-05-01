/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote AuthenticationService class
 * @created 01/05/2023 - 10:30 AM UTC-4
 * @see
 * @since 1.0.0
 */

package com.liniantt.duesclerk.backend_api.security.service;

import com.liniantt.duesclerk.backend_api.domain.enum_.UserRole;
import com.liniantt.duesclerk.backend_api.security.dto.input.AuthRegistrationRequest;
import com.liniantt.duesclerk.backend_api.security.dto.input.AuthenticationRequest;
import com.liniantt.duesclerk.backend_api.security.dto.output.AuthenticationResponse;
import com.liniantt.duesclerk.backend_api.security.entity.AuthUser;
import com.liniantt.duesclerk.backend_api.security.repository.UserAuthenticationRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.lang.NonNull;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {

  private final JwtService jwtService;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;
  private final UserAuthenticationRepository userAuthenticationRepository;

  /**
   * Method to register Auth user
   *
   * @param authRegistrationRequest - request body
   * @return AuthenticationResponse
   */
  public AuthenticationResponse registerAuthUser(
      @Parameter(name = "AuthRegistrationRequest", description = "request body") final @NonNull AuthRegistrationRequest authRegistrationRequest) {

    // Create user object
    var authenticationUser = AuthUser.builder()
        .username(authRegistrationRequest.getUsername())
        .password(passwordEncoder.encode(authRegistrationRequest.getPassword()))
        .userRole(UserRole.ORDINARY_USER)
        .build();

    userAuthenticationRepository.save(authenticationUser);

    var jwtToken = jwtService.generateToken(authenticationUser); // generate JWT token

    return AuthenticationResponse.builder()
        .jwtToken(jwtToken)
        .build();
  }

  /**
   * Method to authenticate AUTH user
   *
   * @param authenticationRequest - Request body
   * @return AuthenticationResponse
   */
  @Operation(summary = "Authenticate AUTH user")
  public AuthenticationResponse authenticateAuthUser(
      @Parameter(name = "AuthenticationRequest", description = "Request body") final @NonNull AuthenticationRequest authenticationRequest) {

    authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            authenticationRequest.getUsername(),
            authenticationRequest.getPassword()
        )
    );

    var authenticatedUser = userAuthenticationRepository.findByUsername(authenticationRequest.getUsername())
        .orElseThrow(
            () -> new UsernameNotFoundException("No user found with username : " + authenticationRequest.getUsername())
        );

    var jwtToken = jwtService.generateToken(authenticatedUser); // Generate JWT token

    return AuthenticationResponse.builder()
        .jwtToken(jwtToken)
        .build();
  }
}
