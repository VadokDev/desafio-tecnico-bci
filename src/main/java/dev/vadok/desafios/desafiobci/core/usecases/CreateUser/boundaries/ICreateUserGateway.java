package dev.vadok.desafios.desafiobci.core.usecases.CreateUser.boundaries;

import dev.vadok.desafios.desafiobci.core.entities.IUser;
import dev.vadok.desafios.desafiobci.core.mappers.CreateUserJpaMapper;

public interface ICreateUserGateway extends IUserExistsGateway {
  CreateUserJpaMapper save(IUser user);
}
