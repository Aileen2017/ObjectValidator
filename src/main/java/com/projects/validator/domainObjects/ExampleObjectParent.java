package com.projects.validator.domainObjects;

import com.projects.validator.domainObjects.domainObjectInterfaces.ValidatorAware;
import com.projects.validator.validation.validationInterfaces.Validator;


public class ExampleObjectParent implements ValidatorAware {
	
	public int numericalFieldParent1 = 6;
	public String stringFieldParent1 = "String_In_ExampleObjectParent";
	//public ExampleObjectChild exampleObjectChild = new ExampleObjectChild();
	private int numericalField2 = 2;

	@Override
	public boolean validate(Validator validator) {
		// TODO Auto-generated method stub
		return validator.validate(this);
	}


	
	

}
