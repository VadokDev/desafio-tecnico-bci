package dev.vadok.desafios.desafiobci.core.services;

import io.jsonwebtoken.Jwts;

public class JWTService implements IJWTService {
  @Override
  public String createJWT(String email) {
    String jwtToken = Jwts.builder()
        .claim("email", email)
        .compact();

    return jwtToken;
  }
}
