package com.projects.validator.validation.rules;

import java.lang.reflect.Field;

import com.projects.validator.validation.Rule;

public class PrimitiveFieldRule implements Rule{
	
	public String fieldName;
	public Object targetedValue;
	
	public PrimitiveFieldRule(){	
		
	}
	
	PrimitiveFieldRule(Object _targetedValue){
		
		targetedValue = _targetedValue;
	}
	
	PrimitiveFieldRule(String _fieldName, Object _targetedValue){
		fieldName = _fieldName;
		targetedValue = _targetedValue;
		
	}
	


	@Override
	public boolean validate(Object containerValue) {
		// TODO Auto-generated method stub
		Object fieldValue = null;
		if(fieldName != null) {
			fieldValue = getFieldValue(containerValue);
		}
		return checkValue(fieldValue);
		
	}
	
	protected boolean checkValue(Object fieldValue) {
		return false;
	}
	
	 Object getFieldValue(Object containerValue) {
		try {
			 Class clazz = containerValue.getClass();
			 Field field = clazz.getField(fieldName);
			 Object fieldValue = field.get(containerValue);
			 return fieldValue;
		}catch(NoSuchFieldException e) {
			
		}catch(SecurityException e) {
			
		}catch(IllegalArgumentException e) {
		
		}catch(IllegalAccessException e) {
			
		}
		return null;
	 }

}
