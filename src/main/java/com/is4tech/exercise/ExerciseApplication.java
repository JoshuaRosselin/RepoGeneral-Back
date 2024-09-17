package com.is4tech.exercise;

import io.swagger.v3.oas.annotations.enums.SecuritySchemeIn;
import io.swagger.v3.oas.annotations.enums.SecuritySchemeType;
import io.swagger.v3.oas.annotations.security.SecurityScheme;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@SecurityScheme(name = "javainuseapi", //esquema de seguridad
		scheme = "basic", //esquema de autenticacion
		type = SecuritySchemeType.HTTP, //tipo de esquema que estamos utilizando
		in = SecuritySchemeIn.HEADER) //donde se colocaran, los credenciales, en el HEADER
public class ExerciseApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExerciseApplication.class, args);
	}

}
