/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote AuthRegistrationRequest input DTO class
 * @created 01/05/2023 - 9:28 AM UTC-4
 * @since 1.0.0
 */

package com.liniantt.duesclerk.backend_api.security.dto.input;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.*;

import javax.annotation.Generated;
import java.io.Serializable;


@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "username",
    "password"
})
@Generated("jsonschema2pojo")
public class AuthRegistrationRequest implements Serializable {

  private final static long serialVersionUID = 2916126885284138846L;
  @JsonProperty("username")
  public String username;
  @JsonProperty("password")
  public String password;

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(AuthRegistrationRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
    sb.append("username");
    sb.append('=');
    sb.append(((this.username == null) ? "<null>" : this.username));
    sb.append(',');
    sb.append("password");
    sb.append('=');
    sb.append(((this.password == null) ? "<null>" : this.password));
    sb.append(',');
    if (sb.charAt((sb.length() - 1)) == ',') {
      sb.setCharAt((sb.length() - 1), ']');
    } else {
      sb.append(']');
    }
    return sb.toString();
  }

}
