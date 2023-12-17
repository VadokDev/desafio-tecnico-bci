package dev.vadok.desafios.desafiobci.core.usecases.CreateUser.exception;

public class CreateUserException extends Exception {
  public CreateUserException() {}
  
  public CreateUserException(String message) {
    super(message);
  }

  public CreateUserException(String message, Throwable cause) {
    super(message, cause);
  }
}
