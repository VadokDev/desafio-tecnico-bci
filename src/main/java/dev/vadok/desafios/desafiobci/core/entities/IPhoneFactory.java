package dev.vadok.desafios.desafiobci.core.entities;

public interface IPhoneFactory {
  IPhone create(String number, String citycode, String countrycode);
}
