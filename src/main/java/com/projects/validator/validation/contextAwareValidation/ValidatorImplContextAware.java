package com.projects.validator.validation.contextAwareValidation;

import com.projects.validator.validation.validationInterfaces.Validator;

public class ValidatorImplContextAware implements Validator {

	static DataDictionary dataDictionary;
	
	@Override
	public boolean validate(Object o) {
		
		ObjectFieldRule rules = DataDictionary.getRulesForObject(o);
		return rules.validate(o);
	}
	
	
	
	

}
