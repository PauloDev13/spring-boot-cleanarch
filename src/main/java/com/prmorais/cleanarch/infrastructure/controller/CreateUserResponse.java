package com.prmorais.cleanarch.infrastructure.controller;

public record CreateUserResponse (
  String username,
  String email
) {}
