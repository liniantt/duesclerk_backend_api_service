/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote AuthTestController class
 * @created 02/05/2023
 * @see com.liniantt.duesclerk.backend_api.security.service.AuthenticationService
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.security.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.util.Map;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthTestController {

  /**
   * Method to test authentication
   *
   * @return ResponseEntity<String>
   */
  @Operation(description = "Test authentication endpoint")
  @ApiResponses(
      value = {
        @ApiResponse(
            responseCode = "200",
            description = "Authentication successful",
            content = {@Content(mediaType = "application/json")}),
        @ApiResponse(
            responseCode = "403",
            description = "Forbidden",
            content = {@Content(mediaType = "application/json")})
      })
  @GetMapping(path = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> testAuthentication() {

    return ResponseEntity.status(HttpStatus.OK)
        .body(Map.of("error", false, "message", "Authentication successful!"));
  }
}
