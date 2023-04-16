package com.mohit.learning.learning;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="Practice API", version ="2.0", description ="Practice Microservice") )
public class LearningApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningApplication.class, args);
	}

}
