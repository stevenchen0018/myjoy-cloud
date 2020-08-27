package com.myjoy.myjoyconfigservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer
@EnableDiscoveryClient
@SpringBootApplication
public class MyjoyConfigServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyjoyConfigServiceApplication.class, args);
	}

}
