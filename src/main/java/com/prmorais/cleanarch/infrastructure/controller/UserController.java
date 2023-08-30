package com.prmorais.cleanarch.infrastructure.controller;

import com.prmorais.cleanarch.application.usecases.CreateUserInteractor;
import com.prmorais.cleanarch.domain.entity.UserEntity;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
  private final CreateUserInteractor userInteractor;
  private final UserDTOMapper userDTOMapper;

  public UserController(CreateUserInteractor userInteractor, UserDTOMapper userDTOMapper) {
    this.userInteractor = userInteractor;
    this.userDTOMapper = userDTOMapper;
  }

  @GetMapping
  public List<CreateUserResponse> findAll() {
    return userDTOMapper.toListResponse(userInteractor.users());
  }

  @GetMapping("/{id}")
  public CreateUserResponse findById(@PathVariable Long id) {
    UserEntity user = userInteractor.findById(id);
    return userDTOMapper.toResponse(user);
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public CreateUserResponse create(@RequestBody CreateUserRequest request) {
    UserEntity userBusinessObj = userDTOMapper.toUser(request);
    UserEntity user = userInteractor.create(userBusinessObj);
    return userDTOMapper.toResponse(user);
  }

}
