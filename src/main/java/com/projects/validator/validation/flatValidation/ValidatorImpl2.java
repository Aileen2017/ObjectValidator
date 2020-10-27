package com.projects.validator.validation.flatValidation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import com.projects.validator.validation.Rule;

public class ValidatorImpl2 extends ValidatorImpl{
	

	HashMap<String, Rule> dataDictionary ;
		
	public ValidatorImpl2(HashMap<String, Rule> _dataDictionary ){
		
		dataDictionary = _dataDictionary;
	}


	 

	
	public boolean validate(Object o) {
		if(dataDictionary.get(o.getClass())==null) {
			//add to dataDictionary
		}
		
		Class clazz = o.getClass();
		Field[] fieldsDeclared = clazz.getDeclaredFields();
		try {
			for(int i=0; i<fieldsDeclared.length;i++) {
				Class typeClazz = fieldsDeclared[i].getType();
				if(fieldsDeclared[i].getType().isPrimitive() || typeClazz.isAssignableFrom(String.class)) {
					String key = clazz.getSimpleName()+"."+fieldsDeclared[i].getName();
					Rule rule = dataDictionary.get(key);
					if(rule != null) {
						//can only do single field validation, not relational fields validation(more than two fields in the same object)
						//because only single field value passed in 
						if(!rule.validate(fieldsDeclared[i].get(o))) 		
							return false;
					}
				}
				else {
					
					Object fieldValue = fieldsDeclared[i].get(o);
					if(!validate(fieldValue))
						return false;
								
				}		
				
			}
		}catch(IllegalArgumentException e) {

		}catch(IllegalAccessException e) {
			
		}
		
		return true;
	}

}
