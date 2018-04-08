package com.capgemini.onlinebanking.bean;

import java.sql.Date;

public class Transaction {
	
	private int Transaction_ID ;
	private String Tran_description;
	private Date DateofTransaction;
	private String TransactionType;
	private int TranAmount;
	private int Account_No;
	
	public Transaction() 
	{
		super();
	}
	public Transaction(int transaction_ID, String tran_description,
			Date dateofTransaction, String transactionType, int tranAmount,
			int account_No) {
		super();
		this.Transaction_ID = transaction_ID;
		this.Tran_description = tran_description;
		this.DateofTransaction = dateofTransaction;
		this.TransactionType = transactionType;
		this.TranAmount = tranAmount;
		this.Account_No = account_No;
	}
	public int getTransaction_ID() {
		return Transaction_ID;
	}
	public void setTransaction_ID(int transaction_ID) {
		this.Transaction_ID = transaction_ID;
	}
	public String getTran_description() {
		return Tran_description;
	}
	public void setTran_description(String tran_description) {
		this.Tran_description = tran_description;
	}
	public Date getDateofTransaction() {
		return DateofTransaction;
	}
	public void setDateofTransaction(Date dateofTransaction) {
		this.DateofTransaction = dateofTransaction;
	}
	public String getTransactionType() {
		return TransactionType;
	}
	public void setTransactionType(String transactionType) {
		this.TransactionType = transactionType;
	}
	public int getTranAmount() {
		return TranAmount;
	}
	public void setTranAmount(int tranAmount) {
		this.TranAmount = tranAmount;
	}
	public int getAccount_No() {
		return Account_No;
	}
	public void setAccount_No(int account_No) {
		this.Account_No = account_No;
	}
	
	@Override
	public String toString() 
	{
		return "Transaction [Transaction_ID=" + Transaction_ID
				+ ", Tran_description=" + Tran_description
				+ ", DateofTransaction=" + DateofTransaction
				+ ", TransactionType=" + TransactionType + ", TranAmount="
				+ TranAmount + ", Account_No=" + Account_No + "]";
	}
	
	
}
