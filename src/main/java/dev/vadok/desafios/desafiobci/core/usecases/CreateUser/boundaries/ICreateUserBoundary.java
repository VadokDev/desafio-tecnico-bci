package dev.vadok.desafios.desafiobci.core.usecases.CreateUser.boundaries;

import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.exception.CreateUserException;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.models.CreateUserRequestModel;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.models.CreateUserResponseModel;

public interface ICreateUserBoundary {
  CreateUserResponseModel create(CreateUserRequestModel requestModel) throws CreateUserException;
}