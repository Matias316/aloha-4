package com.company;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestApiBootstrap {
 
	private static final Logger logger = LoggerFactory.getLogger(RestApiBootstrap.class);

	public static void main(String[] args) {
		logger.info("Initializing Package Manager...");

		SpringApplication.run(RestApiBootstrap.class, args);
	}
}
