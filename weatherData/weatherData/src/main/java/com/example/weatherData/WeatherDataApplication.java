package com.example.weatherData;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;



import java.util.Collections;

@SpringBootApplication
@EnableDiscoveryClient

public class WeatherDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeatherDataApplication.class, args);
	}

	@Bean
	public Docket swaggerConfiguration() {
		//Return a prepared docket instance
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.example"))
				.build()
				.apiInfo(apiDetails());
	}

	private ApiInfo apiDetails() {
		return new ApiInfo(
				"Weather Management Service APi",
				"Sample API for Weather Management Service",
				"1.0",
				"Free To use",
				new springfox.documentation.service.Contact("S Saathvik","https://github.com/Saathvik14","Saath12@gmail.com"),
				"API License",
				"https://github.com/Saathvik14",
				Collections.EMPTY_LIST
		);
	}

}
