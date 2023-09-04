package com.example.weatherData.Service;

import com.example.weatherData.Entity.WeatherData;

import java.util.List;

public interface WeatherService {
    WeatherData addWeather(WeatherData weatherData);

    List<WeatherData> getWeather();

    void deleteWeather(long id);

//    WeatherData updateWeather(long id, WeatherData weatherData);


}
