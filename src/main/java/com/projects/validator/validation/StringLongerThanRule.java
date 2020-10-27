package com.projects.validator.validation;

public class StringLongerThanRule extends PrimitiveFieldRule {
	
	
	StringLongerThanRule(int _targetedValue){
		super(_targetedValue);
	}
	
	StringLongerThanRule(String fieldName, int _targetedValue){
		super(fieldName, _targetedValue);
	}

	@Override
	protected boolean checkValue(Object actualValue) {
		
		if(((String)actualValue).length() < (int)targetedValue)
			return false;
		else
			return true;
	}

	
}

