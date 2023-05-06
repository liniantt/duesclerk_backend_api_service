/**
 * @apiNote class
 * @author David Kariuki
 * @version 1.0.0
 * @created 06/05/2023
 * @see
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.domain.enum_converter;

import com.liniantt.duesclerk.backend_api.domain.enum_.AccountType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class AccountTypeConverter implements AttributeConverter<AccountType, Character> {

  /**
   * Method to convert to database column
   *
   * @param attribute the entity attribute value to be converted
   * @return Character
   */
  @Override
  public Character convertToDatabaseColumn(AccountType attribute) {
    return attribute.getAccountType();
  }

  /**
   * Method to convert from database column to entity attribute
   *
   * @param dbData the data from the database column to be converted
   * @return AccountType
   */
  @Override
  public AccountType convertToEntityAttribute(Character dbData) {
    return AccountType.fromShortName(dbData);
  }
}
