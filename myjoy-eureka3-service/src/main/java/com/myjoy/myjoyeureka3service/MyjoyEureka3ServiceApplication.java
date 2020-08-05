package com.myjoy.myjoyeureka3service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MyjoyEureka3ServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyjoyEureka3ServiceApplication.class, args);
    }

}
