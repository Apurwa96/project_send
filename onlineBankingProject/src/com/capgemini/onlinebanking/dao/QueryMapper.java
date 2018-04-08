package com.capgemini.onlinebanking.dao;

public interface QueryMapper 
{	
	public static final String CUSTSEQQRY=        	 "SELECT CustIdSeq.NEXTVAL FROM DUAL";
	public static final String TRANSEQQRY=           "SELECT TRANSACIDSeq.NEXTVAL FROM DUAL";
	public static final String SERVSEQQRY= 			 "SELECT SERVIDSeq.NEXTVAL FROM DUAL";	
	public static final String TRCKTRANQRY=          "SELECT * FROM transactions WHERE account_id=? ";
	public static final String SERVICETRACKQRY=          "SELECT * FROM service_tracker WHERE service_id=?";	
	public static final String INSERTSRVREQQRY= 	 "INSERT into service_tracker values(?,'Request For Chequebook',?,SYSDATE,'Approved and Being Processed')";
	public static final String VIEWDTLSTMNTQRY=       "SELECT * FROM transactions WHERE account_id=? AND TO_CHAR(dateoftransaction, 'YYYY') BETWEEN ? AND ? AND TO_CHAR(dateoftransaction, 'MM') BETWEEN ? AND ? AND TO_CHAR(dateoftransaction,'DD') BETWEEN ? AND ?";
	public static final String VIEWMINISTMNTQRY=	  "SELECT * FROM transactions WHERE account_id=? AND rownum<=10 ORDER BY dateoftransaction DESC";
	public static final String CHANGEPASSWRD=      "UPDATE user_table SET login_password=? WHERE Account_ID=?";

	
	
	public static final String INSERTCUSTQRY= 		 	"INSERT ALL INTO Customer VALUES(applicationId.NEXTVAL,?,?,?,?,?) INTO Account_Master VALUES(applicationId.NEXTVAL,?,?,SYSDATE) SELECT * FROM dual";
	public static final String SEARCHACQRY= 			 "SELECT account_id from Account_Master where account_id=?";
	public static final String CUSTOMERID_QUERY_SEQUENCE="SELECT applicationId.CURRVAL FROM DUAL";
	public static final String DISPLAYOLDMOBADDQRY= 	 "SELECT mobile_no, Address FROM Customer where account_id=?";
	public static final String UPDATEMOBADDQRY=      "UPDATE Customer SET mobile_no=?, Address=? where account_id=?";
		
	
	public static final String INSERTUSERQRY= 		 "INSERT INTO usertable VALUES(?,?,?,?,?,?,?,?)";
	public static final String SEARCHUSERQRY= 		 "SELECT account_id from UserTable where account_id=?";
	public static final String FINDUSER= 			 "SELECT login_password from userTable where user_id like ?";
	
	public static final String CHECKBOOKQUERY= 	 "INSERT into service_tracker values(serviceId.NEXTVAL,'Request For Chequebook',?,SYSDATE,'Approved and Being Processed')";
	public static final String SERVICEID_QUERY_SEQUENCE="SELECT serviceId.CURRVAL FROM DUAL";
	
	
	
}
