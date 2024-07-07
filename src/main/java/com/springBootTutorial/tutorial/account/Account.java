package com.springBootTutorial.tutorial.account;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

import com.springBootTutorial.tutorial.person.Person;

public class Account {

	private Integer accountId;
	private Person person;
	private Integer accountNumber;
	private String accountType;
	private BigInteger currentBalance;
	private String dateAccountOpened;
	private String accountStatus;
	
	String[] accountStatuses = {"closed","opened"};
	String[] accountTypes = {"personal account","business account"};

	public Account(Integer accountId,Person person, Integer accountNumber, String accountType,String dateAccountOpened) throws Exception {
		this.accountId = accountId;
		this.person = person;
		if (!validateAccountType(accountType)) {
			throw new Exception("An exception occurred: Account Type in Account Class is incorrect, must be a valid account type");

		}
		this.accountType = accountType;
		if (!validateDate(dateAccountOpened)) {
			throw new Exception("An exception occurred: Date Account Opened in Account Class is incorrect, must be a valid format (YYYY-MM-DD)");
		}
		this.dateAccountOpened = dateAccountOpened;
		this.accountStatus = "opened";
		this.currentBalance = new BigInteger("0");		
	}
	
	public boolean validateAccountType(String accountType) {
		List<String> accountTypeList = Arrays.asList(accountTypes);
		if (!accountTypeList.contains(accountType)) {
			return false;
		}
		return true;
	}
	
	public boolean validateDate(String dateAccount) {
		for (int i = 0; i < dateAccount.length(); i++) {
		    char c = dateAccount.charAt(i); 
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
	
	

	public Person getPerson() {
		return person;
	}

	public Integer getAccountNumber() {
		return accountNumber;
	}
	
	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) throws Exception {
		if (!validateAccountType(accountType)) {
			throw new Exception("An exception occurred: Account Type in Account Class is incorrect, must be a valid account type");

		}
		this.accountType = accountType;
	}


	public void setAccountNumber(Integer accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigInteger getCurrentBalance() {
		return currentBalance;
	}

	public void setCurrentBalance(BigInteger currentBalance) {
		this.currentBalance = currentBalance;
	}

	public String getAccountStatus() {
		return accountStatus;
	}

	public void setAccountStatus(String accountStatus) {
		this.accountStatus = accountStatus;
	}

	public Integer getAccountId() {
		return accountId;
	}

	public void setAccountId(Integer accountId) {
		this.accountId = accountId;
	}

	
	public String getDateAccountOpened() {
		return dateAccountOpened;
	}

	public void setDateAccountOpened(String dateAccountOpened) throws Exception {
		if (!validateDate(dateAccountOpened)) {
			throw new Exception("An exception occurred: Date Account Opened in Account Class is incorrect, must be a valid format (YYYY-MM-DD)");
		}
		this.dateAccountOpened = dateAccountOpened;
		this.dateAccountOpened = dateAccountOpened;
	}
	
	
	
}
