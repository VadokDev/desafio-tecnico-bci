package dev.vadok.desafios.desafiobci.core.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.vadok.desafios.desafiobci.core.mappers.UserJpaMapper;

@Repository
public interface ICreateUserRepository extends JpaRepository<UserJpaMapper, String> {
  boolean existsByEmail(String email);
}
