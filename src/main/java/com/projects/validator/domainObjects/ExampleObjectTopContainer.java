package com.projects.validator.domainObjects;

import com.projects.validator.validation.Validator;
import com.projects.validator.validation.ValidatorAware;

public class ExampleObjectTopContainer implements ValidatorAware {
	
	public int numericalField1 = 6;
	public ExampleObjectSecondContainer exampleObjectSecondContainerField 
			= new ExampleObjectSecondContainer();
	@Override
	public boolean validate(Validator validator) {
		// TODO Auto-generated method stub
		return validator.validate(this);
	}

}
