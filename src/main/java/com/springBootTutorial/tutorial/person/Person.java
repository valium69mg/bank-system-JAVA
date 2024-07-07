package com.springBootTutorial.tutorial.person;

import java.util.HashMap;
import java.util.Map.Entry;

class Address {
	
	private Integer personId;
	private String streetName;
	private Integer streetNumber;
	private Integer apartmentOrUnitNumber;
	private Integer zipCode;
	private String city;
	private String state;
	private String country;
	
	public Address(Integer personId) {
		this.personId = personId;
	}
	
	public HashMap<String,String> getAddressInfo() throws Exception { 
		HashMap<String, String> addressInfo = new HashMap<String, String>();
		//CHECK FOR UNINITIALIZED ATTRIBUTES
		if (streetName == null) {
			throw new Exception("An exception occurred: Street Name in Address Class is null, must be initialized first");

		}
		addressInfo.put("streetName", streetName);
		if (streetNumber == null) {
			throw new Exception("An exception occurred: Street Number in Address Class is null, must be initialized first");
		}
		addressInfo.put("streetNumber", streetNumber.toString());
		if (zipCode == null) {
			throw new Exception("An exception occurred: Zip Code in Address Class is null, must be initialized first");
		}
		addressInfo.put("zipCode", zipCode.toString());
		if (city == null) {
			throw new Exception("An exception occurred: City in Address Class is null, must be initialized first");
		}
		addressInfo.put("city", city);
		if (state == null) {
			throw new Exception("An exception occurred: State in Address Class is null, must be initialized first");

		}
		addressInfo.put("state", state);
		if (country == null) {
			throw new Exception("An exception occurred: Country in Address Class is null, must be initialized first");
		}
		addressInfo.put("country", country);
		
 		if (apartmentOrUnitNumber == null) {
 			return addressInfo;
 		}
 		
 		addressInfo.put("apartmentOrUnitNumber", apartmentOrUnitNumber.toString());
 		return addressInfo;
		
	}
	
	// GETTERS AND SETTERS
	
	// PERSON ID
	public Integer getPersonId() {
		return personId;
	}
	
	// STREET NAME
	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}
	
	public String getStreetName() {
		return streetName;
	}
	
	// STREET NUMBER
	public void setStreetNumber(Integer streetNumber) {
		this.streetNumber = streetNumber;
	}
	
	public Integer getStreetNumber() {
		return streetNumber;
	}
	
	// APARTMENT OR UNIT NUMBER
	public void setApartmentOrUnitNumber(Integer apartmentOrUnitNumber) {
		this.apartmentOrUnitNumber = apartmentOrUnitNumber; 
	}
	
	public Integer getApartmentOrUnitNumber() {
		return apartmentOrUnitNumber;
	}
	
	// ZIP CODE
	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}
	
	public Integer getZipCode() {
		return zipCode;
	}
	
	// CITY
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getCity() {
		return city;
	}
	
	// STATE
	public void setState(String state) {
		this.state = state;
	}
	
	public String getState() {
		return state;
	}
	
	// COUNTRY 
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void autoFillForTest() {
		// ADDRESS ATTRIBUTES
		this.streetName = "La Vista Av";
		this.streetNumber = 1997;
		this.apartmentOrUnitNumber = 0;
		this.zipCode = 10239;
		this.city = "Fresnillo";
		this.state = "Zacatecas";
		this.country = "Mexico";
	}
}

/**
 * 
 */
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
	
	// TAX ID

	public String getTaxId() {
		return taxId;
	}


	public void setTaxId(String taxId) {
		this.taxId = taxId;
	}
		
	public void autoFillForTest() {
		this.personId = 99999999;
		this.firstName = "Carlos";
		this.lastName = "Roman";
		this.dateOfBirth = "1998/01/15";
		this.email = "carlostranquilino.cr@gmail.com";
		this.taxId = "CARD3031KD319";
		this.getAddress().autoFillForTest();
	}
	
}
