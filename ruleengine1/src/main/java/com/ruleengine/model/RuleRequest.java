package com.ruleengine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RuleRequest {
    private String ruleName;
    private String description;
    private String department;
    private int age;

    
}
