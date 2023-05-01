/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote UserRoleEnumConverter class
 * @created 01/05/2023 - 7:30 AM UTC-4
 * @see com.liniantt.duesclerk.backend_api.domain.enum_.UserRole
 * @since 1.0.0
 */

package com.liniantt.duesclerk.backend_api.domain.enum_converter;

import com.liniantt.duesclerk.backend_api.domain.enum_.UserRole;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class UserRoleEnumConverter implements AttributeConverter<UserRole, String> {

  /**
   * Method to convert entity attribute to database column
   *
   * @param userRole - Enum class to be converted
   * @return Character - short name
   */
  @Override
  public String convertToDatabaseColumn(UserRole userRole) {
    return userRole.getUserRole();
  }

  /**
   * Method to convert from database column to entity attribute
   *
   * @param userRole - Character from the database column to be converted
   * @return UserRole - Enum class
   */
  @Override
  public UserRole convertToEntityAttribute(String userRole) {
    return UserRole.fromShortName(userRole);
  }
}
