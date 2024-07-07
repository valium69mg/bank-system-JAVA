package com.springBootTutorial.tutorial.transaction;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.springBootTutorial.tutorial.customer.Customer;
import com.springBootTutorial.tutorial.person.Person;

public class TransactionClassTest {
	// CUSTOMER ATTRIBUTES
	Integer senderCustomerId = 999;
	Integer senderPersonId = 99999999;
	Integer receiverCustomerId = 999;
	Integer receiverPersonId = 99999999;
	String testCustomerType = "personal account";
	
	// TRANSACTION ATTS
	Integer transactionId = 1002393902;
	Integer senderAccountId = 349309340;
	Integer receiverAccountId = 8392893;
	String transactionType = "fund transfer";
	BigInteger transactionAmount = new BigInteger("1000");
	 String transactionDate = "2020-10-20";
	
	@Test
	void CreateTransactionClass() throws Exception {
		// SENDER
		Person testSenderPerson = new Person(senderCustomerId);
		testSenderPerson.autoFillForTest();
		Customer testSenderCustomer = new Customer(senderCustomerId,testSenderPerson,testCustomerType);
		// RECEIVER
		Person testReceiverPerson = new Person(senderCustomerId);
		testReceiverPerson.autoFillForTest();
		Customer testReceiverCustomer = new Customer(senderCustomerId,testSenderPerson,testCustomerType);
		
		Transaction testTransaction = new Transaction(transactionId,testSenderCustomer,testReceiverCustomer,transactionType,transactionAmount,transactionDate);
		Assertions.assertTrue(testTransaction instanceof Object && testTransaction != null);
	}
	
	@Test
	void GetTransactionAmount() throws Exception {
		// SENDER
		Person testSenderPerson = new Person(senderCustomerId);
		testSenderPerson.autoFillForTest();
		Customer testSenderCustomer = new Customer(senderCustomerId,testSenderPerson,testCustomerType);
		// RECEIVER
		Person testReceiverPerson = new Person(senderCustomerId);
		testReceiverPerson.autoFillForTest();
		Customer testReceiverCustomer = new Customer(senderCustomerId,testSenderPerson,testCustomerType);
		Transaction testTransaction = new Transaction(transactionId,testSenderCustomer,testReceiverCustomer,transactionType,transactionAmount,transactionDate);
		BigInteger testTransactionAmount = new BigInteger("1000");
		Assertions.assertTrue(testTransactionAmount.equals(testTransaction.getTransactionAmount()));
	}
}
