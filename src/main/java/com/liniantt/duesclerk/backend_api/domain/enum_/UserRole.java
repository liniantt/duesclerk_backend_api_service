/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote UserRole enum
 * @created 01/05/2023
 * @see
 * @since 1.0.0
 */

package com.liniantt.duesclerk.backend_api.domain.enum_;

import lombok.Getter;

@Getter
public enum UserRole {

  ORDINARY_USER("USER"), // Ordinary user
  ADMINISTRATOR("ADMIN"); // Administrator

  private final String userRole;

  UserRole(String userRole) {
    this.userRole = userRole;
  }

  /**
   * Method to convert UserRole shortname to enum
   *
   * @param user - User - shortname
   * @return UserRole
   */
  public static UserRole fromShortName(String user) {
    return switch (user) {
      case "USER" -> UserRole.ORDINARY_USER;
      case "ADMIN" -> UserRole.ADMINISTRATOR;
      default -> throw new IllegalArgumentException(
          "Invalid user role : " + user + "!");
    };
  }
}
