package com.capgemini.onlinebanking.ui.reference;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import org.apache.log4j.PropertyConfigurator;

import com.capgemini.onlinebanking.bean.Customer;
import com.capgemini.onlinebanking.bean.ServiceTracker;
import com.capgemini.onlinebanking.bean.Transaction;
import com.capgemini.onlinebanking.bean.UserTable;
import com.capgemini.onlinebanking.service.BankingServiceImpl;
import com.capgemini.onlinebanking.service.IBankingService;




public class OnlineAccountHolder {
	
	static Scanner sc = new Scanner(System.in);
	static IBankingService customerService = null;
	static BankingServiceImpl customerServiceImpl = null;
	//static Logger logger = Logger.getRootLogger();
	
	
	public void AcHolderMenu()
	 {
		PropertyConfigurator.configure("resources//log4j.properties");
		UserTable userBean = null;

		String userId = null;
		int option = 0;

		while (true) {

			// show menu
			System.out.println();
			System.out.println();
			System.out.println("   Online Banking System ");
			System.out.println("_______________________________\n");

			System.out.println("1. View Mini/ Detailed Statement ");
			System.out.println("2.Change Address/ Phone No.");
			System.out.println("3.Request Cheque Book");
			System.out.println("4.Track service Request");
			System.out.println("5.Fund Transfer");
			System.out.println("6.Change Password");
			System.out.println("7.Exit");
			System.out.println("________________________________");
			System.out.println("Select an option:");
			// accept option

			try {
				option = sc.nextInt();

				switch (option) {

				case 1:	viewStatement();					
				break;
				case 2:	//changeMobileAddress();					
				break;
				case 3:  requestForChequeBook();
				break;
				case 4: trackServiceRequestDetails();					
				break;
				case 5: fundTransfer();
				break;
				case 6: changePwd();
				break;
				case 7: System.out.print("Exit Banking Application");
				System.exit(0);
				break;
				
				default:
					System.out.println("Enter a valid option[1-7]");
				}// end of switch
			}

			catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Please enter a numeric value, try again");
			}

		}// end of while
	}// end of try

	private static void fundTransfer() {
		// TODO Auto-generated method stub
		
	}

	private static void changePwd() 
	{
		System.out.println("Enter the account no:");
		int id=sc.nextInt();
		ArrayList<UserTable> al2=new ArrayList<UserTable>();
	try 
		{	
		/*System.out.println("Your Existing Password is:");
		for(User i:al2)
		{
			System.out.println(i.getLoginPassword());
		}*/
			System.out.println("Enter new Password:");
			String loginPassword=sc.next();
			//customerService.updatePwd(loginPassword, id);
			System.out.println("Password updated");
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
	}

	
	
	private static void viewTranDetails()
	{
		System.out.println("Enter Account No: ");
		int accid=sc.nextInt();
	
		ArrayList<Transaction> al1=new ArrayList<Transaction>();
		try
		{
			//al1=customerService.fetchTranDetail(accid);
			System.out.println("Transaction_ID\tTransaction Description\t\tDate of Transaction\tTransaction Type\tTransaction Amount\tAccount No.");
			for(Transaction i:al1)
			{
				System.out.println(i.getTransaction_ID()+"\t\t"+i.getTran_description()+"\t\t\t"+i.getDateofTransaction()+"\t\t"+i.getTransactionType()+"\t\t\t"+i.getTranAmount()+"\t\t\t"+i.getAccount_No());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	private static void trackServiceRequestDetails()
	{
		System.out.println("Enter Service Id: ");
		int srvid=sc.nextInt();
	
		ArrayList<ServiceTracker> al1=new ArrayList<ServiceTracker>();
		try
		{
			//al1=customerService.fetchServDetail(srvid);
			System.out.println("Service_ID\tService_Description\t\tAccount_ID\tService_Raised_Date\tService_status");
			for(ServiceTracker i:al1)
			{
				System.out.println(i.getServiceID()+"\t\t"+i.getService_Description()+"\t\t\t"+i.getAccount_ID()+"\t\t"+i.getService_Raised_Date()+"\t\t\t"+i.getService_status());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}

	}
	
	private static void requestForChequeBook()
	{
		System.out.println("Enter Account No: ");
		int accid=sc.nextInt();
		try 
		{
			System.out.println("Your cheque book request is approved and being processed.");
			//int servid=customerService.addCbkRqst(accid);
		//	System.out.println("Your service request id is: "+servid);
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	private static void viewStatement()
	{
		int chc=0;
		System.out.println("Enter the type of statement you want to generate");
		System.out.println("1:View Mini Statement\n2:View Detailed Statement");
		chc=sc.nextInt();
		switch(chc)
		{
		case 1: System.out.println("Enter Account No: ");
		int accid=sc.nextInt();
	
		ArrayList<Transaction> al1=new ArrayList<Transaction>();
		try
		{
			//al1=customerService.fetchMiniStmnt(accid);
			System.out.println("Transaction_ID\tTransaction Description\t\tDate of Transaction\tTransaction Type\tTransaction Amount\tAccount No.");
			for(Transaction i:al1)
			{
				System.out.println(i.getTransaction_ID()+"\t\t"+i.getTran_description()+"\t\t\t"+i.getDateofTransaction()+"\t\t"+i.getTransactionType()+"\t\t\t"+i.getTranAmount()+"\t\t\t"+i.getAccount_No());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		break;
		case 2: System.out.println("Enter Account No: ");
		int acid=sc.nextInt();
		System.out.println("Enter starting year: ");
		int y1=sc.nextInt();
		System.out.println("Enter ending year: ");
		int y2=sc.nextInt();
		System.out.println("Enter starting month");
		int m1=sc.nextInt();
		System.out.println("Enter ending month");
		int m2=sc.nextInt();
		System.out.println("Enter starting day");
		int d1=sc.nextInt();
		System.out.println("Enter ending day");
		int d2=sc.nextInt();
		
		ArrayList<Transaction> al2=new ArrayList<Transaction>();
		try
		{
			//al2=customerService.fetchDetailedStmnt(acid, y1, y2, m1, m2, d1, d2);
			System.out.println("Transaction_ID\tTransaction Description\t\tDate of Transaction\tTransaction Type\tTransaction Amount\tAccount No.");
			for(Transaction i:al2)
			{
				System.out.println(i.getTransaction_ID()+"\t\t"+i.getTran_description()+"\t\t\t"+i.getDateofTransaction()+"\t\t"+i.getTransactionType()+"\t\t\t"+i.getTranAmount()+"\t\t\t"+i.getAccount_No());
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		};
		break;
		default:System.exit(0);
		}
		
		

	}
	
}


