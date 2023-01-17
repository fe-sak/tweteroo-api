package com.tweteroo.api.repository;

import com.tweteroo.api.model.Tweet;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TweetRepository extends JpaRepository<Tweet, Long> {

  List<Tweet> findByUsername(String username);
}
