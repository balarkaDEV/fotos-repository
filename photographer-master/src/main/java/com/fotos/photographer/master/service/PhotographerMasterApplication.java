package com.fotos.photographer.master.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
public class PhotographerMasterApplication {
	public static void main(String[] args) {
		SpringApplication.run(PhotographerMasterApplication.class, args);
	}
}
