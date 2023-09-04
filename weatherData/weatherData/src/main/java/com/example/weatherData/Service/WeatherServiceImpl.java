package com.example.weatherData.Service;


import com.example.weatherData.Entity.WeatherData;
import com.example.weatherData.Repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Autowired
    private WeatherRepository weatherRepository;


    @Override
    public WeatherData addWeather(WeatherData weatherData) {
        return weatherRepository.save(weatherData);
    }
    @Override
    public List<WeatherData> getWeather()
    {
        return weatherRepository.findAll();
    }




    @Override
    public void deleteWeather(long id)
    {
        weatherRepository.deleteById(id);
    }


//    @Override
//    public WeatherData updateWeather(long id, WeatherData weatherData) {
//        Optional<WeatherData> findById = weatherRepository.findById(id);
//        if(findById.isPresent()){
//            WeatherData weatherUpdate=findById.get();
//            if(weatherData.getTemperature()!=null && !weatherData.getTemperature().isEmpty())
//                weatherUpdate.setTemperature(weatherUpdate.getTemperature());
//            if(weatherData.getHumidity()!=null && !weatherData.getHumidity().isEmpty())
//                weatherUpdate.setHumidity(weatherData.getHumidity());
//            if(weatherData.getPrecipitation()!=null && !weatherData.getPrecipitation().isEmpty())
//                weatherUpdate.setPrecipitation(weatherData.getPrecipitation());
//            return weatherRepository.save(weatherUpdate);
//        }
//        return null;
//    }



}