package com.nubyte.nubytebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication
@EntityScan("com.nubyte.model")
@EnableJpaRepositories("com.nubyte.repositories")
@ComponentScan("com.nubyte.services.rest")
public class NubyteBackendApplication {

	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		   return application.sources(application);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(NubyteBackendApplication.class, args);
	}
}
