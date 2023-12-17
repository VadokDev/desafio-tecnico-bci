package dev.vadok.desafios.desafiobci.core.usecases.CreateUser.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateUserResponseModel {
  private String id;
  private String name;
  private String email;
  private String created;
  private String modified;
  private String last_login;
  private boolean isactive;
  private String token;
}
