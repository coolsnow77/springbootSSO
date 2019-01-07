package com.itdragon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
//public class StartApplication {
public class StartApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(StartApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(StartApplication.class);
	}
}
