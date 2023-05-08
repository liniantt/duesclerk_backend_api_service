/**
 * @apiNote UserUtilityServiceImpl service class
 * @author David Kariuki
 * @version 1.0.0
 * @created 07/05/2023
 * @see com.liniantt.duesclerk.backend_api.service.UserUtilityService - Service class
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.service_impl;

import com.liniantt.duesclerk.backend_api.service.UserUtilityService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserUtilityServiceImpl implements UserUtilityService {

  /**
   * Method to generate userId
   *
   * @return String
   */
  @Override
  public String generateUserId() {
    return "user" + UUID.randomUUID();
  }
}
