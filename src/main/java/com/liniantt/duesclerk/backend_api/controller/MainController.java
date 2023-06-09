/**
 * @apiNote MainController class
 * @author David Kariuki
 * @version 1.0.0
 * @created 29/04/2023
 * @since 1.0.0
 */
package com.liniantt.duesclerk.backend_api.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {

  @RequestMapping(
      path = {"", "/", ""},
      method = {
        RequestMethod.GET,
        RequestMethod.POST,
        RequestMethod.PUT,
        RequestMethod.PATCH,
        RequestMethod.HEAD,
        RequestMethod.DELETE,
        RequestMethod.OPTIONS,
        RequestMethod.TRACE
      },
      produces = MediaType.TEXT_HTML_VALUE)
  public String index() {
    return "index";
  }
}
