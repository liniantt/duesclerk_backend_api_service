/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote UserAuthenticationRepository interface class
 * @created 01/05/2023 - 7:06 AM UTC-4
 * @see com.liniantt.duesclerk.backend_api.security.entity.AuthUser
 * @since 1.0.0
 */

package com.liniantt.duesclerk.backend_api.security.repository;

import com.liniantt.duesclerk.backend_api.security.entity.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserAuthenticationRepository extends JpaRepository<AuthUser, Integer> {

  /**
   * Method to find user by username
   *
   * @param username - User's username
   * @return Optional<User
   */
  Optional<AuthUser> findByUsername(final @NonNull String username);
}
