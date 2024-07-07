package com.springBootTutorial.tutorial.person;

import org.junit.jupiter.api.Test;

import java.util.Map;

import org.junit.jupiter.api.Assertions;

public class PersonClassTests {
	
	// PERSONS ATTRIBUTES 
	public Integer testId = 99999999;
	Integer personId = 99999999;
	String firstName = "Carlos";
	String lastName = "Roman";
	String dateOfBirth = "1998/01/15";
	String email = "carlostranquilino.cr@gmail.com";
	String taxId = "CARD3031KD319";
	
	@Test
	void CreatePersonClassWithOnlyPersonId() {
		Person testPerson = new Person(testId);
		Assertions.assertTrue(testPerson instanceof Object && testPerson.getAddress() != null);
	}
	
	@Test 
	void CreatePersonClassWithAllParameters() {
		Person testPerson = new Person(personId,firstName,lastName,dateOfBirth,email, new Address(personId),taxId);
		Assertions.assertTrue(testPerson instanceof Object && testPerson.getAddress() != null);
	}
	
	@Test 
	void GetPersonClassPersonId() {
		Person testPerson = new Person(999999999);
		Assertions.assertTrue(testPerson.getPersonId() != null);
	}
	
	@Test
	void SetPersonClassPersonId() {
		Person testPerson = new Person(999999999);
		Integer newTestId = 0;
		testPerson.setPersonId(newTestId);
		// CHECK IF ID CHANGED
		Assertions.assertTrue(testPerson.getPersonId() != testId);
	}
	
	@Test void GetPersonClassInfoWithApartmentOrUnitNumber() throws Exception {
		Person testPerson = new Person(999999999);
		testPerson.autoFillForTest();
		Assertions.assertTrue(testPerson.getPersonInfo() instanceof Map && !testPerson.getPersonInfo().isEmpty());
	}
	
	@Test void GetPersonClassInfoWithoutApartmentOrUnitNumber() throws Exception {
		Person testPerson = new Person(999999999);
		testPerson.autoFillForTest();
		testPerson.getAddress().setApartmentOrUnitNumber(null);
		Assertions.assertTrue(testPerson.getPersonInfo() instanceof Map && !testPerson.getPersonInfo().isEmpty());
	}
	
		
}
