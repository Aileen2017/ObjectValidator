package com.projects.validator.validation;

public class NumericalLessThanRule extends PrimitiveFieldRule {
	
	
	NumericalLessThanRule(double _targedtedValue){
		super(_targedtedValue);
	}
	
	NumericalLessThanRule(String fieldName, double _targetedValue){
		super(fieldName, _targetedValue);
	}
	
		
	
	protected boolean checkValue(Object actualValue) {
		
		if((double)actualValue < (double)targetedValue)
			return true;
		else
			return false;
		
	}
	

}
