package com.tweteroo.api.controller;

import com.tweteroo.api.dto.UserDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class Authorization {

  @PostMapping("/sign-up")
  public void signUp(@RequestBody UserDTO req){
    System.out.println(req);
  }
}
