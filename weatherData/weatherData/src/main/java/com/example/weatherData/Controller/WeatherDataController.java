package com.example.weatherData.Controller;

import com.example.weatherData.Entity.WeatherData;
import com.example.weatherData.Service.WeatherService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/weather")
public class WeatherDataController {

    //Logger logger = LoggerFactory.getLogger(weatherDataController.class);

    @Autowired
    private WeatherService weatherService;

    @PostMapping("/add")
    @ApiOperation(value = "Admin can Add Train Details ",
            notes = "Provide the Train Details")
    public WeatherData addWeather(@RequestBody WeatherData weatherData) {
        return weatherService.addWeather(weatherData);

    }

    @GetMapping("/listall")
    public List<WeatherData> getWeather() {
        return weatherService.getWeather();
    }


    @DeleteMapping("/delete/{id}")
    public String deleteWeather(@PathVariable("id") long id) {
        weatherService.deleteWeather(id);
        return "data deleted successfully";
    }

//    @PutMapping("/update/{id}")
//    public WeatherData updateWeather(@RequestBody WeatherData weatherData, @PathVariable("id") long id) {
//        return weatherService.updateWeather(id, weatherData);
//    }
}