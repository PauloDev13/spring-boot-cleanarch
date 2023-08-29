package com.prmorais.cleanarch.domain.entity.controller;

import com.prmorais.cleanarch.domain.entity.UserEntity;

public class UserDTOMapper {
  public CreateUserResponse toResponse(UserEntity userEntity) {
    return new CreateUserResponse(userEntity.username(), userEntity.email());
  }

  public UserEntity toUser(CreateUserRequest request) {
    return new UserEntity(request.username(), request.password(), request.email());
  }
}
