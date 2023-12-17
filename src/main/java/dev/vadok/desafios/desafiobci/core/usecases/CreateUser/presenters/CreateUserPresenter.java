package dev.vadok.desafios.desafiobci.core.usecases.CreateUser.presenters;

import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.exception.CreateUserException;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.models.CreateUserResponseModel;

public class CreateUserPresenter implements ICreateUserPresenter {
  @Override
  public CreateUserResponseModel fail(CreateUserException e) throws CreateUserException {
    throw e;
  }

  @Override
  public CreateUserResponseModel success(CreateUserResponseModel responseModel) {
    return responseModel;
  }
}
