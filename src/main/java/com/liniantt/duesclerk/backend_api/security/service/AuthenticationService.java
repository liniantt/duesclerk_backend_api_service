/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote AuthenticationService interface class
 * @created 01/05/2023
 * @see com.liniantt.duesclerk.backend_api.security.service_impl.AuthenticationServiceImpl
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.security.service;

import com.liniantt.duesclerk.backend_api.security.dto.input.AuthRegistrationRequest;
import com.liniantt.duesclerk.backend_api.security.dto.input.AuthenticationRequest;
import com.liniantt.duesclerk.backend_api.security.dto.output.AuthenticationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

@Service
public interface AuthenticationService {

  /**
   * Method to register Auth user
   *
   * @param authRegistrationRequest - request body
   * @return AuthenticationResponse
   */
  AuthenticationResponse registerAuthUser(
      @Parameter(name = "AuthRegistrationRequest", description = "request body")
          final @NonNull AuthRegistrationRequest authRegistrationRequest);

  /**
   * Method to authenticate AUTH user
   *
   * @param authenticationRequest - Request body
   * @return AuthenticationResponse
   */
  @Operation(summary = "Authenticate AUTH user")
  AuthenticationResponse authenticateAuthUser(
      @Parameter(name = "AuthenticationRequest", description = "Request body")
          final @NonNull AuthenticationRequest authenticationRequest);
}
