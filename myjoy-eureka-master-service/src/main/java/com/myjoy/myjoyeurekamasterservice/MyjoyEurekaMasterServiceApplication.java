package com.myjoy.myjoyeurekamasterservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MyjoyEurekaMasterServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyjoyEurekaMasterServiceApplication.class, args);
	}

}
