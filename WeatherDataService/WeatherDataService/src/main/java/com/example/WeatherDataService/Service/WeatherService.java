package com.example.WeatherDataService.Service;

import com.example.WeatherDataService.Entity.OpenWeatherResponse;
import com.example.WeatherDataService.Entity.WeatherData;
import com.example.WeatherDataService.Entity.WeatherApiResponse;
import com.example.WeatherDataService.Exception.WeatherDataException;
import com.example.WeatherDataService.Repository.WeatherRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherService {
    @Autowired
    private WeatherRepository weatherRepository;

    @Value("${openweather.apikey}")
    private String apiKey;

    private static final String API_BASE_URL = "http://api.openweathermap.org/data/2.5/weather?q={city}&appid={apiKey}";

    private final RestTemplate restTemplate = new RestTemplate();

    @Transactional
    public WeatherData saveWeatherByCity(String city) {
        try {
            String apiUrl = API_BASE_URL.replace("{city}", city).replace("{apiKey}", apiKey);
            OpenWeatherResponse response = restTemplate.getForObject(apiUrl, OpenWeatherResponse.class);

            WeatherData weatherEntity = new WeatherData();
            weatherEntity.setCity(city);
            weatherEntity.setTemperature(response.getMain().getTemp());
            weatherEntity.setHumidity(response.getMain().getHumidity());

            return weatherRepository.save(weatherEntity);
        }
        catch (Exception e)
        {
            throw new WeatherDataException("Sorry could not fetch details for the given  " + city+ " name!");
        }
    }

    public List<WeatherData> getAllWeatherData() {
        return weatherRepository.findAll();
    }



    //    @Autowired
//    private WeatherRepository weatherRepository;
//
//
//    @Override
//    public WeatherData addWeather(WeatherData weatherData) {
//        return weatherRepository.save(weatherData);
//    }
//    @Override
//    public List<WeatherData> getWeather()
//    {
//        return weatherRepository.findAll();
//    }
//
//
//    @Override
//    public void deleteWeather(long id)
//    {
//        weatherRepository.deleteById(id);
//    }


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
