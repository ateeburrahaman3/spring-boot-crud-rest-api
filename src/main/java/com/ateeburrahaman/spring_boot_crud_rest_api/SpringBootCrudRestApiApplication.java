package com.ateeburrahaman.spring_boot_crud_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringBootCrudRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudRestApiApplication.class, args);

		System.out.println("Application Started....");
	}


}
