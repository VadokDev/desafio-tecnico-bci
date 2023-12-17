package dev.vadok.desafios.desafiobci.core.entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements IUser {
  private String name;
  private String email;
  private String password;
  private Timestamp lastLogin;
  private boolean isActive;
  private String token;
  private List<Phone> phones;

  public User(String name, String email, String password, Timestamp lastLogin, boolean isActive, List<Phone> phones) {
    this.name = name;
    this.email = email;
    this.password = password;
    this.lastLogin = lastLogin;
    this.isActive = isActive;
    this.phones = phones;
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

  public List<Phone> getPhones() {
    return phones;
  }

  @Override
  public boolean emailIsValid() {
    String regExp = "^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$";
    Pattern pattern = Pattern.compile(regExp);
    Matcher matcher = pattern.matcher(this.email);
    return matcher.matches();
  }

  @Override
  public boolean passwordIsValid(String regExp) {
    Pattern pattern = Pattern.compile(regExp);
    Matcher matcher = pattern.matcher(this.password);
    return matcher.matches();
  }
}