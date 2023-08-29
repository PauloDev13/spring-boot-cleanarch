package com.prmorais.cleanarch.domain.entity.controller;

public record CreateUserRequest(
    String username,
    String password,
    String email
) {
}
