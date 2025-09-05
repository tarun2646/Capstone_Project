package com.wipro.tarun;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TranscationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TranscationServiceApplication.class, args);
	}

}
