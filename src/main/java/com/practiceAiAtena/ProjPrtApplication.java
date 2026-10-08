package com.practiceAiAtena;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class ProjPrtApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjPrtApplication.class, args);
	}

}
