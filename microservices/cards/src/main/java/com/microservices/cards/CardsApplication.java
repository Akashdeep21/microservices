package com.microservices.cards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@RefreshScope
@ComponentScans({ @ComponentScan("com.microservices.cards.controller") })
@EnableJpaRepositories("com.microservices.cards.repository")
@EntityScan("com.microservices.cards.model")
public class CardsApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.microservices.cards.CardsApplication.class, args);
	}

}
