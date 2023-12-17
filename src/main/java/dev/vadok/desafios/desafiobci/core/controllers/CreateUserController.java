package dev.vadok.desafios.desafiobci.core.controllers;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.boundaries.ICreateUserBoundary;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.exception.CreateUserException;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.models.CreateUserErrorModel;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.models.CreateUserRequestModel;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.models.CreateUserResponseModel;

@RestController()
@RequestMapping("/users")
public class CreateUserController {
  ICreateUserBoundary inputBoundary;

  public CreateUserController(ICreateUserBoundary inputBoundary) {
    this.inputBoundary = inputBoundary;
  }

  @PostMapping
  public CreateUserResponseModel create(@RequestBody CreateUserRequestModel requestModel) throws CreateUserException {
    return this.inputBoundary.create(requestModel);
  }

  @ExceptionHandler({ CreateUserException.class })
  public CreateUserErrorModel handleException(CreateUserException e) {
    CreateUserErrorModel createUserErrorModel = new CreateUserErrorModel(e.getMessage());
    return createUserErrorModel;
  }
}
