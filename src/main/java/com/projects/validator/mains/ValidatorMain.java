package com.projects.validator.mains;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

import com.projects.validator.domainObjects.ExampleObjectParent;
import com.projects.validator.domainObjects.ExampleObjectTopContainer;
import com.projects.validator.validation.Rule;
import com.projects.validator.validation.flatValidation.ValidatorImpl;
import com.projects.validator.validation.flatValidation.ValidatorImpl2;
import com.projects.validator.validation.rules.RuleFactoryImpl;

public class ValidatorMain {
	
	static final String inputFile = "src/main/java/com/projects/validator/mains/data_dictionary_flat_rules.txt";

	
	public static void main(String[] args) throws FileNotFoundException {	
		
		HashMap<String, Rule> dataDictionary = new HashMap<String, Rule>();
		
		Scanner scanner = new Scanner(new InputStreamReader(new FileInputStream(inputFile)));
		scanner.nextLine();
		while(scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] items = line.split("\\s+");
			Rule rule = generateRule(items);
			dataDictionary.put(items[0]+"."+items[1], rule);
		}
		
		ValidatorImpl validatorImpl = new ValidatorImpl(dataDictionary, new ExampleObjectTopContainer());
		
		ExampleObjectParent eop = new ExampleObjectParent();
		ValidatorImpl2 validator2 = new ValidatorImpl2(dataDictionary);
		System.out.println(eop.validate(validator2));			
		
	}
	
	static Rule generateRule(String[] items) {
		
		return RuleFactoryImpl.createRule(items[2],items[3]);
		
	}
	

}
