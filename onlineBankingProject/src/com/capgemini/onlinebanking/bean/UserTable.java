package com.capgemini.onlinebanking.bean;

public class UserTable {
	private int accountId;
	private String userId;
	private  String loginPassword;
	private String secretQuestion;
	private String secretAnswer;
	private String trasactionPassword;
	private String lockStatus="f";
	private int lockCount=0;
	
	public UserTable() {
		// TODO Auto-generated constructor stub
	}

	
	
	public UserTable(int accountId, String userId, String loginPassword,
			String secretQuestion, String secretAnswer, String trasactionPassword,
			String lockStatus, int lockCount) {
		super();
		this.accountId = accountId;
		this.userId = userId;
		this.loginPassword = loginPassword;
		this.secretQuestion = secretQuestion;
		this.secretAnswer = secretAnswer;
		this.trasactionPassword = trasactionPassword;
		this.lockStatus = lockStatus;
		this.lockCount = lockCount;
	}



	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getLoginPassword() {
		return loginPassword;
	}

	public void setLoginPassword(String loginPassword) {
		this.loginPassword = loginPassword;
	}

	public String getSecretQuestion() {
		return secretQuestion;
	}

	public void setSecretQuestion(String secretQuestion) {
		this.secretQuestion = secretQuestion;
	}

	public String getSecretAnswer() {
		return secretAnswer;
	}

	public void setSecretAnswer(String secretAnswer) {
		this.secretAnswer = secretAnswer;
	}

	public String getTrasactionPassword() {
		return trasactionPassword;
	}

	public void setTrasactionPassword(String trasactionPassword) {
		this.trasactionPassword = trasactionPassword;
	}

	public String getLockStatus() {
		return lockStatus;
	}

	public void setLockStatus(String lockStatus) {
		this.lockStatus = lockStatus;
	}

	public int getLockCount() {
		return lockCount;
	}

	public void setLockCount(int lockCount) {
		this.lockCount = lockCount;
	}



	@Override
	public String toString() {
		return "UserTable [accountId=" + accountId + ", userId=" + userId
				+ ", loginPassword=" + loginPassword + ", secretQuestion="
				+ secretQuestion + ", secretAnswer=" + secretAnswer
				+ ", trasactionPassword=" + trasactionPassword
				+ ", lockStatus=" + lockStatus + ", lockCount=" + lockCount
				+ "]";
	}
	
	
	
	
}
