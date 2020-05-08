package com.mservice.app.alumnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
@EntityScan({"com.mservice.commons.alumnos.models.entity"})
public class MsAlumnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAlumnosApplication.class, args);
	}

}
