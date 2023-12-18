package dev.vadok.desafios.desafiobci.core.entities;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class UserTest {
  @Test
  public void test_givenEmail_whenIsNotValid_ThenIsFalse() {
    IUser user = new User("Jacinto", "invalidEmail", "12345", null, false, null);
    assertFalse(user.emailIsValid());
  }

  @Test
  public void test_givenEmail_whenIsValid_ThenIsTrue() {
    IUser user = new User("Jacinto", "aaaaa@dominio.cl", "12345", null, false, null);
    assertTrue(user.emailIsValid());
  }

  @Test
  public void test_givenPassword_whenIsValid_ThenIsTrue() {
    IUser user = new User("Jacinto", "aaaaa@dominio.cl", "12345", null, false, null);
    assertTrue(user.passwordIsValid("^[\\s\\S]*$"));
  }

  @Test
  public void test_givenPassword_whenIsNotValid_ThenIsFalse() {
    IUser user = new User("Jacinto", "aaaaa@dominio.cl", "12345", null, false, null);
    assertFalse(user.passwordIsValid("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"));
  }
}
