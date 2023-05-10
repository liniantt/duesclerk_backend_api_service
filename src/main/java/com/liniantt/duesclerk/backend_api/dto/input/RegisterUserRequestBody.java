/**
 * @apiNote class
 * @author David Kariuki
 * @version 1.0.0
 * @created 06/05/2023
 * @see
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.dto.input;

import com.fasterxml.jackson.annotation.*;
import jakarta.validation.Valid;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({"fullName", "emailAddress", "countryId", "password", "accountType"})
@Generated("jsonschema2pojo")
public class RegisterUserRequestBody implements Serializable {

  private static final long serialVersionUID = 5605629084403969336L;

  @JsonProperty("fullName")
  private String fullName;

  @JsonProperty("emailAddress")
  private String emailAddress;

  @JsonProperty("countryId")
  private String countryId;

  @JsonProperty("password")
  private String password;

  @JsonProperty("accountType")
  private String accountType;

  @JsonIgnore @Valid
  private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

  @JsonAnyGetter
  public Map<String, Object> getAdditionalProperties() {
    return this.additionalProperties;
  }

  @JsonAnySetter
  public void setAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
  }
}
