package com.projects.validator.validation;

public abstract class Rule {
	
	public String fieldName;
	
	public abstract boolean validate(Object containerValue);
	
	

}
