package dev.vadok.desafios.desafiobci.core.entities;

import java.sql.Timestamp;

public class User implements IUser {
  private String name;
  private String email;
  private String password;
  private Timestamp lastLogin;
  private boolean isActive;
  private String token;

  public User(String name, String email, String password, Timestamp lastLogin, boolean isActive) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.lastLogin = lastLogin;
    this.isActive = isActive;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public Timestamp getLastLogin() {
    return lastLogin;
  }

  public boolean getIsActive() {
    return isActive;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public String getToken() {
    return token;
  }

  @Override
  public boolean emailIsValid() {
    return true;
  }

  @Override
  public boolean passwordIsValid() {
    return true;
  }
}