/**
 * @apiNote class
 * @author David Kariuki
 * @version 1.0.0
 * @created 06/05/2023
 * @see
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.domain.enum_;

import lombok.Getter;

@Getter
public enum AccountType {
  PERSONAL('P'),
  BUSINESS('B');

  Character accountType;

  AccountType(Character accountType) {
    this.accountType = accountType;
  }

  /**
   * Method to convert from database colum to enum attribute
   *
   * @param accountType - AccountType enum
   * @return AccountType
   */
  public static AccountType fromShortName(Character accountType) {
    return switch (accountType) {
      case 'P' -> AccountType.PERSONAL;
      case 'B' -> AccountType.BUSINESS;
      default -> throw new IllegalArgumentException("Unknown account type: " + accountType);
    };
  }
}
