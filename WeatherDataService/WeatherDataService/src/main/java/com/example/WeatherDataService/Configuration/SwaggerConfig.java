package com.example.WeatherDataService.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;


@Configuration
public class SwaggerConfig {
//    @Bean
//    public Docket api() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .select()
//                .apis(RequestHandlerSelectors.basePackage("com.example.WeatherDataService"))
//                .paths(PathSelectors.any())
//                .build()
//                .apiInfo(metaData());
//    }
//
//    private ApiInfo metaData() {
//        return new ApiInfoBuilder()
//                .title("Weather REST API Documentation")
//                .description("\"REST API developed in Java with Spring Boot in order to provide information on weather information.\"")
//                .version("1.0.0")
//                .build();
//    }
//

}
