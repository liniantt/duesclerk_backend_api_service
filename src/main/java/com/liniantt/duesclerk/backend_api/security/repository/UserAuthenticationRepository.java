/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote UserAuthenticationRepository interface class
 * @created 01/05/2023
 * @see com.liniantt.duesclerk.backend_api.security.entity.AuthUser
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.security.repository;

import com.liniantt.duesclerk.backend_api.security.entity.AuthUser;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

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
