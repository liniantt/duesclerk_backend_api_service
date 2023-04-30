/**
 * @apiNote ApiController class
 * @author David Kariuki
 * @version 1.0.0
 * @created 29/04/2023
 * @since 1.0.0
 */

package com.liniantt.duesclerk.backend_api.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.Map;

@RestController
public class ApiController {

  /**
   * Method to receive ping calls to API
   *
   * @return ResponseEntity<?> - Response
   */
  @GetMapping(path = "", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<?> ping() {
    return ResponseEntity.ok(
        Map.of("response",
            Map.of(
                "status", HttpStatus.OK,
                "error", false,
                "timestamp", LocalDateTime.now()
            )
        )
    );
  }
}
