package com.projects.validator.domainObjects.domainObjectInterfaces;

import com.projects.validator.validation.validationInterfaces.Validator;

public interface ValidatorAware {
	
	public boolean validate(Validator validator);

}
