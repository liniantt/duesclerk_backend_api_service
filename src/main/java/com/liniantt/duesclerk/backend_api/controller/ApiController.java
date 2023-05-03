/**
 * @apiNote ApiController class
 * @author David Kariuki
 * @version 1.0.0
 * @created 29/04/2023
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.time.LocalDateTime;
import java.util.Map;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class ApiController {

  /**
   * Method to receive ping calls without authentication
   *
   * @return ResponseEntity<?> - Response
   */
  @GetMapping(path = "/ping", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(summary = "Receive ping call for test")
  @ApiResponses(
      value = {
        @ApiResponse(
            description = "API endpoint is reachable",
            responseCode = "200",
            content = @Content(mediaType = "application/json")),
        @ApiResponse(
            description = "API endpoint is not reachable",
            responseCode = "400",
            content = @Content(mediaType = "application/json"))
      })
  public ResponseEntity<?> ping() {
    return ResponseEntity.ok(
        Map.of(
            "response",
            Map.of("status", HttpStatus.OK, "error", false, "timestamp", LocalDateTime.now())));
  }
}
