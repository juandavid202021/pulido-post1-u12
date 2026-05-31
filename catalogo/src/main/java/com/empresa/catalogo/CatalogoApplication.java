package com.empresa.catalogo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@OpenAPIDefinition(
		info = @Info(
				title = "API Catálogo de Productos",
				version = "1.0",
				description = "API REST para la gestión del catálogo de productos"
		)
)
@SpringBootApplication
public class CatalogoApplication {
	public static void main(String[] args) {
		SpringApplication.run(CatalogoApplication.class, args);
	}
}