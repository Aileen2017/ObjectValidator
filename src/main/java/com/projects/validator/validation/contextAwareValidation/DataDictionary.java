package com.projects.validator.validation.contextAwareValidation;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import com.projects.validator.validation.Rule;
import com.projects.validator.validation.RuleFactory;
import com.projects.validator.validation.contextAwareValidation.Exception.ExceptionInvalidData;
import com.projects.validator.validation.rules.ObjectFieldRule;
import com.projects.validator.validation.rules.RuleFactoryImpl;

import java.util.Scanner;

public class DataDictionary {
	
	RuleFactory ruleFactory;
	
	static final String inputFile = "src/main/java/com/projects/validator/mains/data_dictionary_context_aware_rules.txt";
	static HashMap<String, ObjectFieldRule> dataDictionary = new HashMap<String, ObjectFieldRule>();
	static HashMap<String, HashMap<String, RuleData>> ruleDataSets = new HashMap<String, HashMap<String, RuleData>>();
	
	static {
		
		
		try {
			Scanner scanner = new Scanner(new InputStreamReader(new FileInputStream(inputFile)));
			scanner.nextLine();
			String className = "";
			HashMap<String, RuleData> ruleDataSet=null;
			while(scanner.hasNext()) {
				
				String line = scanner.nextLine();
				String[] items = line.split("\\s+");
				if(items.length < 1)
					throw new ExceptionInvalidData("DataInputInvalidException");
				RuleData ruleData = new RuleData(items[0], items[1],items[2], items[3]);
				if(!items[0].equals(className)) {
					className = items[0];
					ruleDataSet = new HashMap<String, RuleData>();				
					ruleDataSets.put(className, ruleDataSet);
				}
				ruleDataSet.put(items[1], ruleData);
				
			}
			
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}catch(ExceptionInvalidData e) {   //static block does not allow throw checked exception
			throw new ExceptionInInitializerError(e.getMessage());
		}
		
		
	}
	
	public DataDictionary(RuleFactory _ruleFactory) {
		
		ruleFactory = _ruleFactory;
		
	}
	
	
	public static ObjectFieldRule getRulesForObject(Object o) {
		String className = o.getClass().getSimpleName(); 
		if(dataDictionary.get(o.getClass().getSimpleName())==null) {
			
			loadRules(o);
			
		}
		return dataDictionary.get(className);
		
		
	}
	
	
	public static void loadRules(Object o) {
		String className = o.getClass().getSimpleName();
		HashMap<String, RuleData> ruleDataSet = ruleDataSets.get(className);
		Comparator<Entry<String, RuleData>> comparator = new Comparator<Entry<String, RuleData>>() {

			@Override
			public int compare(Entry<String, RuleData> o1, Entry<String, RuleData> o2) {
				
				Entry<String, RuleData> entry1 = (Entry<String, RuleData>)o1;
				Entry<String, RuleData> entry2 = (Entry<String, RuleData>)o2;
				
				return Integer.compare(entry1.getKey().length(), entry2.getKey().length());
			}		
			
		};
		List<Entry<String, RuleData>> list = ruleDataSet.entrySet().stream().sorted(comparator).collect(Collectors.toList());
		ListIterator ruleItr = list.listIterator();
		ObjectFieldRule objectFieldRule = new ObjectFieldRule();
		dataDictionary.put(className, objectFieldRule);
		loadRules(ruleItr,1, objectFieldRule);
				
	}
	
	static ObjectFieldRule loadRules(ListIterator ruleItr, int index, ObjectFieldRule objectFieldRule) {
		
		while(ruleItr.hasNext()) {
			Entry<String, RuleData> entry = (Entry<String, RuleData>) ruleItr.next();
			String[] fieldNames = ((String)entry.getKey()).split("\\.");
			if(fieldNames.length== index) {
				Rule rule = ruleFactory.createRule(fieldNames[index-1],entry.getValue().ruleName, entry.getValue().value);
				objectFieldRule.rulesList.add(rule);
			}
			else {	
				ruleItr.previous();
				ObjectFieldRule objectFieldRuleChild = new ObjectFieldRule(fieldNames[index-1]);
				objectFieldRule.rulesList.add(objectFieldRuleChild);
				loadRules(ruleItr, index+1, objectFieldRuleChild);
				
			}		
			
		}
		
		return objectFieldRule;
		
		
	
	

}
