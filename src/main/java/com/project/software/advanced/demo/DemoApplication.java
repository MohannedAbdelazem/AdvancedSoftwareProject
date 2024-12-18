package com.project.software.advanced.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.project.software.advanced.demo")
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
/*
	jdbc:h2:file:D:/College/Advanced Software Engineering/Project/phase 2 final isa/demo/src/main/resources/databaseScheme/DatabaseRay2a

 */
}
