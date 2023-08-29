package com.prmorais.cleanarch.application.gateways;

import com.prmorais.cleanarch.domain.entity.UserEntity;

public interface UserGateway {
  UserEntity createUser(UserEntity user);
}
