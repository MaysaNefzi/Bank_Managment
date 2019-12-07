package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan( basePackages = {"Entities"} )
public class GestionBanqueApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionBanqueApplication.class, args);
	}

}
