package dev.vadok.desafios.desafiobci.core.usecases.CreateUser.models;

import java.util.List;

import dev.vadok.desafios.desafiobci.core.entities.Phone;

public class CreateUserRequestModel {
  private String name;
  private String email;
  private String password;
  private List<Phone> phones;

  public CreateUserRequestModel(String name, String email, String password, List<Phone> phones) {
    this.name = name;
    this.email = email;
    this.password = password;
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

  public List<Phone> getPhones() {
    return phones;
  }

  public void setPhones(List<Phone> phones) {
    this.phones = phones;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setPassword(String password) {
    this.password = password;
  }
}
