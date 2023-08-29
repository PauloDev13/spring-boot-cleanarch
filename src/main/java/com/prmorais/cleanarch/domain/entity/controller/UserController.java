package com.prmorais.cleanarch.domain.entity.controller;

import com.prmorais.cleanarch.application.usecases.CreateUserInteractor;
import com.prmorais.cleanarch.domain.entity.UserEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("users")
public class UserController {
  private final CreateUserInteractor userInteractor;
  private final UserDTOMapper userDTOMapper;

  public UserController(CreateUserInteractor userInteractor, UserDTOMapper userDTOMapper) {
    this.userInteractor = userInteractor;
    this.userDTOMapper = userDTOMapper;
  }

  @PostMapping
  public CreateUserResponse create(@RequestBody CreateUserRequest request) {
    UserEntity userBusinessObj = userDTOMapper.toUser(request);
   UserEntity user = userInteractor.create(userBusinessObj);
   return userDTOMapper.toResponse(user);
  }
}
