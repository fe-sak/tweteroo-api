package com.tweteroo.api.controller;

import com.tweteroo.api.dto.UserDTO;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthorizationController {

  @Autowired
  private UserRepository userRepository;

  @PostMapping("/sign-up")
  public String signUp(@RequestBody UserDTO requestBody){
    userRepository.save(new User(requestBody));
    System.out.println(userRepository.findAll());
    return "OK";
  }
}
