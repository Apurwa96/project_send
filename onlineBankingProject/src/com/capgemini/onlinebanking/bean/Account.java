package com.capgemini.onlinebanking.bean;

import java.sql.Date;

public class Account {
	
	private int accountID ;
	private String  accountType;
	private double accountBalance;
	private Date  openDate;
	
	public Account() {
		// TODO Auto-generated constructor stub
	}

	public Account(int accountID, String accountType, double accountBalance,
			Date openDate) {
		super();
		this.accountID = accountID;
		this.accountType = accountType;
		this.accountBalance = accountBalance;
		this.openDate = openDate;
	}

	public int getAccountID() {
		return accountID;
	}

	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Date getOpenDate() {
		return openDate;
	}

	public void setOpenDate(Date openDate) {
		this.openDate = openDate;
	}
	
	
	
	

}
