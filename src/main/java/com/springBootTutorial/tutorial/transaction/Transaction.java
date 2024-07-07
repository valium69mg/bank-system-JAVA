package com.springBootTutorial.tutorial.transaction;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.springBootTutorial.tutorial.account.Account;

public class Transaction {
	
	private Integer transactionId;
	private Account senderAccount;
	private Account receiverAccount;
	private String transactionType;
	private BigInteger transactionAmount;
	private String transactionDate;
	private String transactionStatus;
	
	String[] transactionTypes = {"fund transfer","loan payment","fund withdrawal"};
	String[] transactionStatuses = {"accepted","pending","rejected"};

	
	public Transaction(Integer transactionId, Account senderAccount, Account receiverAccount, String transactionType, 
			BigInteger transactionAmount, String transactionDate) throws Exception {
		
		this.transactionId = transactionId;
		this.senderAccount = senderAccount;
		this.receiverAccount = receiverAccount;
		if (!validateTransactionType(transactionType)) {
			throw new Exception("An exception occurred: Transaction Type in Transaction Class is incorrect, must be a valid value");
		}
		this.transactionType = transactionType;
		this.transactionAmount = transactionAmount;
		if (!validateDate(transactionDate)) {
			throw new Exception("An exception occurred: Transaction Date in Transaction Class is incorrect, must be a valid format (YYYY-MM-DD)");
		}
		this.transactionDate = transactionDate;
		// CHECK FOR FUNDS
		BigInteger senderCurrentBalance = senderAccount.getCurrentBalance();
		if (senderCurrentBalance.compareTo(transactionAmount) == 0 || senderCurrentBalance.compareTo(transactionAmount) == 1) {
			this.transactionStatus = "pending";
		} else {
			this.transactionStatus = "rejected";
		}			
	}
	
	public void TransferFunds() {
		BigInteger receiverBalance = receiverAccount.getCurrentBalance();
		BigInteger senderBalance = senderAccount.getCurrentBalance();
		if (senderBalance.compareTo(transactionAmount) == 0 || senderBalance.compareTo(transactionAmount) == 1) {
			senderAccount.setCurrentBalance(senderBalance.subtract(transactionAmount));
			receiverAccount.setCurrentBalance(receiverBalance.add(transactionAmount)); // ADD TRANSACTION AMOUNT IF WE HAVE FUNDS
			this.transactionStatus = "accepted";
		}
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
	
	

	public String getTransactionStatus() {
		return transactionStatus;
	}


	public Account getSenderAccount() {
		return senderAccount;
	}


	public Account getReceiverAccount() {
		return receiverAccount;
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
