package dev.vadok.desafios.desafiobci.core.entities;

public interface IUserFactory {
  IUser create(String name, String email, String password);
}
