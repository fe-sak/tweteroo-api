package com.tweteroo.api.model;

import com.tweteroo.api.dto.UserDTO;
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
@Table(name = "Users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Column(length = 30, nullable = false)
  private String username;

  @Column(length = 300, nullable = false)
  private String avatar;

  public User(UserDTO userDTO) {
    this.setUsername(userDTO.username());
    this.setAvatar(userDTO.avatar());
  }
}
