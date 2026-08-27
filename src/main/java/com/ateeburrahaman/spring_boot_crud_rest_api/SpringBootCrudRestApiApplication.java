package com.ateeburrahaman.spring_boot_crud_rest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class })
public class SpringBootCrudRestApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootCrudRestApiApplication.class, args);

		System.out.println("Hello World");
	}


}
