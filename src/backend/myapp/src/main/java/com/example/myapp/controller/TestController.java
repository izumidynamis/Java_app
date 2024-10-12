package com.example.myapp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


  @GetMapping("/newendpoint")
  public String newEndpoint() {
    return "Hello, World! sample page";
  }
}
