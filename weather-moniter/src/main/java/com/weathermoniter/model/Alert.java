package com.weathermoniter.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Alert {
    private String alertMessage;
    private long timestamp;
    private String conditionBreached;
}
