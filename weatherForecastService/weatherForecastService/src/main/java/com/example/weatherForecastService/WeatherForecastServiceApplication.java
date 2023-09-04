package com.example.weatherForecastService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;



import java.util.Collections;

@SpringBootApplication
@EnableDiscoveryClient

public class WeatherForecastServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherForecastServiceApplication.class, args);
	}



}
