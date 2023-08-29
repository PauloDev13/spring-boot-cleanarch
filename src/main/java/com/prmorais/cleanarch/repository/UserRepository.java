package com.prmorais.cleanarch.repository;


import com.prmorais.cleanarch.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {
}
