package dev.vadok.desafios.desafiobci.core.gateways.h2;

import org.springframework.beans.factory.annotation.Autowired;

import dev.vadok.desafios.desafiobci.core.entities.IUser;
import dev.vadok.desafios.desafiobci.core.mappers.UserJpaMapper;
import dev.vadok.desafios.desafiobci.core.repositories.ICreateUserRepository;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.boundaries.ICreateUserGateway;

public class CreateUserH2Gateway implements ICreateUserGateway {
  @Autowired
  ICreateUserRepository _repository;

  public CreateUserH2Gateway() {}
  
  @Override
  public UserJpaMapper save(IUser user) {
    UserJpaMapper createUserJpaMapper = new UserJpaMapper();
    createUserJpaMapper.setEmail(user.getEmail());
    createUserJpaMapper.setName(user.getName());
    createUserJpaMapper.setPassword(user.getPassword());
    createUserJpaMapper.setLast_login(user.getLastLogin());
    createUserJpaMapper.setToken(user.getToken());
    UserJpaMapper newUser = this._repository.save(createUserJpaMapper);
    return newUser;
  }
  
  @Override
  public boolean existsByEmail(String email) {
    return _repository.existsByEmail(email);
  }
}
