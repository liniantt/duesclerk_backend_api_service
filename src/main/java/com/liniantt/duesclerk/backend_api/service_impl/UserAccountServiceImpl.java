/**
 * @apiNote UserAccountServiceImpl class
 * @author David Kariuki
 * @version 1.0.0
 * @created 29/04/2023
 * @see com.liniantt.duesclerk.backend_api.service.UserAccountService - Service class
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.service_impl;

import com.liniantt.duesclerk.backend_api.domain.entity.UserAccount;
import com.liniantt.duesclerk.backend_api.domain.enum_.AccountType;
import com.liniantt.duesclerk.backend_api.dto.input.RegisterUserRequestBody;
import com.liniantt.duesclerk.backend_api.dto.output.UserRegistrationResponse;
import com.liniantt.duesclerk.backend_api.repository.UserAccountRepository;
import com.liniantt.duesclerk.backend_api.service.UserAccountService;
import com.liniantt.duesclerk.backend_api.service.UserUtilityService;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class UserAccountServiceImpl implements UserAccountService {

  private final PasswordEncoder passwordEncoder;
  private final UserAccountRepository userAccountRepository;
  private final UserUtilityService userUtilityService;

  /**
   * @param registerUserRequestBody - Request body
   * @return UserRegistrationResponse
   */
  @Override
  public UserRegistrationResponse registerUser(RegisterUserRequestBody registerUserRequestBody) {

    String userId = userUtilityService.generateUserId();
    String encodedPassword = passwordEncoder.encode(registerUserRequestBody.getPassword());
    LocalDateTime createdAtTimestamp = LocalDateTime.now();

    UserAccount userAccount =
        UserAccount.builder()
            .userId(userId)
            .fullName(registerUserRequestBody.getFullName())
            .emailAddress(registerUserRequestBody.getEmailAddress())
            .countryId(registerUserRequestBody.getCountryId())
            .password(encodedPassword)
            .accountType(Enum.valueOf(AccountType.class, registerUserRequestBody.getAccountType()))
            .createdAtTimestamp(createdAtTimestamp)
            .updatedAtTimestamp(createdAtTimestamp)
            .emailAddressVerified(false)
            .build();

    boolean userRegistered = userAccountRepository.save(userAccount).equals(userAccount);

    return UserRegistrationResponse.builder()
        .error(userRegistered)
        .responseCode(userRegistered ? 0 : 1)
        .message(userRegistered ? "User registration successful!" : "User registration failed!")
        .emailAddress(registerUserRequestBody.getEmailAddress())
        .createdAtTimestamp(createdAtTimestamp)
        .build();
  }
}
