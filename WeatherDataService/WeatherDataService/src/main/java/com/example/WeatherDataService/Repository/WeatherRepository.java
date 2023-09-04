package com.example.WeatherDataService.Repository;

import com.example.WeatherDataService.Entity.WeatherData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeatherRepository  extends JpaRepository<WeatherData, Long> {

}
