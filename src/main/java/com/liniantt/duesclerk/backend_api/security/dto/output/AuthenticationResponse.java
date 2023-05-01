/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote AuthenticationResponse output DTO class
 * @created 01/05/2023 - 9:31 AM UTC-4
 * @since 1.0.0
 */

package com.liniantt.duesclerk.backend_api.security.dto.output;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "jwtToken",
})
public class AuthenticationResponse {

  @NotNull
  @JsonProperty("jwtToken")
  private String jwtToken;
}
