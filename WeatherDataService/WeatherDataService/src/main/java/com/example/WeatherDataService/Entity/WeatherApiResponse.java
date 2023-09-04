package com.example.WeatherDataService.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
///Dummy Class
public class WeatherApiResponse {

    private Coord coord;
    private List<Weather> weather;
    private Main main;
    private Wind wind;
    private Long visibility;
    private Clouds clouds;
    private Long dt;
    private Sys sys;
    private Long timezone;
    private Long id;
    private String name;
    private Long cod;

    // Other fields, getters, setters, and inner classes

    @Getter
    @Setter
    public static class Coord {
        private Double lon;
        private Double lat;
    }

    @Getter
    @Setter
    public static class Weather {
        private Long id;
        private String main;
        private String description;
        private String icon;
    }

    @Getter
    @Setter
    public static class Main {
        private Double temp;
        private Double feels_like;
        private Double temp_min;
        private Double temp_max;
        private Double pressure;
        private Double humidity;

        @JsonProperty("temp")
        public Double getTemperature() {
            return temp;
        }

        @JsonProperty("humidity")
        public Double getHumidity() {
            return humidity;
        }
    }

    @Getter
    @Setter
    public static class Wind {
        private Double speed;
        private Double deg;
    }

    @Getter
    @Setter
    public static class Clouds {
        private Long all;
    }

    @Getter
    @Setter
    public static class Sys {
        private Long type;
        private Long id;
        private String country;
        private Long sunrise;
        private Long sunset;
    }
}