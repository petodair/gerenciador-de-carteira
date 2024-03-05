package br.com.gerenciaCarteira;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class GerenciaCarteiraApplication {

	public static void main(String[] args) {
		SpringApplication.run(GerenciaCarteiraApplication.class, args);
	}

}
