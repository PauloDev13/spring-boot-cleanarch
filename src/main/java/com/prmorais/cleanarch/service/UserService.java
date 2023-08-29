package com.prmorais.cleanarch.service;

import com.prmorais.cleanarch.model.User;
import com.prmorais.cleanarch.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User create(User user){
    return userRepository.save(user);
  }
}
