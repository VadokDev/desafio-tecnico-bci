package dev.vadok.desafios.desafiobci.core.usecases.CreateUser.interactors;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

import dev.vadok.desafios.desafiobci.core.entities.IUser;
import dev.vadok.desafios.desafiobci.core.entities.IUserFactory;
import dev.vadok.desafios.desafiobci.core.mappers.UserJpaMapper;
import dev.vadok.desafios.desafiobci.core.services.IJWTService;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.boundaries.ICreateUserBoundary;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.boundaries.ICreateUserGateway;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.exception.CreateUserException;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.models.CreateUserRequestModel;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.models.CreateUserResponseModel;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.presenters.ICreateUserPresenter;

public class CreateUserInteractor implements ICreateUserBoundary {
  @Autowired
  private Environment env;

  private IUserFactory factory;
  private ICreateUserGateway gateway;
  private ICreateUserPresenter presenter;
  private IJWTService jwtService;

  public CreateUserInteractor(IUserFactory factory, ICreateUserGateway createUserGateway,
      ICreateUserPresenter createUserPresenter, IJWTService jwtService) {
    this.factory = factory;
    this.gateway = createUserGateway;
    this.presenter = createUserPresenter;
    this.jwtService = jwtService;
  }

  @Override
  public CreateUserResponseModel create(CreateUserRequestModel requestModel) throws CreateUserException {
    if (this.gateway.existsByEmail(requestModel.getEmail())) {
      CreateUserException userAlreadyExists = new CreateUserException(
          "The user with email " + requestModel.getEmail() + " is already registered");
      return presenter.fail(userAlreadyExists);
    }

    IUser user = factory.create(requestModel.getName(), requestModel.getEmail(), requestModel.getPassword(), requestModel.getPhones());

    if (!user.emailIsValid()) {
      CreateUserException invalidEmail = new CreateUserException("The email " + user.getEmail() + " is not valid");
      return presenter.fail(invalidEmail);
    }

    if (!user.passwordIsValid(env.getProperty("app.password.regexp"))) {
      CreateUserException invalidPassword = new CreateUserException(
          "The password " + user.getPassword() + " is not valid");
      return presenter.fail(invalidPassword);
    }

    String token = jwtService.createJWT(user.getEmail());
    user.setToken(token);

    UserJpaMapper newUser = this.gateway.save(user);

    String created = toIsoLocalDate(newUser.getCreated());
    String modified = toIsoLocalDate(newUser.getModified());
    String lastLogin = toIsoLocalDate(user.getLastLogin());

    CreateUserResponseModel responseModel = new CreateUserResponseModel(newUser.getId(), user.getName(),
        user.getEmail(), created, modified, lastLogin, user.getIsActive(), token, user.getPhones());

    return presenter.success(responseModel);
  }

  private String toIsoLocalDate(Timestamp timestamp) {
    return timestamp
        .toLocalDateTime().format(DateTimeFormatter.ISO_DATE_TIME);
  }
}
