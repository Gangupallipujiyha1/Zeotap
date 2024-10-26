package com.ruleengine.contoller;


import com.ruleengine.model.RuleRequest;
//import com.ruleengine.Service.RuleService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;

//@RestController

//public class RuleController {
//
//    @Autowired
//    private RuleService ruleService;
//
//    @PostMapping("/evaluate")
//    public ResponseEntity<String> evaluateRule(@RequestBody RuleRequest ruleRequest) {
//        String response = ruleService.processRule(ruleRequest);
//        return ResponseEntity.ok(response);
//    }
	
	
	

	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.GetMapping;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

//	@Controller
//	public class RuleController {
//
//	    @Autowired
//	    private RuleService ruleService;
//
//	    @GetMapping("/rules/form")
//	    public String showRuleForm(Model model) {
//	        model.addAttribute("ruleRequest", new RuleRequest());
//	        return "rule-form";
//	    }
//
//	    @PostMapping("/rules/evaluate")
//	    public String evaluateRule(@ModelAttribute RuleRequest ruleRequest, Model model) {
//	        String result = ruleService.evaluateRule(ruleRequest);
//	        model.addAttribute("resultMessage", result);
//	        return "rule-form";
//	    }
//	    
	    
//	    import org.springframework.stereotype.Controller;
//	    import org.springframework.ui.Model;
//	    import org.springframework.web.bind.annotation.GetMapping;
//	    import org.springframework.web.bind.annotation.ModelAttribute;
//	    import org.springframework.web.bind.annotation.PostMapping;

	    @Controller
		@RequestMapping("/api")

	    public class RuleController {

	        // Display form
	        @GetMapping("/rules/form")
	        public String showForm(Model model) {
	            model.addAttribute("ruleRequest", new RuleRequest());
	            return "rule-form"; // Renders the Thymeleaf template rule-form.html
	        }

	        // Handle form submission
	        @PostMapping("/rules/evaluate")
	        public String evaluateRule(@ModelAttribute RuleRequest ruleRequest, Model model) {
	            // Logic to process the rule (this is just a placeholder)
	            String resultMessage = "Rule submitted: " + ruleRequest.getRuleName() +
	                    ", Department: " + ruleRequest.getDepartment() +
	                    ", Age: " + ruleRequest.getAge();

	            // Add result message to model
	            model.addAttribute("resultMessage", resultMessage);

	            // Return the same form with the result message
	            return "rule-form";
	        }
	    }

	


