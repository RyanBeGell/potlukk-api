package dev.team2.Potlukk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "dev.team2")
@EntityScan(basePackages = "dev.team2.entities")
@EnableJpaRepositories(basePackages = "dev.team2.repos")

public class PotlukkApplication {

	public static void main(String[] args) {
		SpringApplication.run(PotlukkApplication.class, args);
	}

}
