/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote JwtService class
 * @created 01/05/2023
 * @see com.liniantt.duesclerk.backend_api.security.service_impl.JwtServiceImpl
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.security.service;

import io.jsonwebtoken.Claims;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.util.Map;
import java.util.function.Function;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface JwtService {

  /**
   * Method to check if JWT token is valid
   *
   * @param jwtToken - JWT token
   * @param userDetails - UserDetails
   * @return boolean - JWT valid/invalid
   */
  @Operation(description = "Check if JWT token is valid")
  boolean isTokenValid(
      @Parameter(
              name = "jwtToken",
              description = "JWT token",
              required = true,
              allowEmptyValue = false)
          String jwtToken,
      @Parameter(
              name = "userDetails",
              description = "UserDetails interface",
              required = true,
              allowEmptyValue = false)
          UserDetails userDetails);

  /**
   * Method to generate token without extra claims
   *
   * @param userDetails - UserDetails
   * @return String
   */
  @Operation(description = "Generates token without extra claims")
  String generateToken(
      @Parameter(
              name = "userDetails",
              description = "UserDetails interface",
              required = true,
              allowEmptyValue = false)
          @NonNull
          UserDetails userDetails);

  /**
   * Method to generate token JWT token
   *
   * @param extraClaims - Extra claims
   * @param userDetails - UserDetails
   * @return String
   */
  @Operation(description = "Generates JWT token")
  String generateToken(
      @Parameter(
              name = "extraClaims",
              description = "Extra token claims",
              required = true,
              allowEmptyValue = false)
          Map<String, Object> extraClaims,
      @Parameter(
              name = "userDetails",
              description = "UserDetails entity",
              required = true,
              allowEmptyValue = false)
          UserDetails userDetails);

  /**
   * Method to extract username from JWT token
   *
   * @param jwtToken - JWT token
   * @return String - username
   */
  @Operation(description = "Extract username from JWT token")
  String extractUsername(
      @Parameter(
              name = "jwtToken",
              description = "JWT token to extract username from",
              required = true,
              allowEmptyValue = false)
          @NonNull
          String jwtToken);

  /**
   * Method to extract a single claim
   *
   * @param jwtToken - JWT token
   * @param claimsResolver - ClaimResolver
   * @return Generics
   */
  @Operation(description = "Extracts a single claim from the jwtToken")
  <T> T extractClaim(
      @Parameter(
              name = "jwtToken",
              description = "JWT token",
              required = true,
              allowEmptyValue = false)
          @NonNull
          String jwtToken,
      @Parameter(
              name = "claimsResolver",
              description = "Claims resolver",
              required = true,
              allowEmptyValue = false)
          @NonNull
          Function<Claims, T> claimsResolver);
}
