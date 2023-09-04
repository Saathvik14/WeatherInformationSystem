package com.example.weatherForecastService.Service;

import com.example.weatherForecastService.Entity.OpenWeatherForecastResponse;
import com.example.weatherForecastService.Entity.WeatherForecastData;
import com.example.weatherForecastService.Exception.WeatherForecastException;
import com.example.weatherForecastService.Repository.WeatherForecastRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Service
public class WeatherService {

    @Autowired
    private WeatherForecastRepository weatherForecastRepository;

    @Value("${openweather.apikey}")
    private String apiKey;

    private static final String API_FORECAST_URL = "https://api.openweathermap.org/data/2.5/forecast?q={city}&appid={apiKey}";

    private final RestTemplate restTemplate = new RestTemplate();

    @Transactional
    public WeatherForecastData saveWeatherForecast(String city) {
        try {
            String apiUrl = API_FORECAST_URL.replace("{city}", city).replace("{apiKey}", apiKey);

            //To make an API request and the process of deserializing the respinse bcause the request is of json
            //and to convert it into java objects and store it in repo
            OpenWeatherForecastResponse forecastResponse = restTemplate.getForObject(apiUrl, OpenWeatherForecastResponse.class);

            WeatherForecastData savedForecast = null;

            //Checking if the forecast response is not null before we iterate
            if (forecastResponse != null && forecastResponse.getList() != null) {

                for (OpenWeatherForecastResponse.Forecast forecast : forecastResponse.getList()) {
                    WeatherForecastData forecastEntity = new WeatherForecastData();
                    forecastEntity.setCity(city);
                    //Conversion of the unix timestamp (long) to LocalDate
                    //forecastEntity.setDate(forecast.getDt());
                    Instant instant = Instant.ofEpochSecond(forecast.getDt());
                    LocalDate date = instant.atZone(ZoneId.systemDefault()).toLocalDate();
                    forecastEntity.setDate(date);
                    //Set Temperature
                    forecastEntity.setTemperature(forecast.getMain().getTemp());
                    //Set Humidity
                    forecastEntity.setHumidity(forecast.getMain().getHumidity());

                    // Save the forecast data to the repository
                    savedForecast = weatherForecastRepository.save(forecastEntity);
                }
            }

            return savedForecast;

        } catch (Exception e) {
            throw new WeatherForecastException("Sorry Could not fetch the details for the give " + city+ " name!");
        }
    }

    public List<WeatherForecastData> getAllWeatherForecasts() {
        return weatherForecastRepository.findAll();
    }
}
