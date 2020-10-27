package com.projects.validator.validation.flatValidation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.projects.validator.domainObjects.ExampleObjectChild;
import com.projects.validator.domainObjects.ExampleObjectParent;
import com.projects.validator.domainObjects.ExampleObjectTopContainer;
import com.projects.validator.validation.Rule;
import com.projects.validator.validation.Validator;

public class ValidatorImpl implements Validator{
	
	HashMap<String, Rule> dataDictionary ;
	static ExampleObjectTopContainer exampleObjectTopContainer; 
	
	static List<String> fieldLabels = new ArrayList<String>(Arrays.asList(
			"ExampleObjectParent.numericalField1",
			"ExampleObjectChild.stringField1"
			));
	static HashMap<String, List<String>> map = new HashMap<String, List<String>>();
	static HashMap<String, List<Object>> valuesMap = new HashMap<String, List<Object>>();
	static List<String> fieldLabelsForParentObject = Arrays.asList("ExampleObjectTopContainer.numericalField1", "ExampleObjectTopContainer.exampleObjectSecondContainer");
	static List<String> fieldLabelsForChildObject = Arrays.asList("ExampleObjectSecondContainer.stringField1");
	static List<Object> fieldValuesForParentObject = new ArrayList<Object>();
	static List<Object> fieldValuesForChildObject = Arrays.asList("hello");
	static {
		map.put("exampleObjectTopContainer", fieldLabelsForParentObject);
		map.put("exampleObjectSecondContainer", fieldLabelsForChildObject);
		valuesMap.put("exampleObjectTopContainer",fieldValuesForParentObject);
		valuesMap.put("exampleObjectSecondContainer",fieldValuesForChildObject);
	
	}
	
	
	public ValidatorImpl(){
		
	}
	
	public ValidatorImpl(HashMap<String, Rule> _dataDictionary ){
		dataDictionary = _dataDictionary;
	}

	public ValidatorImpl(HashMap<String, Rule>  _dataDictionary, ExampleObjectTopContainer _exampleObjectTopContainer ){
		dataDictionary = _dataDictionary;
		exampleObjectTopContainer = _exampleObjectTopContainer;
		fieldValuesForParentObject = Arrays.asList(6,exampleObjectTopContainer.exampleObjectSecondContainerField);
		valuesMap.put("exampleObjectTopContainer",fieldValuesForParentObject);
		
	}
	 

	
	public boolean validate(Object o) {
		/*if(dataDictionary.get(o.getClass())==null) {
			//add to dataDictionary
		}
		
		//List<String> fieldValues = Arrays.asList("3", "");
		//List<Object> fieldValues = Arrays.asList("3", ExampleObjectParent(o).exampleObjectChild);
		
		
		Class clazz = o.getClass();
		Field[] fields = clazz.getFields();
		Field[] fieldsDeclared = clazz.getDeclaredFields();
		
		ExampleObjectChild childInstance = new ExampleObjectChild();
		Class clazz2 = childInstance.getClass();
		Field[] fields2 = clazz2.getFields();
		Field[] fieldsDeclared2 = clazz2.getDeclaredFields();
		
		
		
		List<String> fieldLabels = null; 
		List<Object> fieldValues = null;
		if(o.getClass().toString().equalsIgnoreCase("class com.projects.validator.validator.ExampleObjectParent")) {
			fieldLabels = map.get("exampleObjectParent");
			fieldValues = valuesMap.get("exampleObjectParent");
		}
		else if(o.getClass().toString().equalsIgnoreCase("class com.projects.validator.validator.ExampleObjectChild")) {
			fieldLabels = map.get("exampleObjectChild");
			fieldValues = valuesMap.get("exampleObjectChild");
		}
		
		for(int i=0; i<fieldLabels.size();i++) {
			//String classType = "ExampleObjectParent";
			//String field1 = "numericalField1";
			//int field1Value = ((ExampleObjectParent)o).numericalField1;
				
		//	if((fieldValues.get(i)).getClass().isAssignableFrom(Object.class)) {
			if((fieldValues.get(i)).getClass().toString().equalsIgnoreCase("class com.projects.validator.validator.ExampleObjectChild")) {
						
				if(!validate(fieldValues.get(i)))
					return false;
			}
			else {
			//int fieldValue = Integer.parseInt((String)fieldValues.get(i));
			Rule rule = dataDictionary.get(fieldLabels.get(i));
			
			if(!rule.validate(fieldValues.get(i)))
				return false;
			}
			
		}*/
		return true;
	}

}
