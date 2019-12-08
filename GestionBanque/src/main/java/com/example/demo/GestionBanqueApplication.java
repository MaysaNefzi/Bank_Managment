package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import DAO.ClientRepository;
import Entities.Client;

@SpringBootApplication
@EntityScan( basePackages = {"Entities"} )
@EnableJpaRepositories(basePackages= {"DAO"})
public class GestionBanqueApplication implements CommandLineRunner {

	@Autowired
	private ClientRepository C_repo;
	public static void main(String[] args) {
		SpringApplication.run(GestionBanqueApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Client C1=C_repo.save(new Client("Nefzi","Maysa","nefzimaysa@gmail.com"));
		
	}

}
