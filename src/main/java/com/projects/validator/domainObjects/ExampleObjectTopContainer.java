package com.projects.validator.domainObjects;

import com.projects.validator.domainObjects.domainObjectInterfaces.ValidatorAware;
import com.projects.validator.validation.validationInterfaces.Validator;

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
