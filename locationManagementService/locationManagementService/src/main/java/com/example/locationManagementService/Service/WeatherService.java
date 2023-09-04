package com.example.locationManagementService.Service;

import com.example.locationManagementService.Entity.WeatherData;
import com.example.locationManagementService.Repository.WeatherDataRepository;
import com.example.locationManagementService.Repository.WeatherForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class WeatherService {

    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private WeatherDataRepository weatherDataRepository;





    public WeatherData add(WeatherData weatherData) {
        return weatherDataRepository.save(weatherData);
    }


    public ResponseEntity<WeatherData[]> listAll() throws HttpClientErrorException {
    WeatherData[] response= restTemplate.getForEntity("http://localhost:8059/weather/all",WeatherData[].class).getBody();
    return new ResponseEntity<>(response,HttpStatus.OK);
    }



    public ResponseEntity viewCity(String city) throws HttpClientErrorException {
        WeatherData weatherData=restTemplate.getForObject("http://localhost:8059/weather/"+city,WeatherData.class);
    return new ResponseEntity(weatherData, HttpStatus.OK);
    }


    public void deleteWeather(Long Wid) {
        weatherDataRepository.deleteById(Wid);
    }

    public WeatherData updateWeather(Long Wid, WeatherData weatherData) {
        Optional<WeatherData> findById = weatherDataRepository.findById(Wid);
        if(findById.isPresent()){
            WeatherData weatherUpdate=findById.get();
            if(weatherData.getCity()!=null && !weatherData.getCity().isEmpty())
                weatherUpdate.setCity(weatherData.getCity());
            if(weatherData.getTemperature()!=null)
                weatherUpdate.setTemperature(weatherData.getTemperature());
            if(weatherData.getHumidity()!=null)
                weatherUpdate.setHumidity(weatherData.getHumidity());
            return weatherDataRepository.save(weatherData);
        }
        return null;
    }

    }

