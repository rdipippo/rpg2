package com.deadsimple.rpg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class RpgApplication {
	public static void main(String[] args) {
		SpringApplication.run(RpgApplication.class, args);
	}
}
