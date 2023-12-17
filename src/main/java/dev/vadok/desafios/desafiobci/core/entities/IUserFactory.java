package dev.vadok.desafios.desafiobci.core.entities;

import java.util.List;

public interface IUserFactory {
  IUser create(String name, String email, String password, List<Phone> phones);
}
