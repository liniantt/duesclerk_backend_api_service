/**
 * @apiNote DebtControllerTest class
 * @author David Kariuki
 * @version 1.0.0
 * @created 29/04/2023
 * @see com.liniantt.duesclerk.backend_api.controller.DebtController - Controller class for testing
 * @since 1.0.0
 */

package com.liniantt.duesclerk.backend_api.controller;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

@JsonTest
@RestClientTest
@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureWebTestClient
@ExtendWith(SpringExtension.class)
public class DebtControllerTest {

  @Autowired
  private MockMvc mockMvc;
}
