package dev.vadok.desafios.desafiobci.core.usecases.CreateUser;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.core.env.Environment;

import dev.vadok.desafios.desafiobci.core.entities.IUserFactory;
import dev.vadok.desafios.desafiobci.core.entities.Phone;
import dev.vadok.desafios.desafiobci.core.entities.User;
import dev.vadok.desafios.desafiobci.core.mappers.PhoneJpaMapper;
import dev.vadok.desafios.desafiobci.core.mappers.UserJpaMapper;
import dev.vadok.desafios.desafiobci.core.services.IJWTService;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.boundaries.ICreateUserGateway;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.exception.CreateUserException;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.interactors.CreateUserInteractor;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.models.CreateUserRequestModel;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.models.CreateUserResponseModel;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.presenters.ICreateUserPresenter;
import dev.vadok.desafios.desafiobci.core.utils.DateUtils;

public class CreateUserInteractorTest {
  IUserFactory mockedFactory;
  ICreateUserGateway mockedGateway;
  ICreateUserPresenter mockedPresenter;
  IJWTService mockedJwtService;
  Environment mockedEnvironment;

  @BeforeEach
  void setup() {
    mockedFactory = Mockito.mock(IUserFactory.class);
    mockedGateway = Mockito.mock(ICreateUserGateway.class);
    mockedPresenter = Mockito.mock(ICreateUserPresenter.class);
    mockedJwtService = Mockito.mock(IJWTService.class);
    mockedEnvironment = Mockito.mock(Environment.class);
  }

  @Test
  void givenNewUser_whenCreate_thenSaveIt() throws CreateUserException {
    String token = "abcdefg";
    ArrayList<Phone> emptyPhoneList = new ArrayList<Phone>();
    Timestamp now = new Timestamp(Instant.now().toEpochMilli());

    CreateUserRequestModel requestModel = new CreateUserRequestModel("Jacinto", "jacinto@gmail.cl", "asd", emptyPhoneList);

    User user = new User("Jacinto", "jacinto@gmail.com", "asd", now, true, emptyPhoneList);

    UserJpaMapper newUser = new UserJpaMapper("id", user.getName(), user.getEmail(), user.getPassword(), token, now, now, new ArrayList<PhoneJpaMapper>(), now);

    String created = DateUtils.toIsoLocalDate(newUser.getCreated());
    String modified = DateUtils.toIsoLocalDate(newUser.getModified());
    String lastLogin = DateUtils.toIsoLocalDate(user.getLastLogin());

    CreateUserResponseModel responseModel = new CreateUserResponseModel("id", user.getName(), user.getEmail(), created, modified, lastLogin, user.getIsActive(), token, emptyPhoneList);

    Mockito.when(mockedEnvironment.getProperty("app.password.regexp")).thenReturn("^[\\s\\S]*$");
    Mockito.when(mockedGateway.existsByEmail(requestModel.getEmail())).thenReturn(false);
    Mockito.when(mockedGateway.save(user)).thenReturn(newUser);
    Mockito.when(mockedJwtService.createJWT(user.getEmail())).thenReturn(token);
    Mockito.when(mockedFactory.create(requestModel.getName(), requestModel.getEmail(), requestModel.getPassword(), requestModel.getPhones())).thenReturn(user);
    Mockito.when(mockedPresenter.success(responseModel)).thenReturn(responseModel);

    CreateUserInteractor interactor = new CreateUserInteractor(mockedFactory, mockedGateway, mockedPresenter, mockedJwtService, mockedEnvironment);
    CreateUserResponseModel verifyResponseModel = interactor.create(requestModel);

    Assertions.assertEquals(responseModel.getId(), verifyResponseModel.getId());
    Assertions.assertEquals(responseModel.getToken(), verifyResponseModel.getToken());

  }
}
