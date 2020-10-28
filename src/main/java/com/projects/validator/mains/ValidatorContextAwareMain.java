package com.projects.validator.mains;

import com.projects.validator.domainObjects.ExampleObjectTopContainer;
import com.projects.validator.validation.contextAwareValidation.DataDictionary;
import com.projects.validator.validation.contextAwareValidation.ValidatorImplContextAware;
import com.projects.validator.validation.rules.ObjectFieldRule;
import com.projects.validator.validation.rules.RuleFactoryImpl;

public class ValidatorContextAwareMain {
	//three ways to validate object
	public static void main(String[] args) {
		
		ExampleObjectTopContainer exampleObjectTopContainer = new ExampleObjectTopContainer();
		
		//way1: use domain object to call validator
		DataDictionary dataDictionary = new DataDictionary(new RuleFactoryImpl());
		ValidatorImplContextAware validatorImpl = new ValidatorImplContextAware(dataDictionary);
		System.out.println(exampleObjectTopContainer.validate(validatorImpl));
		
		//way2: use validator to call domain object
		System.out.println(validatorImpl.validate(exampleObjectTopContainer));
		
		//way3: use rule to call domain object
		ObjectFieldRule rules = DataDictionary.getRulesForObject(exampleObjectTopContainer);
		System.out.println(rules.validate(exampleObjectTopContainer));
		
		
	}

}
