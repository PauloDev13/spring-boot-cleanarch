package com.prmorais.cleanarch.infrastructure.persistence;


import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntityPersistence, Long> {
}
