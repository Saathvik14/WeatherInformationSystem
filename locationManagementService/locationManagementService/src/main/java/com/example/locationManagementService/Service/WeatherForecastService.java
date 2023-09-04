package com.example.locationManagementService.Service;

import com.example.locationManagementService.Entity.WeatherData;
import com.example.locationManagementService.Entity.WeatherForecastData;
import com.example.locationManagementService.Repository.WeatherForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Service
public class WeatherForecastService {
    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private WeatherForecastRepository weatherForecastRepository;


    public ResponseEntity viewCityF(String city) throws HttpClientErrorException {
        WeatherForecastData weatherForecastData=restTemplate.getForObject("http://localhost:8059/forecast/"+city, WeatherForecastData.class);
        return new ResponseEntity(weatherForecastData, HttpStatus.OK);
    }

    public ResponseEntity listAllF()  throws HttpClientErrorException {
        WeatherForecastData[] response= restTemplate.getForEntity("http://localhost:8061/forecast/all",WeatherForecastData[].class).getBody();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    public WeatherForecastData addF(WeatherForecastData weatherForecastData) {
        return weatherForecastRepository.save(weatherForecastData);
    }

    public void deleteForecast(Long Fid) {
        weatherForecastRepository.deleteById(Fid);
    }

    public WeatherForecastData updateForecast(Long Fid, WeatherForecastData weatherForecastData) {
        Optional<WeatherForecastData> findById = weatherForecastRepository.findById(Fid);
        if(findById.isPresent()){
            WeatherForecastData ForecastUpdate=findById.get();
            if(weatherForecastData.getCity()!=null && !weatherForecastData.getCity().isEmpty())
                ForecastUpdate.setCity(weatherForecastData.getCity());
            if(weatherForecastData.getTemperature()!=null)
                ForecastUpdate.setTemperature(weatherForecastData.getTemperature());
            if(weatherForecastData.getDate()!=null)
                ForecastUpdate.setDate(weatherForecastData.getDate());
            if(weatherForecastData.getHumidity()!=null)
                ForecastUpdate.setHumidity(weatherForecastData.getHumidity());
            return weatherForecastRepository.save(weatherForecastData);
        }
        return null;
    }
}
