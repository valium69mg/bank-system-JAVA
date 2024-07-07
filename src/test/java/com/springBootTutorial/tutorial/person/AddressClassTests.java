package com.springBootTutorial.tutorial.person;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions;


public class AddressClassTests {
	
	Integer testId = 99999999;
	// ADDRESS ATTS
	String streetName = "La Vista Av";
	Integer streetNumber = 1997;
	Integer apartmentOrUnitNumber = 0;
	Integer zipCode = 10239;
	String city = "Fresnillo";
	String state = "Zacatecas";
	String country = "Mexico";
	
	@Test
	void CreateAddressClassWithOnlyPersonId() {
		Address testAddress = new Address(testId); 
		Assertions.assertTrue(testAddress instanceof Object);
	}
	
	@Test
	void CreateAddressClassWithAllParameters() {
		Address testAddress = new Address(testId,streetName,streetNumber,apartmentOrUnitNumber, zipCode, city, state,country); 
		Assertions.assertTrue(testAddress instanceof Object);
	}
	
}
