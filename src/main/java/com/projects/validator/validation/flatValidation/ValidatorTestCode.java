package com.projects.validator.validation.flatValidation;

import java.lang.reflect.Field;

import com.projects.validator.domainObjects.ExampleObjectChild;
import com.projects.validator.domainObjects.ExampleObjectParent;

//getFields get all public fields in class hierarchy
//getDeclaredFields get all fields (prive, public, default, proteced) for a current class
public class ValidatorTestCode {
	
	public static void main(String[] args) throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		
		ExampleObjectParent objectParent = new ExampleObjectParent();
		ExampleObjectChild objectChild = new ExampleObjectChild();
	
		Class objectParentClazz = objectParent.getClass();
		Class objectChildClazz = objectChild.getClass();
		
		Field[] objectParentFields = objectParentClazz.getFields();
		Field[] objectParentDeclaredFields = objectParentClazz.getDeclaredFields();
		Field[] objectChildFields = objectChildClazz.getFields();
		Field[] objectChildDeclaredFields = objectChildClazz.getDeclaredFields();
		
		/*	ExampleObjectParent objectChildParent = new ExampleObjectChild();
			Class objectChildParentClazz = objectChildParent.getClass(); //return ExampleObjectChild.class
			Field[] objectChildParentFields = objectChildParentClazz.getFields();
			Field[] objectChildParentDeclaredFields = objectChildParentClazz.getDeclaredFields();*/
		
		//numericalField1
		Field field = objectParentClazz.getField("numericalField1");
		Object value = (Object)field.get(objectParent);
		
		Object value2 = (Object)objectParentFields[0].get(objectParent);
		Class fieldType = objectParentFields[0].getType();
		
		Object value3 = (Object)objectParentFields[1].get(objectParent);
		String fieldTypeSimpleName = objectParentFields[1].getType().getSimpleName();
		System.out.println("");
		
		
	}
	
	

}

