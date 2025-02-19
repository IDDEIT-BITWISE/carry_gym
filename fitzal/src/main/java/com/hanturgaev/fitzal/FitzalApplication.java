package com.hanturgaev.fitzal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class FitzalApplication {

	public static void main(String[] args) {
		SpringApplication.run(FitzalApplication.class, args);
	}

}
