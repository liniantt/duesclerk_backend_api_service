/**
 * @apiNote UserUtilityService service class
 * @author David Kariuki
 * @version 1.0.0
 * @created 07/05/2023
 * @see com.liniantt.duesclerk.backend_api.service_impl.UserUtilityServiceImpl - Service
 *     implementation
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.service;

import org.springframework.stereotype.Service;

@Service
public interface UserUtilityService {

  /**
   * Method to generate userId
   *
   * @return String
   */
  String generateUserId();
}
