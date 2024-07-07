package com.springBootTutorial.tutorial.transaction;

import java.math.BigInteger;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import com.springBootTutorial.tutorial.account.Account;
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
	Integer senderAccountNumber = 349309340;
	Integer receiverAccountNumber = 8392893;
	String accountType = "personal account";
	String transactionType = "fund transfer";
	String dateAccountOpened = "2000-10-10";
	BigInteger transactionAmount = new BigInteger("1000");
	String transactionDate = "2020-10-20";
	 
	@Test
	void CreateTransactionClass() throws Exception {
		BigInteger moneyToDeposit = new BigInteger("1000");
		// SENDER
		Person testSenderPerson = new Person(senderCustomerId);
		testSenderPerson.autoFillForTest();
		Customer testSenderCustomer = new Customer(senderCustomerId,testSenderPerson,testCustomerType);
		Account testSenderAccount = new Account(senderAccountId,testSenderCustomer,senderAccountNumber,accountType,dateAccountOpened);
		testSenderAccount.setCurrentBalance(moneyToDeposit);
		// RECEIVER
		Person testReceiverPerson = new Person(receiverCustomerId);
		testReceiverPerson.autoFillForTest();
		Customer testReceiverCustomer = new Customer(receiverCustomerId,testReceiverPerson,testCustomerType);
		Account testReceiverAccount = new Account(receiverAccountId,testReceiverCustomer,receiverAccountNumber,accountType,dateAccountOpened);
		
		
		Transaction testTransaction = new Transaction(transactionId,testSenderAccount,testReceiverAccount,transactionType,transactionAmount,transactionDate);
		Assertions.assertTrue(testTransaction instanceof Object && testTransaction != null);
	}
	
	@Test
	void GetTransactionAmount() throws Exception {
		BigInteger moneyToDeposit = new BigInteger("1000");
		// SENDER
		Person testSenderPerson = new Person(senderCustomerId);
		testSenderPerson.autoFillForTest();
		Customer testSenderCustomer = new Customer(senderCustomerId,testSenderPerson,testCustomerType);
		Account testSenderAccount = new Account(senderAccountId,testSenderCustomer,senderAccountNumber,accountType,dateAccountOpened);
		testSenderAccount.setCurrentBalance(moneyToDeposit);
		// RECEIVER
		Person testReceiverPerson = new Person(receiverCustomerId);
		testReceiverPerson.autoFillForTest();
		Customer testReceiverCustomer = new Customer(receiverCustomerId,testReceiverPerson,testCustomerType);
		Account testReceiverAccount = new Account(receiverAccountId,testReceiverCustomer,receiverAccountNumber,accountType,dateAccountOpened);
		Transaction testTransaction = new Transaction(transactionId,testSenderAccount,testReceiverAccount,transactionType,transactionAmount,transactionDate);
		Assertions.assertTrue(moneyToDeposit.equals(testTransaction.getTransactionAmount()));
	}
	
	@Test
	void TransactionRejected() throws Exception {
		BigInteger moneyToDeposit = new BigInteger("500");
		// SENDER
		Person testSenderPerson = new Person(senderCustomerId);
		testSenderPerson.autoFillForTest();
		Customer testSenderCustomer = new Customer(senderCustomerId,testSenderPerson,testCustomerType);
		Account testSenderAccount = new Account(senderAccountId,testSenderCustomer,senderAccountNumber,accountType,dateAccountOpened);
		testSenderAccount.setCurrentBalance(moneyToDeposit);
		// RECEIVER
		Person testReceiverPerson = new Person(receiverCustomerId);
		testReceiverPerson.autoFillForTest();
		Customer testReceiverCustomer = new Customer(receiverCustomerId,testReceiverPerson,testCustomerType);
		Account testReceiverAccount = new Account(receiverAccountId,testReceiverCustomer,receiverAccountNumber,accountType,dateAccountOpened);
		BigInteger rejectAmount = new BigInteger("1000");
		Transaction testTransaction = new Transaction(transactionId,testSenderAccount,testReceiverAccount,transactionType,rejectAmount,transactionDate);
		Assertions.assertTrue(testTransaction.getTransactionStatus() == "rejected");
		
	}
	
	@Test 
	void TransactionPending() throws Exception {	
		BigInteger moneyToDeposit = new BigInteger("500");
		// SENDER
		Person testSenderPerson = new Person(senderCustomerId);
		testSenderPerson.autoFillForTest();
		Customer testSenderCustomer = new Customer(senderCustomerId,testSenderPerson,testCustomerType);
		Account testSenderAccount = new Account(senderAccountId,testSenderCustomer,senderAccountNumber,accountType,dateAccountOpened);
		testSenderAccount.setCurrentBalance(moneyToDeposit);
		// RECEIVER
		Person testReceiverPerson = new Person(receiverCustomerId);
		testReceiverPerson.autoFillForTest();
		Customer testReceiverCustomer = new Customer(receiverCustomerId,testReceiverPerson,testCustomerType);
		Account testReceiverAccount = new Account(receiverAccountId,testReceiverCustomer,receiverAccountNumber,accountType,dateAccountOpened);
		BigInteger acceptAmount = new BigInteger("500");
		Transaction testTransaction = new Transaction(transactionId,testSenderAccount,testReceiverAccount,transactionType,acceptAmount,transactionDate);
		Assertions.assertTrue(testTransaction.getTransactionStatus() == "pending");
	}
	
	@Test 
	void TransactionAccepted() throws Exception {
		BigInteger moneyToDeposit = new BigInteger("500");
		// SENDER
		Person testSenderPerson = new Person(senderCustomerId);
		testSenderPerson.autoFillForTest();
		Customer testSenderCustomer = new Customer(senderCustomerId,testSenderPerson,testCustomerType);
		Account testSenderAccount = new Account(senderAccountId,testSenderCustomer,senderAccountNumber,accountType,dateAccountOpened);
		testSenderAccount.setCurrentBalance(moneyToDeposit);
		// RECEIVER
		Person testReceiverPerson = new Person(receiverCustomerId);
		testReceiverPerson.autoFillForTest();
		Customer testReceiverCustomer = new Customer(receiverCustomerId,testReceiverPerson,testCustomerType);
		Account testReceiverAccount = new Account(receiverAccountId,testReceiverCustomer,receiverAccountNumber,accountType,dateAccountOpened);
		BigInteger acceptAmount = new BigInteger("500");
		Transaction testTransaction = new Transaction(transactionId,testSenderAccount,testReceiverAccount,transactionType,acceptAmount,transactionDate);
		testTransaction.TransferFunds();
		Assertions.assertTrue(testTransaction.getTransactionStatus() == "accepted");
	}
}
