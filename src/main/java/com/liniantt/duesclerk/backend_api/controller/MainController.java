/**
 * @apiNoteMainController class
 * @since April 2023
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
      method = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.PATCH,
          RequestMethod.HEAD, RequestMethod.DELETE, RequestMethod.OPTIONS, RequestMethod.TRACE},
      produces = MediaType.TEXT_HTML_VALUE)
  public String index() {
    return "index";
  }
}
