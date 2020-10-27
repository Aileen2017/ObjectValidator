package com.projects.validator.validation.rules;

public class NumericalGreaterThanRule extends PrimitiveFieldRule {

	NumericalGreaterThanRule(int _targetedValue){
		super(_targetedValue);
	}
	
	NumericalGreaterThanRule(String fieldName, int _targetedValue){
		super(fieldName, _targetedValue);
	}
	

	protected boolean checkValue(Object actualValue) {
		
		if((int)actualValue >(int) targetedValue)
			return true;
		else
			return false;
		
	}
	
	

}
