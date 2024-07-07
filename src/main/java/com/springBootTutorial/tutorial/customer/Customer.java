package com.springBootTutorial.tutorial.customer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;

import com.springBootTutorial.tutorial.person.Person;

public class Customer {
	private Integer customerId;
	private Person person;
	private String customerType;
	private String[] customerTypes = {"personal account","business account"};
	
	/*
	 * CUSTOMER TYPES
	 * personal account
	 * business account
	 * */
	
	public Customer(Integer customerId,Person person, String customerType) throws Exception {
		if (!Arrays.asList(customerTypes).contains(customerType)) { // If String customerType is not in our customer types array throw an exception
			throw new Exception("An exception occurred: Customer Type in Customer Class is incorect, must be a valid customer type");
		}
		this.customerId = customerId;
		this.person = person;
		this.customerType = customerType;
	}
	
	public HashMap<String,String> getCustomerInfo() throws Exception {
		HashMap<String,String> customerInfo = new HashMap<>(); 
		HashMap<String,String> personInfo = person.getPersonInfo();
		// PERSON INFO
		for (Entry<String, String> entry : personInfo.entrySet()) {
		    String attributeKey = entry.getKey();
		    String attributeValue = entry.getValue();
		    customerInfo.put(attributeKey,attributeValue);
		}
		// CUSTOMER INFO
		customerInfo.put("customerId", customerId.toString());
		customerInfo.put("customerType", customerType);
		return customerInfo;
	}
	
	// GETTERS AND SETTERS
	
	public Person getPerson() {
		return person;
	}

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
		this.customerType = customerType;
	}

	public String[] getCustomerTypes() {
		return customerTypes;
	}
	
	public boolean isCustomerType(String customerType) {
		if (!Arrays.asList(customerTypes).contains(customerType)) { // If String customerType is not in our customer types array throw an exception
			return false;
		}
		return true;
	}
	
	
}
