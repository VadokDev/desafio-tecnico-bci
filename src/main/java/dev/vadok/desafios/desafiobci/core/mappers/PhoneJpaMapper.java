package dev.vadok.desafios.desafiobci.core.mappers;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "Phones")
@Data
@AllArgsConstructor
public class PhoneJpaMapper {
  @Id
  @GeneratedValue(generator = "uuid2")
  @GenericGenerator(name = "uuid2", strategy = "uuid2")
  private String id;
  private String number;
  private String citycode;
  private String countrycode;

  @ManyToOne
  @JoinColumn(name = "user_id")
  private UserJpaMapper user;
}
