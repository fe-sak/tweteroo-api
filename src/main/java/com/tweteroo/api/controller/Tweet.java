package com.tweteroo.api.controller;

import com.tweteroo.api.dto.TweetRequestBodyDTO;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tweets")
public class Tweet {

  @PostMapping
  public String create(@RequestBody TweetRequestBodyDTO requestBody) {
    // TODO Add data persistence for tweet
    return "OK";
  }
}
