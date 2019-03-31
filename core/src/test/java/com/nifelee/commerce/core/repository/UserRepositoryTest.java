package com.nifelee.commerce.core.repository;

import com.nifelee.commerce.core.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class UserRepositoryTest {

  @Autowired
  UserRepository userRepository;

  @Test
  public void findOne() {
    User user = userRepository.findById("user-01")
        .orElse(null);

    log.debug("user : {}", user);
  }

}