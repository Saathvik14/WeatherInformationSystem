package com.example.locationManagementService.Repository;

import com.example.locationManagementService.Entity.WeatherForecastData;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherForecastRepository extends BaseWeatherRepository<WeatherForecastData> {
}
