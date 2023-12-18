package dev.vadok.desafios.desafiobci.core.entities;

import java.util.ArrayList;

public interface IUserFactory {
  IUser create(String name, String email, String password, ArrayList<Phone> phones);
}
