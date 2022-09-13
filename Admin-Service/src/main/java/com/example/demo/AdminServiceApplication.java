package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableEurekaClient
@EnableSwagger2
public class AdminServiceApplication {
	

	@Bean
	public RestTemplate getTemplate() {
		return new RestTemplate();
	}


	public static void main(String[] args) {
		SpringApplication.run(AdminServiceApplication.class, args);
	}

}
