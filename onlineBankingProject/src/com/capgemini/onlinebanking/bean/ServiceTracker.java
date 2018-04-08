package com.capgemini.onlinebanking.bean;

import java.sql.Date;

public class ServiceTracker 
{
	private int ServiceID ;
	private String Service_Description; 
	private int Account_ID;
	private Date Service_Raised_Date;
	private String Service_status;
	
	public ServiceTracker()
	{
		super();
	}

	public ServiceTracker(int serviceID, String service_Description,
			int account_ID, Date service_Raised_Date, String service_status) {
		super();
		ServiceID = serviceID;
		Service_Description = service_Description;
		Account_ID = account_ID;
		Service_Raised_Date = service_Raised_Date;
		Service_status = service_status;
	}

	@Override
	public String toString() {
		return "ServiceTracker [ServiceID=" + ServiceID
				+ ", Service_Description=" + Service_Description
				+ ", Account_ID=" + Account_ID + ", Service_Raised_Date="
				+ Service_Raised_Date + ", Service_status=" + Service_status
				+ "]";
	}

	public int getServiceID() {
		return ServiceID;
	}

	public void setServiceID(int serviceID) {
		ServiceID = serviceID;
	}

	public String getService_Description() {
		return Service_Description;
	}

	public void setService_Description(String service_Description) {
		Service_Description = service_Description;
	}

	public int getAccount_ID() {
		return Account_ID;
	}

	public void setAccount_ID(int account_ID) {
		Account_ID = account_ID;
	}

	public Date getService_Raised_Date() {
		return Service_Raised_Date;
	}

	public void setService_Raised_Date(Date service_Raised_Date) {
		Service_Raised_Date = service_Raised_Date;
	}

	public String getService_status() {
		return Service_status;
	}

	public void setService_status(String service_status) {
		Service_status = service_status;
	}
	
	
	
}
