package com.projects.validator.validation.contextAwareValidation;

public class RuleData {
	
	public String className;
	public String keyName;
	public String ruleName;
	public String value;
	
	RuleData(String _className, String _keyName, String _ruleName, String _value){
		className = _className;
		keyName = _keyName;
		ruleName = _ruleName;
		value = _value;
		
	}

}
