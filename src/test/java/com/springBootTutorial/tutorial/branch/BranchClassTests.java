package com.springBootTutorial.tutorial.branch;

import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BranchClassTests {
	
	 Integer branchId = 10;
	 String branchName = "test branch";
	 String branchCode = "91s0hsys";
	 Integer phoneNumber = 44227373;
	 
	 /* BRANCH ADDRESS*/
	 String streetName = "test street";
	 Integer streetNumber = 0;
	 Integer apartmentOrUnitNumber = 0;
	 Integer zipCode = 10120;
	 String city = "Zacatecas";
	 String state = "Zacatecas";
	 String country = "Mexico";
	 
	@Test
	void CreateBranchClass() {
		BranchAddress testAddress = new BranchAddress(branchId, streetName, streetNumber, apartmentOrUnitNumber, zipCode, city, state, country);
		Branch testBranch = new Branch(branchId, branchName,branchCode, testAddress, phoneNumber);
		Assertions.assertTrue(testBranch instanceof Object && testBranch != null);
	}
	
	@Test
	void CreateBranchAddressTest() throws Exception {
		BranchAddress testAddress = new BranchAddress(branchId, streetName, streetNumber, apartmentOrUnitNumber, zipCode, city, state, country);
		Assertions.assertTrue(testAddress.getAddressInfo() instanceof Map && testAddress != null);

	}
}
