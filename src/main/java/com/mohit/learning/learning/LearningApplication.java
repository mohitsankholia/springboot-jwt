package com.mohit.learning.learning;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.mohit.learning.learning.controller.DepartmentController;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title="Practice API", version ="2.0", description ="Practice Microservice") )
public class LearningApplication {

	public static void main(String[] args) {
		
//		Logger LOGGER = LogManager.getLogger(LearningApplication.class);
		
		SpringApplication.run(LearningApplication.class, args);
		 
//		LOGGER.info("Application Started at port 8081..!");
	}

}
