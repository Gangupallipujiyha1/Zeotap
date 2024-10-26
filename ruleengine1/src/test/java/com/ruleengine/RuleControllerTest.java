package com.ruleengine;



	import com.ruleengine.contoller.RuleController;
	import com.ruleengine.model.RuleRequest;
	import com.ruleengine.Service.RuleService;
	import org.junit.jupiter.api.BeforeEach;
	import org.junit.jupiter.api.Test;
	import org.mockito.Mockito;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
	import org.springframework.boot.test.mock.mockito.MockBean;
	import org.springframework.test.web.servlet.MockMvc;
	import org.springframework.test.web.servlet.setup.MockMvcBuilders;
	import org.springframework.web.context.WebApplicationContext;

	import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
	import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
	import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

	@WebMvcTest(RuleController.class)
	public class RuleControllerTest {

	    @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private RuleService ruleService;

	    @Autowired
	    private WebApplicationContext webApplicationContext;

	    @BeforeEach
	    public void setup() {
	        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
	    }

	    @Test
	    public void testShowRuleForm() throws Exception {
	        mockMvc.perform(get("/rules/form"))
	                .andExpect(status().isOk())
	                .andExpect(view().name("rule-form"))
	                .andExpect(model().attributeExists("ruleRequest"));
	    }

	    @Test
	    public void testEvaluateRule_Success() throws Exception {
	        // Mock the service to return a success message
	        Mockito.when(ruleService.evaluateRule(Mockito.any(RuleRequest.class)))
	               .thenReturn("Rule evaluation passed.");

	        mockMvc.perform(post("/rules/evaluate")
	                .param("ruleName", "Test Rule")
	                .param("description", "Test description")
	                .param("department", "Sales")
	                .param("age", "35"))
	                .andExpect(status().isOk())
	                .andExpect(view().name("rule-form"))
	                .andExpect(model().attribute("resultMessage", "Rule evaluation passed."));
	    }

	    @Test
	    public void testEvaluateRule_Failure() throws Exception {
	        // Mock the service to return a failure message
	        Mockito.when(ruleService.evaluateRule(Mockito.any(RuleRequest.class)))
	               .thenReturn("Rule evaluation failed.");

	        mockMvc.perform(post("/rules/evaluate")
	                .param("ruleName", "Test Rule")
	                .param("description", "Test description")
	                .param("department", "HR")
	                .param("age", "28"))
	                .andExpect(status().isOk())
	                .andExpect(view().name("rule-form"))
	                .andExpect(model().attribute("resultMessage", "Rule evaluation failed."));
	    }
	}

