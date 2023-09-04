package com.example.ApiGateway;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringCloudGatewayRouting {
    @Bean
    public RouteLocator configureRoute(RouteLocatorBuilder builder)
    {
        return (RouteLocator) builder.routes()
                .route("Weather-Data-service",r-> r.path("/weather/**").uri("lb://Weather-Data-service"))
                .route("Weather-Forecast-Service",r->r.path("/forecast/**").uri("lb://Weather-Forecast-Service"))
                .route("Location-Management-Service",r->r.path("/loc/**").uri("lb://Location-Management-Service"))
                .build();
    }

}