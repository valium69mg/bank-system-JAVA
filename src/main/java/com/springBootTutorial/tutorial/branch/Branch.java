package com.springBootTutorial.tutorial.branch;

public class Branch {

	private Integer branchId;
	private String branchName;
	private String branchCode;
	private BranchAddress address;
	private Integer phoneNumber;
	
	public Branch(Integer branchId, String branchName,String branchCode, BranchAddress address,Integer phoneNumber) {
		this.branchId = branchId;
		this.branchCode = branchCode;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}

	public Integer getBranchId() {
		return branchId;
	}

	public void setBranchId(Integer branchId) {
		this.branchId = branchId;
	}

	public String getBranchName() {
		return branchName;
	}

	public void setBranchName(String branchName) {
		this.branchName = branchName;
	}

	public String getBranchCode() {
		return branchCode;
	}

	public void setBranchCode(String branchCode) {
		this.branchCode = branchCode;
	}

	public BranchAddress getAddress() {
		return address;
	}

	public void setAddress(BranchAddress address) {
		this.address = address;
	}

	public Integer getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(Integer phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
