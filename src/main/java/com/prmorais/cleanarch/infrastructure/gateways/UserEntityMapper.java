package com.prmorais.cleanarch.infrastructure.gateways;

import com.prmorais.cleanarch.domain.entity.UserEntity;
import com.prmorais.cleanarch.infrastructure.persistence.UserEntityPersistence;

import java.util.List;

public class UserEntityMapper {
  UserEntityPersistence toEntity(UserEntity userDomainObj) {
    return new UserEntityPersistence(
        userDomainObj.username(),
        userDomainObj.password(),
        userDomainObj.email()
    );
  }
  UserEntity toDomainObj(UserEntityPersistence userEntityPersistence) {
    return new UserEntity(
        userEntityPersistence.getUsername(),
        userEntityPersistence.getPassword(),
        userEntityPersistence.getEmail()
    );
  }

  List<UserEntity> toListDomainObjs(List<UserEntityPersistence> usersPersistence) {
    return usersPersistence.stream().map(data ->
        new UserEntity(
            data.getUsername(),
            data.getPassword(),
            data.getEmail())
    ).toList();
  }
}
