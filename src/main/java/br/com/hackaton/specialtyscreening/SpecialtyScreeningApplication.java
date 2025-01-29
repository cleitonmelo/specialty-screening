package br.com.hackaton.specialtyscreening;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "API - Sistema de Triagem de Especialidades - SUS",
				description = "Projeto Hackaton Curso de Pós Graduação em Arquitetura Java - FIAP 2025",
				version = "1.0.0"
		)
)
public class SpecialtyScreeningApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpecialtyScreeningApplication.class, args);
	}

}
