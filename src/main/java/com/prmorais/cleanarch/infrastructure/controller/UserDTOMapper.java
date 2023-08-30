package com.prmorais.cleanarch.infrastructure.controller;

import com.prmorais.cleanarch.domain.entity.UserEntity;

import java.util.List;

public class UserDTOMapper {
  public CreateUserResponse toResponse(UserEntity userEntity) {
    return new CreateUserResponse(userEntity.username(), userEntity.email());
  }

  public List<CreateUserResponse> toListResponse(List<UserEntity> users) {
    return users
        .stream()
        .map(userEntity -> new CreateUserResponse(
            userEntity.username(),
            userEntity.email())
    ).toList();
  }
  public UserEntity toUser(CreateUserRequest request) {
    return new UserEntity(request.username(), request.password(), request.email());
  }
}
