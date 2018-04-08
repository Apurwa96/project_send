package com.capgemini.onlinebanking.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;





import com.capgemini.onlinebanking.bean.Account;
import com.capgemini.onlinebanking.bean.Customer;
import com.capgemini.onlinebanking.bean.ServiceTracker;
import com.capgemini.onlinebanking.bean.UserTable;
import com.capgemini.onlinebanking.exception.BankingException;
import com.capgemini.onlinebanking.utility.DBConnection;

public class BankingDao implements IBankingDao {
	
	Logger logger=Logger.getRootLogger();
	public BankingDao() {
		PropertyConfigurator.configure("resources//log4j.properties");
	}
		

	@SuppressWarnings("resource")
	@Override
	public int addAcHolderDetails(Customer customer, Account account) throws BankingException {
		// TODO Auto-generated method stub
		
		Connection connection = DBConnection.getInstance().getConnection();	
		
		PreparedStatement preparedStatement=null;		
		ResultSet resultSet = null;
		
		int custId=0;
		
		int queryResult=0;
		try
		{		
			
			preparedStatement=connection.prepareStatement(QueryMapper.INSERTCUSTQRY);

			preparedStatement.setString(1,customer.getCustomerName());
			preparedStatement.setString(2,customer.getMobileNo());
			preparedStatement.setString(3,customer.getEmail());
			preparedStatement.setString(4,customer.getAddress());
			preparedStatement.setString(5,customer.getPancard());
			preparedStatement.setString(6,account.getAccountType());
			preparedStatement.setDouble(7,account.getAccountBalance());
			
				
			queryResult=preparedStatement.executeUpdate();
			
			preparedStatement = connection.prepareStatement(QueryMapper.CUSTOMERID_QUERY_SEQUENCE);
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				custId=Integer.parseInt(resultSet.getString(1));
						
			}
	
			if(queryResult==0)
			{
				logger.error("Insertion failed ");
				throw new BankingException ("Inserting customer details failed ");

			}
			else
			{
				logger.info("Customer details added successfully:");	
				preparedStatement.close();
				connection.close();
				return custId;
			}

		}
		catch(SQLException sqlException)
		{
			logger.error(sqlException.getMessage());
			throw new BankingException ("Tehnical problem occured refer log");
		}

		finally
		{
			try 
			{
				//resultSet.close();
				preparedStatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				logger.error(sqlException.getMessage());
				throw new BankingException ("Error in closing db connection");

			}
		}
				
	}
	

	@Override
	public String addUserDatabase(UserTable user) throws BankingException{
			// TODO Auto-generated method stub
		Connection connection = DBConnection.getInstance().getConnection();	
		
		PreparedStatement preparedStatement=null;		
		
		int queryResult=0;
		try
		{		
			preparedStatement=connection.prepareStatement(QueryMapper.INSERTUSERQRY);

			preparedStatement.setInt(1,user.getAccountId());
			preparedStatement.setString(2,user.getUserId());
			preparedStatement.setString(3, user.getLoginPassword());
			preparedStatement.setString(4, user.getSecretQuestion());
			preparedStatement.setString(5, user.getSecretAnswer());
			preparedStatement.setString(6, user.getTrasactionPassword());
			preparedStatement.setString(7,user.getLockStatus());
			preparedStatement.setInt(8,user.getLockCount());
			
				
			queryResult=preparedStatement.executeUpdate();
			
				
			if(queryResult==0)
			{
				logger.error("Insertion failed ");
				throw new BankingException ("SIGN UP failed ");

			}
			else
			{
				logger.info("Your details has been added successfully: ");
				return user.getUserId();
			}

		}
		catch(SQLException sqlException)
		{
			logger.error(sqlException.getMessage());
			throw new BankingException ("Tehnical problem occured refer log");
		}

		finally
		{
			try 
			{
				preparedStatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				logger.error(sqlException.getMessage());
				throw new BankingException ("Error in closing db connection");

			}
		}
		
		
	}


	@Override
	public boolean searchAccount(int accountId) throws BankingException {
		// TODO Auto-generated method stub
		
		Connection connection = DBConnection.getInstance().getConnection();	
		PreparedStatement preparedStatement=null;	
		ResultSet resultSet = null;
		
		boolean flag;
		
		try {
			preparedStatement=connection.prepareStatement(QueryMapper.SEARCHACQRY);
			preparedStatement.setInt(1, accountId);
			resultSet = preparedStatement.executeQuery();
			
			flag=resultSet.next();
			
			
			

		} catch (SQLException e) {
			throw new BankingException("dao/sql/ERROR:"
					+ e.getMessage());
		} catch (Exception e) {
			throw new BankingException("ERROR:" + e.getMessage());
		} finally {
			try {
				if (connection!= null) {
					preparedStatement.close();
					connection.close();
					resultSet.close();
				}
			} catch (Exception e) {
				throw new BankingException("Could not close the connection");
			}
		}
		
		
		return flag;
			
		}


	@Override
	public boolean searchInUser(int accountId) throws BankingException {
		// TODO Auto-generated method stub
		Connection connection = DBConnection.getInstance().getConnection();	
		PreparedStatement preparedStatement=null;	
		ResultSet resultSet = null;
		
		boolean flag;
		
		try {
			preparedStatement=connection.prepareStatement(QueryMapper.SEARCHUSERQRY);
			preparedStatement.setInt(1, accountId);
			resultSet = preparedStatement.executeQuery();
			
			flag=resultSet.next();
			
			
			

		} catch (SQLException e) {
			throw new BankingException("dao/sql/ERROR:"
					+ e.getMessage());
		} catch (Exception e) {
			throw new BankingException("ERROR:" + e.getMessage());
		} finally {
			try {
				if (connection!= null) {
					preparedStatement.close();
					connection.close();
					resultSet.close();
				}
			} catch (Exception e) {
				throw new BankingException("Could not close the connection");
			}
		}
		
		
		return flag;
	}


	@Override
	public boolean getCustomerLogin(String user_name, String password)
			throws BankingException {
		// TODO Auto-generated method stub
		
		Connection connection = DBConnection.getInstance().getConnection();	
		PreparedStatement preparedStatement=null;	
		ResultSet resultSet = null;
		String login_pass=null;
		
		boolean flag=false;
		
		try {
			preparedStatement=connection.prepareStatement(QueryMapper.FINDUSER);
			preparedStatement.setString(1, user_name);
			resultSet = preparedStatement.executeQuery();
			
			
			if(resultSet.next())
			{	
				login_pass=resultSet.getString(1);				
				if(login_pass.equals(password))
					flag=true;
			}
			
			
		} catch (SQLException e) {
			throw new BankingException("dao/sql/ERROR:"
					+ e.getMessage());
		} catch (Exception e) {
			throw new BankingException("ERROR:" + e.getMessage());
		} finally {
			try {
				if (connection!= null) {
					preparedStatement.close();
					connection.close();
					resultSet.close();
				}
			} catch (Exception e) {
				throw new BankingException("Could not close the connection");
			}
		}
		
		
		return flag;
	}


	


	@Override
	public int updateMobAddDetails(String mobileno, String address,
			int accountId) throws BankingException {
		// TODO Auto-generated method stub
		
		Connection connection = DBConnection.getInstance().getConnection();	
		PreparedStatement preparedStatement=null;	
		
		int result=0;
		
		
		
		try {
			preparedStatement=connection.prepareStatement(QueryMapper.UPDATEMOBADDQRY);
			preparedStatement.setString(1, mobileno);
			preparedStatement.setString(2, address);
			preparedStatement.setInt(3, accountId);
			result = preparedStatement.executeUpdate();
			
			
		} catch (SQLException e) {
			throw new BankingException("dao/sql/ERROR:"
					+ e.getMessage());
		} catch (Exception e) {
			throw new BankingException("ERROR:" + e.getMessage());
		} finally {
			try {
				if (connection!= null) {
					preparedStatement.close();
					connection.close();
					}
			} catch (Exception e) {
				throw new BankingException("Could not close the connection");
			}
		}
				
		return result;
	}


	@Override
	public Customer fetchMobAddDetails(int accountId) throws BankingException {
		// TODO Auto-generated method stub
		
		Connection connection = DBConnection.getInstance().getConnection();	
		PreparedStatement preparedStatement=null;	
		ResultSet resultSet = null;
		Customer customer;
		
		
		
		try {
			preparedStatement=connection.prepareStatement(QueryMapper.DISPLAYOLDMOBADDQRY);
			preparedStatement.setInt(1, accountId);
			resultSet = preparedStatement.executeQuery();
			
			 customer=new Customer();
			if(resultSet.next())
			{	
				customer.setMobileNo(resultSet.getString(1));
				customer.setAddress(resultSet.getString(2));
			}
			
			
		} catch (SQLException e) {
			throw new BankingException("dao/sql/ERROR:"
					+ e.getMessage());
		} catch (Exception e) {
			throw new BankingException("ERROR:" + e.getMessage());
		} finally {
			try {
				if (connection!= null) {
					preparedStatement.close();
					connection.close();
					resultSet.close();
				}
			} catch (Exception e) {
				throw new BankingException("Could not close the connection");
			}
		}
				
		return customer;
		
		
	}


	@SuppressWarnings("resource")
	@Override
	public int requestChequeBook(int accountId) throws BankingException {
		// TODO Auto-generated method stub
		
		Connection connection = DBConnection.getInstance().getConnection();	
		PreparedStatement preparedStatement=null;	
		int serviceId=0;
		int queryResult=0;
		ResultSet resultSet=null;
		try 
		{
			preparedStatement=connection.prepareStatement(QueryMapper.CHECKBOOKQUERY);	
			preparedStatement.setInt(1,accountId);
			queryResult=preparedStatement.executeUpdate();				
			
			preparedStatement = connection.prepareStatement(QueryMapper.SERVICEID_QUERY_SEQUENCE);
			resultSet=preparedStatement.executeQuery();
			
			if(resultSet.next())
			{
				serviceId=Integer.parseInt(resultSet.getString(1));
						
			}
	
			if(queryResult==0)
			{
				logger.error("Insertion failed ");
				throw new BankingException ("Check Book Request failed ");

			}
			else
			{
				logger.info("Service requested successfully:");	
				preparedStatement.close();
				connection.close();
				return serviceId;
			}

		}
		catch(SQLException sqlException)
		{
			logger.error(sqlException.getMessage());
			throw new BankingException ("Tehnical problem occured refer log");
		}

		finally
		{
			try 
			{
				resultSet.close();
				preparedStatement.close();
				connection.close();
			}
			catch (SQLException sqlException) 
			{
				logger.error(sqlException.getMessage());
				throw new BankingException ("Error in closing db connection");

			}
		}
				
	}


	@Override
	public ServiceTracker getServiceDetail(int serviceId)
			throws BankingException {
		// TODO Auto-generated method stub
		
		Connection connection = DBConnection.getInstance().getConnection();	
		PreparedStatement preparedStatement=null;	
		ResultSet resultSet = null;
		ServiceTracker service;
		
		
		
		try {
			preparedStatement=connection.prepareStatement(QueryMapper.SERVICETRACKQRY);
			preparedStatement.setInt(1, serviceId);
			resultSet = preparedStatement.executeQuery();
			service=new ServiceTracker();
			
			if(resultSet.next())
			{	
				service.setServiceID(resultSet.getInt(1));
				service.setService_Description(resultSet.getString(2));
				service.setAccount_ID(resultSet.getInt(3));
				service.setService_Raised_Date(resultSet.getDate(4));
				service.setService_status(resultSet.getString(5));
			}
			else
			{
				service=null;
			}
		
			
		} catch (SQLException e) {
			throw new BankingException("dao/sql/ERROR:"
					+ e.getMessage());
		} catch (Exception e) {
			throw new BankingException("ERROR:" + e.getMessage());
		} finally {
			try {
				if (connection!= null) {
					preparedStatement.close();
					connection.close();
					resultSet.close();
				}
			} catch (Exception e) {
				throw new BankingException("Could not close the connection");
			}
		}				
		
		return service;
	}
	
		
		
	}
	


