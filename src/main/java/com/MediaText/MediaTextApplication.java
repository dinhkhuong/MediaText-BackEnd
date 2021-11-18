package com.MediaText;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//@SpringBootApplication(exclude = { SecurityAutoConfiguration.class }) /// temporary disconnect Spring security
@SpringBootApplication
public class MediaTextApplication {

	public static void main(String[] args) {
		SpringApplication.run(MediaTextApplication.class, args);
	}

}
