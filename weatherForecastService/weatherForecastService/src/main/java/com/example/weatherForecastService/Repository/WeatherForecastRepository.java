package com.example.weatherForecastService.Repository;

import com.example.weatherForecastService.Entity.WeatherForecastData;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WeatherForecastRepository  extends JpaRepository<WeatherForecastData, Long> {
}
