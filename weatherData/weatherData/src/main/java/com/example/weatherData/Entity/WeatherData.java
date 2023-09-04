package com.example.weatherData.Entity;


import io.swagger.annotations.ApiModel;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;




@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Builder
@Table(name= "WeatherReport" )
@ApiModel(description = "Details about the Weather Model")
public class WeatherData {

    @Id
    @GeneratedValue
    private Long id;

    private double temperature;
    private double humidity;
    private double precipitation;


}
