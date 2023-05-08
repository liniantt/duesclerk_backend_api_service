/**
 * @apiNote class
 * @author David Kariuki
 * @version 1.0.0
 * @created 06/05/2023
 * @see
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.dto.output;

import com.fasterxml.jackson.annotation.*;
import java.io.Serializable;
import java.time.LocalDateTime;
import javax.annotation.processing.Generated;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
  "error",
  "message",
  "responseCode",
})
@Generated("jsonschema2pojo")
public class UserRegistrationResponse implements Serializable {

  private static final long serialVersionUID = 5605629084403969336L;

  @JsonProperty("created_at_timestamp")
  LocalDateTime createdAtTimestamp;

  @JsonProperty("error")
  private boolean error;

  @JsonProperty("message")
  private String message;

  @JsonProperty("responseCode")
  private Integer responseCode;

  @JsonProperty("emailAddress")
  private String emailAddress;
}
