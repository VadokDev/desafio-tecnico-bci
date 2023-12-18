package dev.vadok.desafios.desafiobci.core.entities;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

public class UserFactory implements IUserFactory {
  @Override
  public User create(String name, String email, String password, ArrayList<Phone> phones) {
    Timestamp now = new Timestamp(Instant.now().toEpochMilli());
    return new User(name, email, password, now, true, phones);
  }
}
