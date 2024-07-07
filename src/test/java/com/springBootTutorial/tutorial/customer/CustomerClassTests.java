package com.springBootTutorial.tutorial.customer;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.springBootTutorial.tutorial.person.Person;

public class CustomerClassTests {
	
	// CUSTOMER ATTRIBUTES
	private Integer customerId = 999;
	public Integer personId = 99999999;
	public String testCustomerType = "personal account";

	@Test
	void CreateCustomerClass() throws Exception {
		// PERSON
		Person testPerson = new Person(personId);
		testPerson.autoFillForTest();
		Customer testCustomer = new Customer(customerId,testPerson,testCustomerType);
		Assertions.assertTrue(testCustomer instanceof Object && testCustomer != null);
	}
	

	@Test
	void getCustomerInfo() throws Exception {
		Person testPerson = new Person(personId);
		testPerson.autoFillForTest();
		Customer testCustomer = new Customer(customerId,testPerson,testCustomerType);
		Assertions.assertTrue(testCustomer.getCustomerInfo() instanceof Map && testCustomer.getCustomerInfo() != null);
	}
	
	
	
}
