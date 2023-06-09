package com.microservices.loans;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@RefreshScope
@ComponentScans({ @ComponentScan("com.microservices.loans.controller") })
@EnableJpaRepositories("com.microservices.loans.repository")
@EntityScan("com.microservices.loans.model")
public class LoansApplication {

	public static void main(String[] args) {
		SpringApplication.run(com.microservices.loans.LoansApplication.class, args);
	}

}
