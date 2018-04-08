package com.capgemini.onlinebanking.service;


import com.capgemini.onlinebanking.bean.Account;
import com.capgemini.onlinebanking.bean.Customer;
import com.capgemini.onlinebanking.bean.ServiceTracker;
import com.capgemini.onlinebanking.bean.UserTable;
import com.capgemini.onlinebanking.dao.BankingDao;
import com.capgemini.onlinebanking.dao.IBankingDao;
import com.capgemini.onlinebanking.exception.BankingException;

public class BankingServiceImpl implements IBankingService {
	
	IBankingDao bankingDao;

	@Override
	public int addAcHolderDetails(Customer customer, Account account) throws BankingException {
		bankingDao=new BankingDao();
		int custId;
		
		custId=bankingDao.addAcHolderDetails(customer,account);
		return custId;
	}
	

	@Override
	public String addUserDatabase(UserTable user) throws BankingException{
		bankingDao=new BankingDao();
		String userTid;
		
		userTid=bankingDao.addUserDatabase(user);
		return userTid;
	}


	@Override
	public boolean searchAccount(int accountId) throws BankingException {
		bankingDao=new BankingDao();
		return bankingDao.searchAccount(accountId);
	}


	@Override
	public boolean searchInUser(int accountId) throws BankingException {
		bankingDao=new BankingDao();
		return bankingDao.searchInUser(accountId);
	}


	@Override
	public boolean getAdminLogin(String user_name, String password) {
		if(user_name.equals("admin") && password.equals("capgemini123"))
		{
			System.out.println("Login Successful");
			return true;
		}
		else
		{
			System.out.println("Login Failed");
			return false;
		}
	}


	@Override
	public boolean getCustomerLogin(String user_name, String password) throws BankingException {
		
		bankingDao=new BankingDao();
		return bankingDao.getCustomerLogin(user_name,password);
	}


	


	@Override
	public int updateMobAddDetails(String mobileno, String address,
			int accountId) throws BankingException {
		bankingDao=new BankingDao();
		return bankingDao.updateMobAddDetails(mobileno, address, accountId);
	}


	@Override
	public Customer fetchMobAddDetails(int accountId) throws BankingException {
		
		bankingDao=new BankingDao();
		return bankingDao.fetchMobAddDetails(accountId);
	}


	@Override
	public int requestChequeBook(int accountId) throws BankingException {
		
		bankingDao=new BankingDao();
		return bankingDao.requestChequeBook(accountId);
	}


	@Override
	public ServiceTracker getServiceDetail(int serviceId)
			throws BankingException {
		// TODO Auto-generated method stub
		
		bankingDao=new BankingDao();
		return bankingDao.getServiceDetail(serviceId);
	}


	

}
