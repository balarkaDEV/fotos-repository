package com.fotos.equipment.master.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class EquipmentMasterServiceApplication {
	public static void main(String[] args) {
		SpringApplication.run(EquipmentMasterServiceApplication.class, args);
	}
}
