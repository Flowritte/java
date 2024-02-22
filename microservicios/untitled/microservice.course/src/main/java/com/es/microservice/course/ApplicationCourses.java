package com.es.microservice.course;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients //habilitacion de cliente feing del miroservicio para su intercomunicacion
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
