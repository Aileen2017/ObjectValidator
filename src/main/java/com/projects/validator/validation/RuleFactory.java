package com.projects.validator.validation;

public interface RuleFactory {
	
	public Rule createRule(String ruleType, String targetedValue);
	
	
	public Rule createRule(String fieldName, String ruleType, String targetedValue);
	
	
	
	
	
	

}
