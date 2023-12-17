package dev.vadok.desafios.desafiobci.core.entities;

public class PhoneFactory implements IPhoneFactory {
  @Override
  public Phone create(String number, String citycode, String countrycode) {
    return new Phone(number, citycode, countrycode);
  }
}
