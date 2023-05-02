/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote AuthUser class
 * @created 01/05/2023
 * @see
 * @since 1.0.0
 */

package com.liniantt.duesclerk.backend_api.security.entity;

import com.liniantt.duesclerk.backend_api.domain.enum_.UserRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "auth_user") // Have underscore to avoid ambiguity with postgres user table
public class AuthUser implements UserDetails {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO) // Auto for hibernate to best select based on DB mapping
  @Column(name = "id")
  private Integer id;

  @Column(name = "username")
  private String username;

  @Column(name = "password")
  private String password;

  @Enumerated(EnumType.STRING)
  @Column(name = "user_role")
  private UserRole userRole;

  @Column(name = "timestamp_created")
  @Builder.Default
  private LocalDateTime timestampCreated = LocalDateTime.now();


  /**
   * Method to get authorities
   *
   * @return Collection<?>
   */
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return List.of(new SimpleGrantedAuthority(userRole.name()));
  }

  /**
   * Method to get username
   *
   * @return String
   */
  @Override
  public String getUsername() {
    return username;
  }

  /**
   * Method to get password
   *
   * @return String
   */
  @Override
  public String getPassword() {
    return password;
  }

  /**
   * Method to check if account is non expired
   *
   * @return boolean
   */
  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  /**
   * Method to check if account is non locked
   *
   * @return boolean
   */
  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  /**
   * Method to check if credentials are non expired
   *
   * @return boolean
   */
  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  /**
   * Method to check if user is enabled
   *
   * @return boolean
   */
  @Override
  public boolean isEnabled() {
    return true;
  }
}
