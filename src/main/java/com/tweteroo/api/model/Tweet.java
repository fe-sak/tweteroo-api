package com.tweteroo.api.model;

import com.tweteroo.api.dto.TweetDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "Tweets")
public class Tweet {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 30, nullable = false)
  private String username;

  @Column(length = 200, nullable = false)
  private String avatar;

  @Column(length = 300, nullable = false)
  private String text;

  public Tweet(TweetDTO tweetDTO, User userModel) {
    this.setUsername(tweetDTO.username());
    this.setAvatar(userModel.getAvatar());
    this.setText(tweetDTO.tweet());
  }
}
