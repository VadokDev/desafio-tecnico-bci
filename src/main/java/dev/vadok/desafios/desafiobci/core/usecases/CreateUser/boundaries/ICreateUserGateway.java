package dev.vadok.desafios.desafiobci.core.usecases.CreateUser.boundaries;

import dev.vadok.desafios.desafiobci.core.entities.IUser;
import dev.vadok.desafios.desafiobci.core.mappers.UserJpaMapper;

public interface ICreateUserGateway extends IUserExistsGateway {
  UserJpaMapper save(IUser user);
}
