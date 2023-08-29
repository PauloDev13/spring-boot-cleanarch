package com.prmorais.cleanarch.application.usecases;

import com.prmorais.cleanarch.application.gateways.UserGateway;
import com.prmorais.cleanarch.domain.entity.UserEntity;

public class CreateUserInteractor {
  private final  UserGateway userGateway;

  public CreateUserInteractor(UserGateway userGateway) {
    this.userGateway = userGateway;
  }

  public UserEntity create(UserEntity user){
    return userGateway.createUser(user);
  }
}
