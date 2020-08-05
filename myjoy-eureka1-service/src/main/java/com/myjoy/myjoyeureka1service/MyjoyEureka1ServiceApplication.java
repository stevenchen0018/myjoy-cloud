package com.myjoy.myjoyeureka1service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@EnableEurekaServer
@SpringBootApplication
public class MyjoyEureka1ServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyjoyEureka1ServiceApplication.class, args);
	}

}
