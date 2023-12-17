package dev.vadok.desafios.desafiobci.core.usecases.CreateUser.boundaries;

public interface IUserExistsGateway {
  boolean existsByEmail(String email);
}
