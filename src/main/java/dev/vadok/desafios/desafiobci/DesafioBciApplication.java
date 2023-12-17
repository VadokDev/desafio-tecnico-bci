package dev.vadok.desafios.desafiobci;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "dev.vadok.desafios.desafiobci.core.usecases.CreateUser.boundaries")
public class DesafioBciApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioBciApplication.class, args);
	}
}
