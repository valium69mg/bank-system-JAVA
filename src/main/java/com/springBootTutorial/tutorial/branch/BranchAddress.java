package com.springBootTutorial.tutorial.branch;

import com.springBootTutorial.tutorial.person.Address;

public class BranchAddress extends Address {

	public BranchAddress(Integer addressId, String streetName, Integer streetNumber, Integer apartmentOrUnitNumber,
			Integer zipCode, String city, String state, String country) {
		super(addressId, streetName, streetNumber, apartmentOrUnitNumber, zipCode, city, state, country);
		// TODO Auto-generated constructor stub
	}

}
