package com.pokeapi.abilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;


@SpringBootApplication
@RestController
public class AbilitiesApplication {
	private static Logger logger = LoggerFactory.getLogger(AbilitiesApplication.class);
	@Operation(summary = "Check Health")
	@GetMapping("/")
	public static String checkHealth(){
		return "Abilities Application Works!";
	}

	public static void main(String[] args) {
		SpringApplication.run(AbilitiesApplication.class, args);
		logger.info("Aplicación iniciada");
	}

}
