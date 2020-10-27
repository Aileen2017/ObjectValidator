package com.projects.validator.validation;

public class StringShorterThanRule extends PrimitiveFieldRule {
	
	
	StringShorterThanRule(int _targetedValue){
		super(_targetedValue);
	}
	
	StringShorterThanRule(String fieldName, int _targetedValue){
		super(fieldName, _targetedValue);
	}
	

	@Override
	protected boolean checkValue(Object actualValue) {
		
		if(((String)actualValue).length() > (int)targetedValue)
			return false;
		else
			return true;
	}
	

}
