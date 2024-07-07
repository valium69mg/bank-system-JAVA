package com.springBootTutorial.tutorial.transaction;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.springBootTutorial.tutorial.customer.Customer;

public class Transaction {
	
	private Integer transactionId;
	private Customer senderCustomer;
	private Customer receiverCustomer;
	private String transactionType;
	private BigInteger transactionAmount;
	private String transactionDate;
	
	String[] transactionTypes = {"fund transfer","loan payment","fund withdrawal"};
	
	public Transaction(Integer transactionId, Customer senderCustomer, Customer receiverCustomer, String transactionType, 
			BigInteger transactionAmount, String transactionDate) throws Exception {
		
		this.transactionId = transactionId;
		this.senderCustomer = senderCustomer;
		this.receiverCustomer = receiverCustomer;
		if (!validateTransactionType(transactionType)) {
			throw new Exception("An exception occurred: Transaction Type in Transaction Class is incorrect, must be a valid value");
		}
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		if (!validateDate(transactionDate)) {
			throw new Exception("An exception occurred: Transaction Date in Transaction Class is incorrect, must be a valid format (YYYY-MM-DD)");
		}
		this.transactionDate = transactionDate;
	}
	
	public boolean validateDate(String transactionDate) {
		for (int i = 0; i < transactionDate.length(); i++) {
		    char c = transactionDate.charAt(i); 
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
	
	public boolean validateTransactionType(String transactionType) {
		List<String> transactionTypesList = Arrays.asList(transactionTypes);
		if (!transactionTypesList.contains(transactionType)) {
			return false;
		}
		return true;
	}
	
	
	public Customer getSenderCustomer() {
		return senderCustomer;
	}


	public Customer getReceiverCustomer() {
		return receiverCustomer;
	}


	public Integer getTransactionId() {
		return transactionId;
	}

	public String getTransactionType() {
		return transactionType;
	}

	public BigInteger getTransactionAmount() {
		return transactionAmount;
	}

	public String getTransactionDate() {
		return transactionDate;
	}

	public String[] getTransactionTypes() {
		return transactionTypes;
	}
	
	
}
