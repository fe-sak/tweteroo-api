package com.tweteroo.api.controller;

import com.tweteroo.api.dto.UserRequestBodyDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Authorization {

  @PostMapping("/sign-up")
  public String signUp(@RequestBody UserRequestBodyDTO requestBody){
    //TODO Add data persistence for user
    return "OK";
  }
}
