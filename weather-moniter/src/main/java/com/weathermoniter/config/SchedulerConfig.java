package com.weathermoniter.config;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import com.weathermoniter.Service.WeatherService;
import com.weathermoniter.model.WeatherData;

@Configuration
@EnableScheduling
public class SchedulerConfig {

    @Autowired
    private WeatherService weatherService;

    @Scheduled(fixedRate = 300000) // 5 minutes interval
    public void scheduledWeatherUpdate() {
        List<String> cities = List.of("Delhi", "Mumbai", "Chennai", "Bangalore", "Kolkata", "Hyderabad");
        cities.forEach(city -> {
            WeatherData data = weatherService.fetchWeatherData(city);
            // Store data in a database for rollup/aggregate processing
        });
    }
}
