package com.tweteroo.api.controller;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tweets")
public class TweetController {

  @Autowired
  private TweetRepository tweetRepository;

  @Autowired
  private UserRepository userRepository;

  @PostMapping
  public String create(@RequestBody TweetDTO requestBody) {
    List<User> users = userRepository.findByUsername(requestBody.username());
    User user = users.get(0);

    Tweet tweet = new Tweet(requestBody, user);

    tweetRepository.save(tweet);

    return "OK";
  }

  @GetMapping
  public String read(@RequestParam String page) {
    // TODO Return tweets by page
    return "OK";
  }

  @GetMapping("/{username}")
  public String readByUser(@PathVariable String username) {
    // TODO Return all tweets from specified user
    return "OK";
  }
}
