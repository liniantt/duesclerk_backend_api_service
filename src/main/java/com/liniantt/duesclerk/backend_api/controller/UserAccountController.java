/**
 * @apiNote UserAccountController class
 * @author David Kariuki
 * @version 1.0.0
 * @created 29/04/2023
 * @see com.liniantt.duesclerk.backend_api.service.UserAccountService - Controller class
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.controller;

import com.liniantt.duesclerk.backend_api.dto.input.RegisterUserRequestBody;
import com.liniantt.duesclerk.backend_api.dto.output.UserRegistrationResponse;
import com.liniantt.duesclerk.backend_api.service.UserAccountService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SecurityScheme(
    name = "bearerAuth",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT")
@OpenAPIDefinition(
    info = @Info(title = "User registration API endpoint class"),
    security = @SecurityRequirement(name = "bearerAuth"))
@RequestMapping(path = "/api/v1/user")
@RequiredArgsConstructor
public class UserAccountController {

  private final UserAccountService userAccountService;

  /**
   * Method to register application users
   *
   * @param registerUserRequestBody - Registration request body
   * @see UserAccountService
   * @return ResponseEntity<RegisterUserResponse>
   */
  @Operation(
      operationId = "registerUser",
      summary = "Register users",
      description = "Endpoint to register a new user with the application",
      method = "POST",
      requestBody =
          @RequestBody(
              required = true,
              content =
                  @Content(
                      mediaType = MediaType.APPLICATION_JSON_VALUE,
                      schema = @Schema(implementation = RegisterUserRequestBody.class))),
      responses = {
        @ApiResponse(
            responseCode = "200",
            description = "User registration successful",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = UserRegistrationResponse.class))),
        @ApiResponse(
            responseCode = "400",
            description = "Invalid request parameters",
            content =
                @Content(
                    mediaType = MediaType.APPLICATION_JSON_VALUE,
                    schema = @Schema(implementation = ErrorResponse.class)))
      },
      parameters = {
        @Parameter(
            name = "registerUserRequestBody",
            description = "user registration request body",
            required = true,
            content = @Content,
            schema = @Schema(implementation = RegisterUserRequestBody.class),
            in = ParameterIn.DEFAULT)
      })
  @PostMapping(
      path = "/register",
      consumes = MediaType.APPLICATION_JSON_VALUE,
      produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<UserRegistrationResponse> registerUser(
      @Valid @org.springframework.web.bind.annotation.RequestBody
          RegisterUserRequestBody registerUserRequestBody) {

    return ResponseEntity.ok(userAccountService.registerUser(registerUserRequestBody));
  }
}
