package com.tweteroo.api.controller;

import com.tweteroo.api.dto.TweetDTO;
import com.tweteroo.api.model.Tweet;
import com.tweteroo.api.model.User;
import com.tweteroo.api.repository.TweetRepository;
import com.tweteroo.api.repository.UserRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tweets")
@CrossOrigin(origins = "*")
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
  public List<Tweet> read(@RequestParam String page) {
    if (page.isBlank() || page.isEmpty()) {
      return getLastFiveTweets();
    } else {
      return getTweetsByPage(page);
    }
  }

  @GetMapping("/{username}")
  public List<Tweet> readByUser(@PathVariable String username) {

    return tweetRepository.findByUsername(username);
  }

  private List<Tweet> getLastFiveTweets() {
    List<Tweet> lastFive = new ArrayList<>();
    List<Tweet> tweets = tweetRepository.findAll();

    int size = tweets.size();

    for (int i = size - 1; i >= size - 5 && i >= 0; i--) {
      lastFive.add(tweets.get(i));
    }

    return lastFive;
  }

  private List<Tweet> getTweetsByPage(String pageString) {
    int page = Integer.parseInt(pageString);

    if (page <= 0) return new ArrayList<>(); // TODO Modify to return http error

    List<Tweet> unpaginatedTweets = tweetRepository.findAll();
    List<Tweet> paginatedTweets = new ArrayList<>();

    for (int i = (page - 1) * 5; i < page * 5 && i < unpaginatedTweets.size(); i++) {
      paginatedTweets.add(unpaginatedTweets.get(i));
    }

    return paginatedTweets;
  }
}
