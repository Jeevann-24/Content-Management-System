package com.example.ContentManagementSystem.Utility;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;


@Configuration
@OpenAPIDefinition
public class AppDocumentation {
	@Bean
	io.swagger.v3.oas.models.info.Info info(){
		return new io.swagger.v3.oas.models.info.Info().title("Content Management System")
				.description("RESTfull API with basic CRUD Operation")
				.version("v1")
				.contact(contact());
	}
	@Bean
	OpenAPI  openAPI () {
		return new OpenAPI().info((io.swagger.v3.oas.models.info.Info) info());
	}
    @Bean
	Contact contact() {
		return new Contact().name("Jeevan Gowda")
				.url("jeevangowda2410@gmail.com")
				.email("jeevangowda2410@gmail.com");
	}
}
