package com.prmorais.cleanarch.infrastructure.gateways;

import com.prmorais.cleanarch.application.gateways.UserGateway;
import com.prmorais.cleanarch.domain.entity.UserEntity;
import com.prmorais.cleanarch.infrastructure.exception.RecordNotFoundException;
import com.prmorais.cleanarch.infrastructure.persistence.UserEntityPersistence;
import com.prmorais.cleanarch.infrastructure.persistence.UserRepository;

import java.util.List;
import java.util.stream.StreamSupport;


public class UserRepositoryGateway implements UserGateway {
  private final UserRepository userRepository;
  private final UserEntityMapper userEntityMapper;

  public UserRepositoryGateway(
      UserRepository userRepository,
      UserEntityMapper userEntityMapper
  ) {
    this.userRepository = userRepository;
    this.userEntityMapper = userEntityMapper;
  }

  @Override
  public UserEntity createUser(UserEntity userDomainObj) {
    UserEntityPersistence userEntityPersistence = userEntityMapper.toEntity(userDomainObj);
    UserEntityPersistence saveObj = userRepository.save(userEntityPersistence);
    return userEntityMapper.toDomainObj(saveObj);
  }


  @Override
  public List<UserEntity> getAll() {
    Iterable<UserEntityPersistence> users = userRepository.findAll();
    List<UserEntityPersistence> usersEntity = StreamSupport.stream(users.spliterator(), false).toList();
    return userEntityMapper.toListDomainObjs(usersEntity);
  }

  @Override
  public UserEntity findById(Long id) {
    UserEntityPersistence userEntity = userRepository.findById(id)
        .orElseThrow(() -> new RecordNotFoundException(id)
        );
    return userEntityMapper.toDomainObj(userEntity);

  }

}
