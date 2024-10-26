package com.weathermoniter.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.weathermoniter.model.TemperatureSummary;
import com.weathermoniter.model.WeatherData;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeatherService {

    private static final String API_KEY = "2ebf7b9a8484ff5549aef5b8fa67abb6";
    private static final String WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q={city}&appid=" + API_KEY + "&units=metric";

    @Autowired
    private RestTemplate restTemplate;

    public WeatherData fetchWeatherData(String city) {
        return restTemplate.getForObject(WEATHER_URL, WeatherData.class, city);
    }

    public double convertKelvinToCelsius(double kelvin) {
        return kelvin - 273.15;
    }

    public TemperatureSummary calculateDailySummary(List<WeatherData> dailyData) {
        double avgTemp = dailyData.stream().mapToDouble(data -> convertKelvinToCelsius(data.getTemperatureKelvin())).average().orElse(0);
        double maxTemp = dailyData.stream().mapToDouble(data -> convertKelvinToCelsius(data.getTemperatureKelvin())).max().orElse(0);
        double minTemp = dailyData.stream().mapToDouble(data -> convertKelvinToCelsius(data.getTemperatureKelvin())).min().orElse(0);

        String dominantCondition = dailyData.stream()
                .collect(Collectors.groupingBy(WeatherData::getMainCondition, Collectors.counting()))
                .entrySet().stream().max((e1, e2) -> e1.getValue().compareTo(e2.getValue()))
                .map(e -> e.getKey()).orElse("Clear");

        return new TemperatureSummary(avgTemp, maxTemp, minTemp, dominantCondition);
    }
}
