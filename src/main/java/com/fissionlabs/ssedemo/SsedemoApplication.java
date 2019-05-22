package com.fissionlabs.ssedemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

import ch.rasc.sse.eventbus.config.EnableSseEventBus;

@SpringBootApplication
//@EnableEurekaClient
@EnableSseEventBus
public class SsedemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsedemoApplication.class, args);
	}

}
