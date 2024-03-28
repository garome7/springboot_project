package com.example.springboot_project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("com.example.springboot_project")
@SpringBootApplication
public class SpringbootProjectApplication {

	public static void main(String[] args) {SpringApplication.run(SpringbootProjectApplication.class, args);}
}
