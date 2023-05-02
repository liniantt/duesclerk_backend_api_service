/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote SecurityKeysConfiguration class
 * @created 01/05/2023
 * @since 1.0.0
 */

package com.liniantt.duesclerk.backend_api.configs;

import lombok.Getter;

@Getter
public class SecurityKeysConfiguration {

  // Constants ----------------------------------------------------------------

  // HS512 512-bit Encryption key
  private final String JWT_SECRET_KEY =
      "5368566D597133743677397A244226452948404D635166546A576E5A7234753778214125442A462D4A614E645267556B58703273357638792F423F4528482B4B";

}
