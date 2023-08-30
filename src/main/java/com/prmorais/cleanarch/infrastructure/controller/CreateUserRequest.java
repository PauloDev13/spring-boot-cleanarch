package com.prmorais.cleanarch.infrastructure.controller;

public record CreateUserRequest(
    String username,
    String password,
    String email
) {
}
