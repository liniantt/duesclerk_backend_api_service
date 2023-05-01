/**
 * @author David Kariuki
 * @version 1.0.0
 * @apiNote AuthenticationRequest input DTO class
 * @created 01/05/2023 - 9:29 AM UTC-4
 * @since 1.0.0
 */

package com.liniantt.duesclerk.backend_api.security.dto.input;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.annotation.Generated;
import java.io.Serializable;
import java.util.Objects;

@Builder
@Getter
@Setter
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "username",
    "password"
})
@Generated("jsonschema2pojo")
public class AuthenticationRequest implements Serializable {

  private final static long serialVersionUID = 2916126885284138846L;

  @JsonProperty("username")
  public String username;

  @JsonProperty("password")
  public String password;


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    AuthenticationRequest that = (AuthenticationRequest) o;
    return Objects.equals(username, that.username) && Objects.equals(password, that.password);
  }

  @Override
  public int hashCode() {
    return Objects.hash(username, password);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append(AuthenticationRequest.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
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