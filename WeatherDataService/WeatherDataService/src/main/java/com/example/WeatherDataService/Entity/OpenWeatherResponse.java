package com.example.WeatherDataService.Entity;

import lombok.Data;

@Data
public class OpenWeatherResponse {
    private Main main;

    @Data
    public static class Main {
        private double temp;
        private int humidity;
    }
}
