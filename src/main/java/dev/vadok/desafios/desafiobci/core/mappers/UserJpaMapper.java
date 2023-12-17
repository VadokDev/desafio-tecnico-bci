package dev.vadok.desafios.desafiobci.core.mappers;

import java.sql.Timestamp;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserJpaMapper {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private String id;
  private String name;
  private String email;
  private String password;
  private String token;

  @CreationTimestamp
  private Timestamp created;

  @UpdateTimestamp
  private Timestamp modified;
  
  @OneToMany(mappedBy = "user")
  private List<PhoneJpaMapper> phones;

  private Timestamp last_login;
}
