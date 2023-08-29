package com.prmorais.cleanarch.main;

import com.prmorais.cleanarch.application.gateways.UserGateway;
import com.prmorais.cleanarch.application.usecases.CreateUserInteractor;
import com.prmorais.cleanarch.domain.entity.controller.UserDTOMapper;
import com.prmorais.cleanarch.infrastructure.gateways.UserEntityMapper;
import com.prmorais.cleanarch.infrastructure.gateways.UserRepositoryGateway;
import com.prmorais.cleanarch.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserConfig {
  @Bean
  CreateUserInteractor createUserCase(UserGateway userGateway) {
    return new CreateUserInteractor(userGateway);
  }

  @Bean
  UserGateway userGateway(UserRepository userRepository, UserEntityMapper userEntityMapper) {
    return new UserRepositoryGateway(userRepository, userEntityMapper);
  }

  @Bean
  UserEntityMapper userEntityMapper() {
    return new UserEntityMapper();
  }

  @Bean
  UserDTOMapper userDTOMapper() {
    return new UserDTOMapper();
  }
}
