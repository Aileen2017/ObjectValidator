package com.projects.validator.validation;

public class RuleFactory {
	
	static final String GREATER_THAN = "GreaterThan";
	static final String LENGTH_LONGER_THAN = "LengthLongerThan";
	static final String LESS_THAN = "LessThan";
	static final String LENGTH_SHORTER_THAN = "LengthShorterThan";
	

	public static Rule createRule(String ruleType, String targetedValue) {
		Rule rule = null;
		if(ruleType.toUpperCase().trim().equals(GREATER_THAN.toUpperCase())) {
			rule = new NumericalGreaterThanRule(Integer.parseInt(targetedValue));
			
		}
		else if(ruleType.toUpperCase().trim().equals(LENGTH_LONGER_THAN.toUpperCase())) {
			rule = new StringLongerThanRule(Integer.parseInt(targetedValue));
		}
		else if(ruleType.toUpperCase().stripLeading().equals(LESS_THAN.toUpperCase())) {
			rule = new NumericalLessThanRule(Double.parseDouble(targetedValue));
			
		}
		else if(ruleType.toUpperCase().equals(LENGTH_SHORTER_THAN.toUpperCase())) {
			rule = new StringShorterThanRule(Integer.parseInt(targetedValue));
		}
		return rule;
		
		
	}
	
	public static Rule createRule(String fieldName, String ruleType, String targetedValue) {
		Rule rule = null;
		if(ruleType.toUpperCase().trim().equals(GREATER_THAN.toUpperCase())) {
			rule = new NumericalGreaterThanRule(fieldName, Integer.parseInt(targetedValue));
			
		}
		else if(ruleType.toUpperCase().trim().equals(LENGTH_LONGER_THAN.toUpperCase())) {
			rule = new StringLongerThanRule(fieldName, Integer.parseInt(targetedValue));
		}
		else if(ruleType.toUpperCase().stripLeading().equals(LESS_THAN.toUpperCase())) {
			rule = new NumericalLessThanRule(fieldName, Double.parseDouble(targetedValue));
			
		}
		else if(ruleType.toUpperCase().equals(LENGTH_SHORTER_THAN.toUpperCase())) {
			rule = new StringShorterThanRule(fieldName, Integer.parseInt(targetedValue));
		}
		return rule;
		
		
	}
	
	

}
