package com.example.weatherData.Repository;

import com.example.weatherData.Entity.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository extends JpaRepository<WeatherData, Long> {
}
