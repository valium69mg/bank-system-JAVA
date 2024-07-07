package com.springBootTutorial.tutorial.account;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.springBootTutorial.tutorial.customer.Customer;
import com.springBootTutorial.tutorial.person.Person;

public class AccountClassTests {
	// ACCOUNT ATTS
	Integer personId = 9999999;
	Integer accountId = 00000;
	Integer accountNumber = 23829;
	String dateAccountOpened = "2000-10-10";
	String accountType = "personal account";
	// CUSTOMER ATTS
    Integer customerId = 999;
	String testCustomerType = "personal account";
	@Test
	void CreateAccountClass() throws Exception {
		Person testPerson = new Person(personId);
		testPerson.autoFillForTest();
		Customer testCustomer = new Customer(customerId,testPerson,testCustomerType);
		Account newAccount = new Account(accountId,testCustomer,accountNumber,accountType,dateAccountOpened);
		Assertions.assertTrue(newAccount instanceof Object && newAccount != null);
	}
	
	@Test
	void SetBalanceOfAccount() throws Exception {
		Person testPerson = new Person(personId);
		testPerson.autoFillForTest();
		Customer testCustomer = new Customer(customerId,testPerson,testCustomerType);
		Account newAccount = new Account(accountId,testCustomer,accountNumber,accountType,dateAccountOpened);
		BigInteger newBalance = new BigInteger("10000");
		newAccount.setCurrentBalance(newBalance);
		Assertions.assertTrue(newAccount.getCurrentBalance().equals(newBalance));
	}
	
	@Test 
	void GetBalanceOfAccount() throws Exception {
		Person testPerson = new Person(personId);
		testPerson.autoFillForTest();
		Customer testCustomer = new Customer(customerId,testPerson,testCustomerType);
		Account newAccount = new Account(accountId,testCustomer,accountNumber,accountType,dateAccountOpened);
		BigInteger initialBalance = new BigInteger("0");
		Assertions.assertTrue(newAccount.getCurrentBalance().equals(initialBalance));
	}
	
}
