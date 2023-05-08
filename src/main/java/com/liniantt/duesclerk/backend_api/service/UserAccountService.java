/**
 * @apiNote UserAccountService class
 * @author David Kariuki
 * @version 1.0.0
 * @see com.liniantt.duesclerk.backend_api.service_impl.UserAccountServiceImpl - Service
 *     implementation class
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.service;

import com.liniantt.duesclerk.backend_api.dto.input.RegisterUserRequestBody;
import com.liniantt.duesclerk.backend_api.dto.output.UserRegistrationResponse;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public interface UserAccountService {

  /**
   * Method to register user
   *
   * @param registerUserRequestBody - Request body
   * @return RegisterUserResponse
   */
  UserRegistrationResponse registerUser(@Valid RegisterUserRequestBody registerUserRequestBody);
}
