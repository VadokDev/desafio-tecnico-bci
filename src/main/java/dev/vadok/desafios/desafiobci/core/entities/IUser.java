package dev.vadok.desafios.desafiobci.core.entities;

import java.sql.Timestamp;

public interface IUser {
  String getName();
  String getEmail();
  String getPassword();
  String getToken();
  Timestamp getLastLogin();
  boolean getIsActive();
  void setToken(String token);
  boolean emailIsValid();
  boolean passwordIsValid();
}
