package dev.vadok.desafios.desafiobci.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

import dev.vadok.desafios.desafiobci.core.entities.IUserFactory;
import dev.vadok.desafios.desafiobci.core.entities.UserFactory;
import dev.vadok.desafios.desafiobci.core.gateways.h2.CreateUserH2Gateway;
import dev.vadok.desafios.desafiobci.core.services.IJWTService;
import dev.vadok.desafios.desafiobci.core.services.JWTService;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.boundaries.ICreateUserBoundary;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.boundaries.ICreateUserGateway;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.interactors.CreateUserInteractor;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.presenters.CreateUserPresenter;
import dev.vadok.desafios.desafiobci.core.usecases.CreateUser.presenters.ICreateUserPresenter;

@Configuration
public class CreateUserConfiguration {
  @Autowired
  private Environment env;

  @Bean
  public ICreateUserPresenter createUserPresenter() {
    return new CreateUserPresenter();
  }

  @Bean
  public IUserFactory createUserFactory() {
    return new UserFactory();
  }

  @Bean
  public ICreateUserGateway createUserGateway() {
    return new CreateUserH2Gateway();
  }
  
  @Bean
  public IJWTService jwtService() {
    return new JWTService();
  }

  @Bean
  public ICreateUserBoundary createUserBoundary(ICreateUserPresenter createUserPresenter, ICreateUserGateway createUserGateway, IUserFactory createUserFactory, IJWTService jwtService) {
    return new CreateUserInteractor(createUserFactory, createUserGateway, createUserPresenter, jwtService, env);
  }
}
