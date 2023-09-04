package com.example.weatherForecastService.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Weather-Forecast")
public class WeatherForecastData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Fid;

    private String city;
    private LocalDate date;
    private Double temperature;
    private Integer humidity;



}
