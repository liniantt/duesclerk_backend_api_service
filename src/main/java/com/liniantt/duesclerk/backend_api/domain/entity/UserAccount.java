/**
 * @apiNote class
 * @author David Kariuki
 * @version 1.0.0
 * @created 06/05/2023
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.domain.entity;

import com.liniantt.duesclerk.backend_api.domain.enum_.AccountType;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@Entity
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@Table(name = "application_users")
public class UserAccount {

  @Id
  @Column(name = "user_id", nullable = false, unique = true, updatable = false, length = 50)
  String userId;

  @Column(name = "full_name", nullable = false, length = 200)
  String fullName;

  @Column(name = "email_address", nullable = false, length = 300)
  String emailAddress;

  @Column(name = "country_id", nullable = false, length = 8)
  String countryId;

  @Column(name = "password", nullable = false, length = 300)
  String password;

  @Column(name = "accountType", nullable = false, length = 1, columnDefinition = "CHAR(1)")
  AccountType accountType;

  @Column(name = "created_at_timestamp", nullable = false, length = 50)
  LocalDateTime createdAtTimestamp;

  @Column(name = "updated_at_timestamp", nullable = false, length = 50)
  LocalDateTime updatedAtTimestamp;

  @Column(
      name = "email_address_verified",
      nullable = false,
      length = 5,
      columnDefinition = "boolean default false")
  Boolean emailAddressVerified;

  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "sequence", nullable = false)
  Integer sequence;
}
