package com.tweteroo.api.repository;

import com.tweteroo.api.model.User;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  List<User> findByUsername(String username);
}
