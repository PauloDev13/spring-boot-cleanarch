package com.prmorais.cleanarch.infrastructure.controller;

import com.prmorais.cleanarch.model.User;
import com.prmorais.cleanarch.service.UserService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
  private final UserService userService;

  public UserController(UserService userService) {
    this.userService = userService;
  }

  @PostMapping
  public User create(@RequestBody User user) {
    return userService.create(user);
  }
}