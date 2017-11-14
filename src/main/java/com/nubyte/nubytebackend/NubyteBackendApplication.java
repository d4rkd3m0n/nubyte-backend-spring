package com.nubyte.nubytebackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.nubyte.logica.FacadeAppMovil;
import com.nubyte.logica.FacadeLogin;
import com.nubyte.logica.FacadePedirInfo;
import com.nubyte.logica.FacadeReserva;



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
	@Bean
	public FacadeLogin x(){
		return new FacadeLogin();
	}
	@Bean
	public FacadeAppMovil x1(){
		return new FacadeAppMovil();
	}
	@Bean
	public FacadePedirInfo x2(){
		return new FacadePedirInfo();
	}
	@Bean
	public FacadeReserva x3(){
		return new FacadeReserva();
	}
	
}
