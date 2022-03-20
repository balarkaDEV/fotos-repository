package com.fotos.equipment.master.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableEurekaClient
public class EquipmentMasterServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EquipmentMasterServiceApplication.class, args);
	}
}
