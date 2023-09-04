package com.example.weatherForecastService.Entity;

import lombok.Data;

import java.util.List;

@Data
public class OpenWeatherForecastResponse {
    private List<Forecast> list;

    @Data
    public static class Forecast {
        private long dt;
        private Main main;

        @Data
        public static class Main {
            private double temp;
            private int humidity;
        }
    }
}