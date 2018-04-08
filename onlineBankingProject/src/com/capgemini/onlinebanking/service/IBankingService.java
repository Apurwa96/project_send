package com.capgemini.onlinebanking.service;

import java.util.ArrayList;

import com.capgemini.onlinebanking.bean.Account;
import com.capgemini.onlinebanking.bean.Customer;
import com.capgemini.onlinebanking.bean.ServiceTracker;
import com.capgemini.onlinebanking.bean.UserTable;
import com.capgemini.onlinebanking.exception.BankingException;


public interface IBankingService {
	
	public int addAcHolderDetails(Customer customer, Account account) throws BankingException;
	
	public String addUserDatabase(UserTable user) throws BankingException;
	public boolean searchAccount(int accountId) throws BankingException;
	public boolean searchInUser(int accountId) throws BankingException;
	public boolean getAdminLogin(String user_name, String password);
	public boolean getCustomerLogin(String user_name, String password) throws BankingException;
	public Customer fetchMobAddDetails(int accountId ) throws BankingException;
	public int updateMobAddDetails(String mobileno,String address,int accountId) throws BankingException;
	
	
	public int requestChequeBook(int accid)throws BankingException;
	public ServiceTracker getServiceDetail(int serviceId ) throws BankingException;
	
	
	
	
}
