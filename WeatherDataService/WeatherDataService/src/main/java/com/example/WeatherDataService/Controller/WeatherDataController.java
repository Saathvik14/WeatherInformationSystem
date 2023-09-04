package com.example.WeatherDataService.Controller;

import com.example.WeatherDataService.Entity.WeatherApiResponse;
import com.example.WeatherDataService.Entity.WeatherData;
import com.example.WeatherDataService.Service.WeatherService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/weather")
public class WeatherDataController {

    //Logger logger = LoggerFactory.getLogger(weatherDataController.class);



    @Autowired
    private WeatherService weatherService;

    @GetMapping("/{city}")
    public WeatherData getAndSaveWeatherByCity(@PathVariable String city) {
        return weatherService.saveWeatherByCity(city);
    }


    @GetMapping("/all")
    public List<WeatherData> getAllWeatherData() {
        return weatherService.getAllWeatherData();
    }


//    @PostMapping("/add")
////    @ApiOperation(value = "Admin can Add Train Details ",
////            notes = "Provide the Train Details")
//    @Operation(summary = "Get weather information")
//    public WeatherData addWeather(@RequestBody WeatherData weatherData) {
//        return weatherService.addWeather(weatherData);
//
//    }
//
//    @GetMapping("/listall")
//    public List<WeatherData> getWeather() {
//        return weatherService.getWeather();
//    }
//
//
//    @DeleteMapping("/delete/{id}")
//    public String deleteWeather(@PathVariable("id") long id) {
//        weatherService.deleteWeather(id);
//        return "data deleted successfully";
//    }

//    @PutMapping("/update/{id}")
//    public WeatherData updateWeather(@RequestBody WeatherData weatherData, @PathVariable("id") long id) {
//        return weatherService.updateWeather(id, weatherData);
//    }
}
