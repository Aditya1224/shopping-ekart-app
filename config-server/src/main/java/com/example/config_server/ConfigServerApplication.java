package com.example.config_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@SpringBootApplication
public class ConfigServerApplication {


	@GetMapping("/{greet}")
	public String sayHello(@PathVariable("greet") String greet) {
		return greet;
	}
	public static void main(String[] args) {
		SpringApplication.run(ConfigServerApplication.class, args);
	}

}
