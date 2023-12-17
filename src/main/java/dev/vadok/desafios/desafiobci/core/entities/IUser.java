package dev.vadok.desafios.desafiobci.core.entities;

import java.sql.Timestamp;
import java.util.List;

public interface IUser {
  String getName();
  String getEmail();
  String getPassword();
  String getToken();
  Timestamp getLastLogin();
  boolean getIsActive();
  List<Phone> getPhones();
  void setToken(String token);
  boolean emailIsValid();
  boolean passwordIsValid(String regExp);
}
