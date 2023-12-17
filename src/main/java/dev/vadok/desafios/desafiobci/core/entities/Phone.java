package dev.vadok.desafios.desafiobci.core.entities;

public class Phone implements IPhone {
  private String number;
  private String citycode;
  private String countrycode;

  public Phone (String number, String citycode, String countrycode) {
    this.number = number;
    this.citycode = citycode;
    this.countrycode = countrycode;
  }

  public String getNumber() {
    return number;
  }

  public String getCitycode() {
    return citycode;
  }

  public String getCountrycode() {
    return countrycode;
  }
}
