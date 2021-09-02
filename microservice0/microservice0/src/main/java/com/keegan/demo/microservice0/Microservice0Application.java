package com.keegan.demo.microservice0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class Microservice0Application {

	public static void main(String[] args) {
		SpringApplication.run(Microservice0Application.class, args);
	}

}
