package com.esd.stud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.esd.controller", "com.esd.dao", "com.esd.pojo"})
public class StudApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudApplication.class, args);
	}

}
