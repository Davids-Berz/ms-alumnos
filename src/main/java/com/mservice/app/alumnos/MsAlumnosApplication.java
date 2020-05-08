package com.mservice.app.alumnos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class MsAlumnosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsAlumnosApplication.class, args);
	}

}
