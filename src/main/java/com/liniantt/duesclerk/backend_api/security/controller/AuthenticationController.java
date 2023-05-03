/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote AuthenticationController controller class
 * @created 01/05/2023
 * @see
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.security.controller;

import com.liniantt.duesclerk.backend_api.security.dto.input.AuthRegistrationRequest;
import com.liniantt.duesclerk.backend_api.security.dto.input.AuthenticationRequest;
import com.liniantt.duesclerk.backend_api.security.dto.output.AuthenticationResponse;
import com.liniantt.duesclerk.backend_api.security.entity.AuthUser;
import com.liniantt.duesclerk.backend_api.security.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api/v1/auth")
public class AuthenticationController {

  private final AuthenticationService authenticationService;

  /**
   * Registers a new authorization user.
   *
   * @param authRegistrationRequest Registration request body containing the user's details.
   * @return ResponseEntity<AuthenticationResponse>
   */
  @Operation(summary = "Register authorization user")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Authentication successful",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = AuthUser.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid inputs supplied",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            responseCode = "404",
            description = "Incorrect user details",
            content = @Content(mediaType = "application/json"))
      })
  @PostMapping(path = "/register", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<AuthenticationResponse> register(
      @Parameter(description = "Registration request body", required = true) @RequestBody @Valid
          AuthRegistrationRequest authRegistrationRequest) {

    return ResponseEntity.ok(authenticationService.registerAuthUser(authRegistrationRequest));
  }

  /**
   * Method to authenticate authorization user
   *
   * @param authenticationRequest - Authentication request body containing the authentication
   *     details.
   * @return ResponseEntity<AuthenticationResponse>
   */
  @Operation(summary = "Authenticate authorization user")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Authentication successful",
            content = {
              @Content(
                  mediaType = "application/json",
                  schema = @Schema(implementation = AuthenticationResponse.class))
            }),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid inputs supplied",
            content = @Content),
        @ApiResponse(
            responseCode = "404",
            description = "Incorrect user details",
            content = @Content)
      })
  @PostMapping(path = "/authenticate")
  public ResponseEntity<AuthenticationResponse> authenticate(
      @RequestBody @Valid AuthenticationRequest authenticationRequest) {
    return ResponseEntity.ok(authenticationService.authenticateAuthUser(authenticationRequest));
  }
}
