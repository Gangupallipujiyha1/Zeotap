package com.weathermoniter.Controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.weathermoniter.Service.WeatherService;
import com.weathermoniter.model.TemperatureSummary;
import com.weathermoniter.model.WeatherData;
import com.weathermoniter.repository.WeatherRepository;

@Controller
@RequestMapping("/weather")
public class WeatherController {

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private WeatherRepository weatherRepository;

    @GetMapping("/input")
    public String showInputPage() {
        return "index"; // Return the name of the HTML template (index.html)
    }

    @GetMapping("/{city}")
    public String getCurrentWeather(@PathVariable String city, Model model) {
        WeatherData weatherData = weatherService.fetchWeatherData(city);
        model.addAttribute("weatherData", weatherData);
        return "weather-summary"; // Return view name to display weather data
    }

    @GetMapping("/summary/{city}")
    public TemperatureSummary getDailySummary(@PathVariable String city) {
        List<WeatherData> dailyData = weatherRepository.findByCityAndDate(city, LocalDate.now());
        return weatherService.calculateDailySummary(dailyData);
    }

    @GetMapping("/weather/details")
    public String getWeatherDetails(@RequestParam("city") String city, Model model) {
        WeatherData weatherData = weatherService.fetchWeatherData(city);
        model.addAttribute("weatherData", weatherData);
        return "weather-summary"; // This should match your weather-summary.html file name
    }
}
