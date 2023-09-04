package com.example.weatherForecastService.Controller;

import com.example.weatherForecastService.Entity.WeatherForecastData;
import com.example.weatherForecastService.Service.WeatherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/forecast")
public class WeatherForecastController {

    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public WeatherForecastData getAndSaveWeatherForecast(@PathVariable String city) {
        return weatherService.saveWeatherForecast(city);
    }

    @GetMapping("/all")
    public List<WeatherForecastData> getAllWeatherForecasts() {
        return weatherService.getAllWeatherForecasts();
    }
}
