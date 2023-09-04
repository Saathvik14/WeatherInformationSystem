package com.example.WeatherDataService.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name= "WeatherReport" )

public class WeatherData{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Wid;

    private String city;
    private Double temperature;
    private Integer humidity;
}
