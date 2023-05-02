/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote JwtService class
 * @created 01/05/2023
 * @see com.liniantt.duesclerk.backend_api.security.authentication_filter.JwtAuthenticationFilter
 * @since 1.0.0
 */

package com.liniantt.duesclerk.backend_api.security.service;

import com.liniantt.duesclerk.backend_api.configs.SecurityKeysConfiguration;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.lang.NonNull;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {

  /**
   * Method to check if JWT token is valid
   *
   * @param jwtToken    - JWT token
   * @param userDetails - UserDetails
   * @return boolean - JWT valid/invalid
   */
  public boolean isTokenValid(String jwtToken, UserDetails userDetails) {
    final String username = extractUsername(jwtToken);
    return (username.equals(userDetails.getUsername()) && !isTokenExpired(jwtToken));
  }

  /**
   * Method to check id token is expired
   *
   * @param jwtToken - JWT token
   * @return boolean
   */
  private boolean isTokenExpired(final @NonNull String jwtToken) {
    return extractClaim(jwtToken, Claims::getExpiration)
        .before(new Date());
  }


  /**
   * Method to generate token without extra claims
   *
   * @param userDetails - UserDetails
   * @return String
   */
  public String generateToken(UserDetails userDetails) {
    return generateToken(new HashMap<>(), userDetails);
  }

  /**
   * Method to generate token
   *
   * @param extraClaims - Extra claims
   * @param userDetails - UserDetails
   * @return String
   */
  public String generateToken(Map<String, Object> extraClaims, UserDetails userDetails) {
    return Jwts
        .builder()
        .setClaims(extraClaims)
        .setSubject(userDetails.getUsername()) // Should be username
        .setIssuedAt(new Date(System.currentTimeMillis()))
        .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 24)) // 24 hours plus E3 milliseconds
        .signWith(getSigningKey(), SignatureAlgorithm.HS512)
        .compact();
  }

  /**
   * Method to extract username from JWT token
   *
   * @param jwtToken - JWT token
   * @return String - username
   */
  public String extractUsername(String jwtToken) {
    return extractClaim(jwtToken, Claims::getSubject);
  }

  /**
   * Method to extract a single claim
   *
   * @param jwtToken       - JWT token
   * @param claimsResolver - ClaimResolver
   * @return Generics
   */
  public <T> T extractClaim(String jwtToken, Function<Claims, T> claimsResolver) {
    final Claims claims = extractAllClaims(jwtToken);
    return claimsResolver.apply(claims);
  }

  /**
   * Method to extract all claims from JWT token
   *
   * @param jwtToken - JWT token
   * @return Claims
   */
  private Claims extractAllClaims(String jwtToken) {
    return Jwts
        .parserBuilder()
        .setSigningKey(getSigningKey()) // Secret of size 256 to digitally sign the JWT - ascertain client is valid
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
    byte[] keyBytes = Base64.getDecoder().decode(new SecurityKeysConfiguration().getJWT_SECRET_KEY());
    return Keys.hmacShaKeyFor(keyBytes);
  }
}
