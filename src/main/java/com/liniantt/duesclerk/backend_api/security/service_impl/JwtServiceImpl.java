/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote JwtServiceImpl class
 * @created 01/05/2023
 * @see com.liniantt.duesclerk.backend_api.security.authentication_filter.JwtAuthenticationFilter
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.security.service_impl;

import com.liniantt.duesclerk.backend_api.configs.SecurityKeysConfiguration;
import com.liniantt.duesclerk.backend_api.security.service.JwtService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@SuppressWarnings("DefaultAnnotationParam")
@Service
public class JwtServiceImpl implements JwtService {

  /**
   * Method to check if JWT token is valid
   *
   * @param jwtToken - JWT token
   * @param userDetails - UserDetails
   * @return boolean - JWT valid/invalid
   */
  @Override
  @Operation(description = "Check if JWT token is valid")
  public boolean isTokenValid(
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
          UserDetails userDetails) {

    final String username = extractUsername(jwtToken);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken));
  }

  /**
   * Method to generate token without extra claims
   *
   * @param userDetails - UserDetails
   * @return String
   */
  @Override
  @Operation(description = "Generates token without extra claims")
  public String generateToken(
      @Parameter(
              name = "userDetails",
              description = "UserDetails interface",
              required = true,
              allowEmptyValue = false)
          @NonNull
          UserDetails userDetails) {

    return generateToken(new HashMap<>(), userDetails);
  }

  /**
   * Method to generate token JWT token
   *
   * @param extraClaims - Extra claims
   * @param userDetails - UserDetails
   * @return String
   */
  @Override
  @Operation(description = "Generates JWT token")
  public String generateToken(
      @Parameter(
              name = "extraClaims",
              description = "Extra token claims",
              required = true,
              allowEmptyValue = false)
          @NonNull
          Map<String, Object> extraClaims,
      @Parameter(
              name = "userDetails",
              description = "UserDetails entity",
              required = true,
              allowEmptyValue = false)
          @NonNull
          UserDetails userDetails) {

    return Jwts.builder()
        .setClaims(extraClaims)
        .setSubject(userDetails.getUsername()) // Should be username
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(
            new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // 24 hours plus E3 milliseconds
        .signWith(getSigningKey(), SignatureAlgorithm.HS512)
        .compact();
  }

  /**
   * Method to extract username from JWT token
   *
   * @param jwtToken - JWT token
   * @return String - username
   */
  @Override
  @Operation(description = "Extract username from JWT token")
  public String extractUsername(
      @Parameter(
              name = "jwtToken",
              description = "JWT token to extract username from",
              required = true,
              allowEmptyValue = false)
          @NonNull
          String jwtToken) {

    return extractClaim(jwtToken, Claims::getSubject);
  }

  /**
   * Method to extract a single claim
   *
   * @param jwtToken - JWT token
   * @param claimsResolver - ClaimResolver
   * @return Generics
   */
  @Operation(description = "Extracts a single claim from the jwtToken")
  public <T> T extractClaim(
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
          Function<Claims, T> claimsResolver) {

    final Claims claims = extractAllClaims(jwtToken);
    return claimsResolver.apply(claims);
  }

  /**
   * Method to check id token is expired
   *
   * @param jwtToken - JWT token
   * @return boolean
   */
  private boolean isTokenExpired(final @NonNull String jwtToken) {
    return extractClaim(jwtToken, Claims::getExpiration).before(new Date());
  }

  /**
   * Method to extract all claims from JWT token
   *
   * @param jwtToken - JWT token
   * @return Claims
   */
  private Claims extractAllClaims(String jwtToken) {
    return Jwts.parserBuilder()
        .setSigningKey(
            getSigningKey()) // Secret of size 256 to digitally sign the JWT - ascertain client is
        // valid
        .build()
        .parseClaimsJws(jwtToken)
        .getBody();
  }

  /**
   * Method to get signing key
   *
   * @return Key - signing key
   */
  private Key getSigningKey() {
    byte[] keyBytes =
        Base64.getDecoder().decode(new SecurityKeysConfiguration().getJWT_SECRET_KEY());
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
