package com.projects.validator.validation.contextAwareValidation;

import com.projects.validator.validation.Rule;
import com.projects.validator.validation.Validator;
import com.projects.validator.validation.rules.ObjectFieldRule;

public class ValidatorImplContextAware implements Validator {

	DataDictionary dataDictionary;
	
	public ValidatorImplContextAware(DataDictionary _dataDictionary) {
		dataDictionary = _dataDictionary;
	}
	
	@Override
	public boolean validate(Object o) {
		
		ObjectFieldRule rules = DataDictionary.getRulesForObject(o);
		for(Rule rule : rules.rulesList) {
			if(!rule.validate(o))
				return false;
			
			
		}
		return true;
	}


}
