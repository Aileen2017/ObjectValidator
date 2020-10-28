package com.projects.validator.validation.rules;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import com.projects.validator.validation.Rule;

public class ObjectFieldRule implements Rule{
	
	public String fieldName;
	public List<Rule> rulesList = new ArrayList<Rule>();
	
	public ObjectFieldRule() {
		
	}
	
	public ObjectFieldRule(String _fieldName) {
		fieldName = _fieldName;
	}
	
	
	
	public ObjectFieldRule(String _fieldName, List<Rule> _rulesList) {
		
		rulesList = _rulesList;
	}

	@Override
	public boolean validate(Object actualValue) {
		if(fieldName!=null) {
			Object fieldValue = null;
			
			try {
				Field objectField = actualValue.getClass().getField(fieldName);
				fieldValue = objectField.get(actualValue);
				
				
			} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
				return false;
			} catch(Exception e) {
				return false;
			}
			
			
			for(Rule rule: rulesList) {	
				if(!rule.validate(fieldValue))
					return false;
			}
		
			
		}
		
		
		/*	
			for(Rule rule: rulesList) {	
				//isInstance check left object is child of right side class, 
				//while isAssignableFrom check left is parent of right side class
				//if(rule.getClass().getSuperclass().isAssignableFrom(PrimitiveFieldRule.class)) 
				if(rule instanceof PrimitiveFieldRule ) {
					fieldValue = actualValue;
						
				}
				else {
					try {
						Field objectField = actualValue.getClass().getField(rule.fieldName);
						fieldValue = objectField.get(actualValue);
						
						
					} catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e) {
						e.printStackTrace();
					}
					
					
				}
				if(!rule.validate(fieldValue))
					return false;
						
			}*/
		
		return true;
	}

}
