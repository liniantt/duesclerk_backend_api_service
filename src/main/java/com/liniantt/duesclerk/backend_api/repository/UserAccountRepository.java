/**
 * @apiNote UserAccountRepository class
 * @author David Kariuki
 * @version 1.0.0
 * @created 29/04/2023
 * @see com.liniantt.duesclerk.backend_api.entity - Entity class
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.repository;

import com.liniantt.duesclerk.backend_api.domain.entity.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {}
