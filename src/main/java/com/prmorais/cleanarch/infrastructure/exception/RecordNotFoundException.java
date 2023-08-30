package com.prmorais.cleanarch.infrastructure.exception;

public class RecordNotFoundException extends RuntimeException{
  public RecordNotFoundException(Long id) {
    super("Registro não encontrado com ID: " + id);
  }
}
