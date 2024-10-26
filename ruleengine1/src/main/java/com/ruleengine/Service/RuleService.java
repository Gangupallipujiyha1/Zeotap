package com.ruleengine.Service;


//import com.ruleengine.entity.Rule;
//import com.ruleengine.model.RuleRequest;
//import com.ruleengine.repository.RuleRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//@Service
//public class RuleService {
//
//    @Autowired
//    private RuleRepository ruleRepository;
//
//    public String processRule(RuleRequest ruleRequest) {
//        // Create a new Rule entity
//        Rule rule = new Rule();
//        rule.setRuleName(ruleRequest.getRuleName());
//        rule.setDescription(ruleRequest.getDescription());
//        rule.setDepartment(ruleRequest.getDepartment());
//        rule.setAge(ruleRequest.getAge());
//
//        // Save the rule entity in the database
//        ruleRepository.save(rule);
//
//        return "Rule created successfully with ID: " + rule.getId();
//    }


import com.ruleengine.model.RuleRequest;
import org.springframework.stereotype.Service;

@Service
public class RuleService {

    public String evaluateRule(RuleRequest ruleRequest) {
        // Basic rule validation logic (you can customize it as per your needs)
        if (ruleRequest.getAge() > 30 && "Sales".equalsIgnoreCase(ruleRequest.getDepartment())) {
            return "Rule evaluation passed.";
        }
        return "Rule evaluation failed.";
    }
}



