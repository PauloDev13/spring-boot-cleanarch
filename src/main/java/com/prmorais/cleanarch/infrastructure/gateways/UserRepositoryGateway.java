package com.prmorais.cleanarch.infrastructure.gateways;

import com.prmorais.cleanarch.application.gateways.UserGateway;
import com.prmorais.cleanarch.domain.entity.UserEntity;
import com.prmorais.cleanarch.infrastructure.persistence.UserEntityPersistence;
import com.prmorais.cleanarch.repository.UserRepository;

public class UserRepositoryGateway implements UserGateway {

  private final UserRepository userRepository;
  private final UserEntityMapper userEntityMapper;

  public UserRepositoryGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
    this.userRepository = userRepository;
    this.userEntityMapper = userEntityMapper;
  }

  @Override
  public UserEntity createUser(UserEntity userDomainObj) {
    UserEntityPersistence userEntityPersistence = userEntityMapper.toEntity(userDomainObj);
    UserEntityPersistence saveObj = userRepository.save(userEntityPersistence);
    return userEntityMapper.toDomainObj(userEntityPersistence);
  }
}
