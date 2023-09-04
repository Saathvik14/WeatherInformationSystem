package com.example.locationManagementService.Controller;

import com.example.locationManagementService.Entity.WeatherData;
import com.example.locationManagementService.Entity.WeatherForecastData;
import com.example.locationManagementService.Service.WeatherForecastService;
import com.example.locationManagementService.Service.WeatherService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/loc")
public class LocationController {

    @Autowired
    WeatherService weatherService;

    @Autowired
    WeatherForecastService weatherForecastService;

    //Weather Data Controller

    @PostMapping("/add")
    public WeatherData add(@Valid @RequestBody WeatherData weatherData) {
        return weatherService.add(weatherData);
    }

    @GetMapping("/view/{city}")
    public ResponseEntity viewCity(@PathVariable(value = "city") String city){
        return weatherService.viewCity(city);
    }

    @GetMapping("/listall")
    public ResponseEntity listAll(){
        return weatherService.listAll();
    }

    @DeleteMapping("/remove/{Wid}")
    public String deleteWeather(@PathVariable("Wid") Long Wid) {

        weatherService.deleteWeather(Wid);
        return "data deleted successfully";
    }
    @PutMapping("/WeatherUpd/{Wid}")
    public WeatherData updateWeather(@RequestBody WeatherData weatherData, @PathVariable("Wid") Long Wid) {
        return weatherService.updateWeather(Wid, weatherData);
    }


    //Weather Forecast Controller

    @GetMapping("/viewForecast/{city}")
    public ResponseEntity viewCityF(@PathVariable(value = "city") String city){
        return weatherForecastService.viewCityF(city);
    }

    @GetMapping("/listForecast")
    public ResponseEntity listAllF(){
        return weatherForecastService.listAllF();
    }
    @PostMapping("/addForecast")
    public WeatherForecastData addF(@Valid @RequestBody WeatherForecastData weatherForecastData) {
        return weatherForecastService.addF(weatherForecastData);
    }

    @DeleteMapping("/delete/{Fid}")
    public String deleteForecast(@PathVariable("Fid") Long Fid) {

        weatherForecastService.deleteForecast(Fid);
        return "data deleted successfully";
    }

    @PutMapping("/ForecastUpd/{Fid}")
    public WeatherForecastData updateForecast(@RequestBody WeatherForecastData weatherForecastData, @PathVariable("Fid") Long Fid) {
        return weatherForecastService.updateForecast(Fid, weatherForecastData);
    }


//    @PutMapping("update/{Wid}")
//    public ResponseEntity updateWeather(@Valid @RequestBody WeatherData weatherData, @PathVariable
//            (value= "Wid") Long Wid){
//        return weatherService.updateWeather(weatherData,Wid);
//    }

//    @DeleteMapping("/delete/{Wid}")
//    public ResponseEntity deleteWeather(@PathVariable(value = "Wid") Long Wid){
//        return weatherService.deleteWeather(Wid);
//    }


}
