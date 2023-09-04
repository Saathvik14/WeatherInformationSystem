package com.example.weatherForecastService.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExcptionHandler {

    @ExceptionHandler(WeatherForecastException.class)
    public ResponseEntity<String> handleWeatherForecastException(WeatherForecastException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }
}
