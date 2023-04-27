package com.mohit.spring_jwt;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Practice API", version = "2.0", description = "Practice Microservice"))
public class SpringbootJWT {

	public static void main(String[] args) {

		Logger LOGGER = LogManager.getLogger(SpringbootJWT.class);

		SpringApplication.run(SpringbootJWT.class, args);

		LOGGER.info("Application Started..!");
	}

}
