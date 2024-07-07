package com.springBootTutorial.tutorial.person;

import java.util.HashMap;

public class Address {
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
	
	public Address(Integer personId,String streetName, Integer streetNumber, Integer apartmentOrUnitNumber, Integer zipCode, String city, String state, String country) {
		this.personId = personId;
		this.streetName = streetName;
		this.streetNumber = streetNumber;
		this.apartmentOrUnitNumber = apartmentOrUnitNumber;
		this.zipCode = zipCode;
		this.city = city;
		this.state = state;
		this.country = country;
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
