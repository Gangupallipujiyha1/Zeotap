package com.weathermoniter.Service;


import org.springframework.stereotype.Service;

import com.weathermoniter.model.Alert;
import com.weathermoniter.model.WeatherData;

@Service
public class AlertService {

    private static final double TEMP_THRESHOLD_CELSIUS = 35.0;
    
    public Alert checkForAlert(WeatherData weatherData) {
        double temperatureCelsius = weatherData.getTemperatureKelvin() - 273.15;
        if (temperatureCelsius > TEMP_THRESHOLD_CELSIUS) {
            return new Alert("High temperature alert", System.currentTimeMillis(), "Temperature > " + TEMP_THRESHOLD_CELSIUS);
        }
        return null;
    }
}
