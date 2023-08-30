package com.prmorais.cleanarch.application.gateways;

import com.prmorais.cleanarch.domain.entity.UserEntity;

import java.util.List;

public interface UserGateway {
  UserEntity createUser(UserEntity user);
  List<UserEntity> getAll();
}
