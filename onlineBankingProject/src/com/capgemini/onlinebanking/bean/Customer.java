package com.capgemini.onlinebanking.bean;





public class Customer {
	private int accountID ;
	private String customerName ;
	private String mobileNo ;
	private String  email ;
	private String address ;
	private String pancard ;
	
	
	
	
	public Customer() {
		super();
	}

	







	public Customer(int accountID, String customerName, String mobileNo,
			String email, String address, String pancard) {
		super();
		this.accountID = accountID;
		this.customerName = customerName;
		this.mobileNo = mobileNo;
		this.email = email;
		this.address = address;
		this.pancard = pancard;
	}









	public int getAccountID() {
		return accountID;
	}



	public void setAccountID(int accountID) {
		this.accountID = accountID;
	}



	public String getCustomerName() {
		return customerName;
	}



	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}



	public String getMobileNo() {
		return mobileNo;
	}



	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getAddress() {
		return address;
	}



	public void setAddress(String address) {
		this.address = address;
	}



	public String getPancard() {
		return pancard;
	}



	public void setPancard(String pancard) {
		this.pancard = pancard;
	}

	
	
	
}
