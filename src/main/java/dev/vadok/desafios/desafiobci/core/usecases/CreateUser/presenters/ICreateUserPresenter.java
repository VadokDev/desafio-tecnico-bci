package dev.vadok.desafios.desafiobci.core.usecases.CreateUser.presenters;

import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.exception.CreateUserException;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.models.CreateUserResponseModel;

public interface ICreateUserPresenter {
  CreateUserResponseModel fail(CreateUserException e) throws CreateUserException;
  CreateUserResponseModel success(CreateUserResponseModel responseModel);
}
