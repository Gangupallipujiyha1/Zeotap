package com.weathermoniter.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemperatureSummary {
    private double avgTemperature;
    private double maxTemperature;
    private double minTemperature;
    private String dominantCondition;
}
