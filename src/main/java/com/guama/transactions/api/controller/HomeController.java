package com.guama.transactions.api.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Home redirection to swagger api documentation
 */
@Controller
@RequestMapping("/")
public class HomeController {

  /**
   * Return the html index of Swagger.
   *
   * @return The html string of Swagger index page.
   */
  @GetMapping
  public String index() {
    return "redirect:/swagger-ui/index.html";
  }
}
