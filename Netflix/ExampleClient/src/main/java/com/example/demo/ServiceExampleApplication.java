package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@RestController
public class ServiceExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceExampleApplication.class, args);
	}


	@GetMapping("/hello")
	public String hello(){
		return "Hello I am Exmaple!";
	}

}
