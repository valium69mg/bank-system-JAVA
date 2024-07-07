package com.springBootTutorial.tutorial.person;

import java.util.HashMap;
import java.util.Map.Entry;


public class Person {
	
	private Integer personId;
	private String firstName;
	private String lastName;
	private String dateOfBirth;
	private String email;
	private Address address;
	private String taxId;
	
	public Person(Integer personId) {
		this.personId = personId;
		this.address = new Address(this.personId);
	}
	
	public Person(Integer personId,String firstName, String lastName, String dateOfBirth, String email, Address address,String taxId) throws Exception {
		this.personId = personId;
		this.firstName = firstName;
		this.dateOfBirth = dateOfBirth;
		if (!validateDateOfBirth(dateOfBirth)) {
			throw new Exception("An exception occurred: Date Of Birth in Person Class is incorrect, must be a valid format (YYYY-MM-DD)");
		}
		this.email = email;
		this.address = address;
		this.taxId = taxId;
	}
	
	public boolean validateDateOfBirth(String dateOfBirth) {
		for (int i = 0; i < dateOfBirth.length(); i++) {
		    char c = dateOfBirth.charAt(i); 
		    Integer firsDashPositionIndex = 4;
		    Integer secondDashPositionIndex = 7;
		    Integer numberZeroOnAscii = 48;
		    Integer numberNineOnAscii = 57;
		    if (i == firsDashPositionIndex | i ==  secondDashPositionIndex) {
		    	if (c != '-') return false;
		    } else {
		    	if (!(c >= numberZeroOnAscii && c <= numberNineOnAscii)) return false; // IF IT IS NOT IN RANGE OF ASCII 0-9 CAN NOT BE A VALID DATE
		    }
		}
		return true;
	}
	
	
	// GET HASHMAP WITH PERSONS INFO
	public HashMap<String,String> getPersonInfo() throws Exception {
		HashMap<String,String> personInfo = new HashMap<>();
		HashMap<String,String> addressInfo = address.getAddressInfo();
		//CHECK FOR UNINITIALIZED ATTRIBUTES
		if (firstName == null) {
			throw new Exception("An exception occurred: First Name in Person Class is null, must be initialized first");
		}
		personInfo.put("firstName", firstName);
		if (lastName == null) {
			throw new Exception("An exception occurred: Last Name in Person Class is null, must be initialized first");
		}
		personInfo.put("lastName", lastName);
		if (dateOfBirth == null) {
			throw new Exception("An exception occurred: Date Of Birth in Person Class is null, must be initialized first");
		}
		personInfo.put("dateOfBirth", dateOfBirth.toString());
		if (email == null) {
			throw new Exception("An exception occurred: Email in Person Class is null, must be initialized first");
		}
		personInfo.put("email", email);
		if (taxId == null) {
			throw new Exception("An exception occurred: Tax Identifier in Person Class is null, must be initialized first");
		}
		personInfo.put("taxId", lastName);
		
		// COLLECT ADDRESS INFO DATA
		for (Entry<String, String> entry : addressInfo.entrySet()) {
		    String attributeKey = entry.getKey();
		    String attributeValue = entry.getValue();
		    personInfo.put(attributeKey,attributeValue);
		}
		
		return personInfo;
	}

	// GETTERS AND SETTERS
	
	// PERSON ID
	public Integer getPersonId() {
		return personId;
	}


	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	// NAMES

	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	// DATE OF BIRTH

	public String getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	// EMAIL

	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}

	// ADDRESS

	public Address getAddress() {
		return address;
	}
	
	public void setAddress(Address newAddress) {
		this.address = newAddress;
	}
	
	// TAX ID

	public String getTaxId() {
		return taxId;
	}


	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
		
	public void autoFillForTest() {
		this.firstName = "Carlos";
		this.lastName = "Roman";
		this.dateOfBirth = "1998-01-15";
		this.email = "carlostranquilino.cr@gmail.com";
		this.taxId = "CARD3031KD319";
		this.getAddress().autoFillForTest();
	}
	
}
