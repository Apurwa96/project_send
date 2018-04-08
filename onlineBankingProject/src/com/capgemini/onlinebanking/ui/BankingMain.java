
package com.capgemini.onlinebanking.ui;


import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;



import com.capgemini.onlinebanking.bean.Account;
import com.capgemini.onlinebanking.bean.Customer;
import com.capgemini.onlinebanking.bean.ServiceTracker;
import com.capgemini.onlinebanking.bean.Transaction;
import com.capgemini.onlinebanking.bean.UserTable;
import com.capgemini.onlinebanking.exception.BankingException;
import com.capgemini.onlinebanking.service.BankingServiceImpl;
import com.capgemini.onlinebanking.service.IBankingService;

public class BankingMain {
	
	static Scanner sc = new Scanner(System.in);
	static IBankingService customerService = null;
	static BankingServiceImpl customerServiceImpl = null;
	
			public static void main(String[] args) {
				int option = 0;
			
			while (true) {

				// show menu
				System.out.println();
				System.out.println();
				System.out.println("   Online Banking System ");
				System.out.println("_______________________________\n");

				System.out.println("1.Account Holder ");
				System.out.println("2.Bank Admin");
				System.out.println("3.Exit");
				System.out.println("________________________________");
				System.out.println("Select an option:");
				// accept option

				try {
					option = sc.nextInt();

					switch (option) {

					case 1:
								accountHolderPage();
								break;

					case 2:	
								if(adminLogin())
								bankAdminPage();
								break;
						
					
					case 3:
							System.out.print("Exit Banking Application");
							System.exit(0);
							break;				
					
						
					default:
						System.out.println("Enter a valid option[1-3]");
					}// end of switch
				}

				catch (InputMismatchException e) {
					sc.nextLine();
					System.err.println("Please enter a numeric value, try again");
				}// end of try

			}// end of while
		
			}//end of main
		
			public static void accountHolderPage()
			{
				int option = 0;
				int login_count=0;
				
				while (true) {

					// show menu
					System.out.println();
					System.out.println();
					System.out.println("   Account Holder Page ");
					System.out.println("_______________________________\n");
					

					System.out.println("1.Log In ");
					System.out.println("2.Sign Up");
					System.out.println("3.Exit");
					System.out.println("________________________________");
					System.out.println("Select an option:");
					// accept option

					try {
						option = sc.nextInt();

						switch (option) {

						case 1:
									
							try {
								if(customerLogin())
								{
									System.out.println("Login Successful");
									System.out.println("------------------------");
									AcHolderMenu();
								}
								else
								{
									login_count++;
									System.out.println("login count: "+login_count);
									System.out.println("Login Unsuccessful");
									System.out.println("------------------------");
								}
							} catch (BankingException e1) {
								
								System.err.println("Technical problem occured");
							}
							if(login_count==3)
								lockAccount();
									break;

						case 2:
									//code for sign up
									customerService=new BankingServiceImpl();
									System.out.println("Enter Account ID: ");
									
									int accountId=sc.nextInt();
									try{
									if(customerService.searchAccount(accountId)){
										if(customerService.searchInUser(accountId))
										{
											System.out.println("This Account Already Exists.");
										}
										else
											userSignUp(accountId);
									}
									else
									{
										System.out.println("This account does not exist");
									}
									}catch (Exception e) {
										e.getMessage();
									}
									break;
							
						
						case 3:
								System.out.print("Exit Banking Application");
								System.exit(0);
								break;				
						
							
						default:
							System.out.println("Enter a valid option[1-3]");
						}// end of switch
					}

					catch (InputMismatchException e) {
						sc.nextLine();
						System.err.println("Please enter a numeric value, try again");
					}// end of try

				}// end of while
			
			}
		
			
			public static void bankAdminPage()
			{
				int option = 0;
				
				while (true) {

					// show menu
					System.out.println();
					System.out.println();
					System.out.println("   Bank Admin Page ");
					System.out.println("_______________________________\n");
					

					System.out.println("1.Create New Account ");
					System.out.println("2.View All Transactions");
					System.out.println("3.Logout");
					System.out.println("________________________________");
					System.out.println("Select an option:");
					// accept option

					try {
						option = sc.nextInt();

						switch (option) {

						case 1:
									
									createNewAccount();
									break;

						case 2:
									//code for view all transactions	
									
									break;
							
						
						case 3:
								System.out.print("Exit Banking Application");
								System.exit(0);
								break;				
						
							
						default:
							System.out.println("Enter a valid option[1-3]");
						}// end of switch
					}

					catch (InputMismatchException e) {
						sc.nextLine();
						System.err.println("Please enter a numeric value, try again");
					}// end of try

				}// end of while
			
			}
			
			private static void  createNewAccount()
			{
				try{
					
					customerService=new BankingServiceImpl();
				
				System.out.println("Enter Personal Details:");
				System.out.println("-----------------------------");
				System.out.println("Enter Customer Name: ");
				String custName=sc.next();
				System.out.println("Enter Mobile No:");
				String mobileno=sc.next();
				System.out.println("Enter Mail Id:");
				String email=sc.next();
				System.out.println("Enter Address:");
				String address=sc.next();
				System.out.println("Enter Pan No:");
				String panNo=sc.next();
				System.out.println("-----------------------------");
				
				
				Customer cust=new Customer();				
				cust.setCustomerName(custName);	
				cust.setMobileNo(mobileno);
				cust.setEmail(email);
				cust.setAddress(address);
				cust.setPancard(panNo);
				
				
				System.out.println("Enter Account details: ");
				System.out.println("-----------------------------");
				System.out.println("Enter Account Type(Current|Saving): ");
				String  accountType=sc.next();
				System.out.println("Enter Opening Balance: ");
				double accountBalance=sc.nextDouble();
				System.out.println("-----------------------------");
				
				Account ac=new Account();
				ac.setAccountType(accountType);
				ac.setAccountBalance(accountBalance);
				
				
				//Call Validation Function Here
				int eid=customerService.addAcHolderDetails(cust,ac);
				if(eid!=0)
				{
					System.out.println("Congratulations!! Your account has been created. \n");
					System.out.println("You new account number is : "+eid);
				}
				else
				{
					System.out.println("Account Creation Failed");
				}
				
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
			
			private static void  userSignUp(int accountId)
			{
				try{
					
					customerService=new BankingServiceImpl();
				
				
				System.out.println("-----------------------------");
				System.out.println("Enter User ID:");
				String userId=sc.next();
				System.out.println("Enter Login Password:");
				String loginPassword=sc.next();
				System.out.println("Enter Secret question:");
				String secretQuestion=sc.next();
				System.out.println("Enter Secret answer:");
				String secretAnswer=sc.next();
				System.out.println("Enter Transactional Password: ");
				String transactionPassword=sc.next();
				System.out.println("-----------------------------");
				
				UserTable user=new UserTable();
				user.setAccountId(accountId);
				user.setUserId(userId);
				user.setLoginPassword(loginPassword);
				//re-enter and validate password
				user.setSecretQuestion(secretQuestion);
				user.setSecretAnswer(secretAnswer);
				user.setTrasactionPassword(transactionPassword);
				//re-enter and validate password 
				//change it as transactionPin (int)
				
				
				
				
				
				
				//Call Validation Function Here
				String userTid=customerService.addUserDatabase(user);
				if(userId!=null)
				{
					System.out.println("Congratulations!! Your account has been created. \n");
					System.out.println("You User Id is : "+userTid);
				}
				else
				{
					System.out.println("Account Creation Failed");
				}
				
				}
				catch (Exception e) 
				{
					e.getMessage();
				}
			}
		
			private static boolean  adminLogin()
			{
				customerService=new BankingServiceImpl();
				System.out.println("Enter User Name: ");
				String user_name=sc.next();
				System.out.println("Enter Password: ");
				String password=sc.next();
				System.out.println("-----------------------------");
				return customerService.getAdminLogin(user_name,password);
				
			}
			
			private static boolean  customerLogin() throws BankingException 
			{
				customerService=new BankingServiceImpl();
				System.out.println("Enter User ID: ");
				String user_name=sc.next();
				System.out.println("Enter Password: ");
				String password=sc.next();
				System.out.println("-----------------------------");
				return customerService.getCustomerLogin(user_name,password);
				
			}
			
			public static void AcHolderMenu()
			 {
				
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
					System.out.println("7.Logout");
					System.out.println("________________________________");
					System.out.println("Select an option:");
					// accept option

					try {
						option = sc.nextInt();

						switch (option) {

						case 1:		viewStatementCustomer();					
						break;
						case 2:		changeMobileAddress();					
						break;
						case 3: 	requestForChequeBook();
						break;
						case 4: 	trackServiceRequestDetails();					
						break;
						case 5:		// fundTransfer();
						break;
						case 6: 	//changePwd();
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


			
			private static void  lockAccount() 
			{
				System.out.println("Your Account is locked.");
				do
				{
					System.out.println("1. Forgot password");
					System.out.println("2. Exit");
					
					int option = 0;
					try {
						option = sc.nextInt();

						switch (option) {

						case 1:		//	forgotPassword();					
									break;
						
						case 2: 	System.out.print("Exit Banking Application");
									System.exit(0);
									break;
						
						default:
							System.out.println("Enter a valid option[1-2]");
						}// end of switch
					}

					catch (InputMismatchException e) {
						sc.nextLine();
						System.err.println("Please enter a numeric value, try again");
						}
					
				}while(true);
				
			}
			
			
			private static void changeMobileAddress() 
			{
				
				System.out.println("---------------------------");
				System.out.println("Enter the account no:");
				int accountId=sc.nextInt();
				Customer customer=null;
				try 
				{	
					customer=customerService.fetchMobAddDetails(accountId);
					if(customer!=null){
					System.out.println("Existing Contact Details:");
					System.out.println("-------------------------------");
					System.out.println("Mobile No.: "+customer.getMobileNo());
					System.out.println("Address : "+customer.getAddress());
					System.out.println("-------------------------------");
					System.out.println("Enter new mobile no:");
					String mobno=sc.next();
					System.out.println("Enter new address:");
					String address=sc.next();
					if(customerService.updateMobAddDetails(mobno, address, accountId)!=0)
					System.out.println("New contact details updated");
					else
						{
						System.out.println("Updation Failed\n Please Retry!");
						System.out.println("-------------------------------------");
						}
					}
					else
						System.out.println("No details found");
				} 
				catch (Exception e) 
				{
					System.out.println("technical Problem occured");
				}
				
			}
			
			private static void requestForChequeBook()
			{
				System.out.println("Enter Account No: ");
				int accountId=sc.nextInt();
				
				//message if already requested
				
				try 
				{
					if(customerService.searchAccount(accountId))
					{
					int serviceId=customerService.requestChequeBook(accountId);
					System.out.println("Your cheque book request is approved and being processed.");
					System.out.println("Your service request id is: "+serviceId);
					}
					else
					{
						System.out.println("No such account exists.");
					}
				} 
				catch (Exception e) 
				{
					e.getMessage();
				}
				
			}
			
			private static void trackServiceRequestDetails()
			{
				
				System.out.println("Enter Service Id: ");
				int serviceId=sc.nextInt();
			
				ServiceTracker service=new ServiceTracker();
				try
				{
					service=customerService.getServiceDetail(serviceId);
					if(service==null)
					{
						System.out.println("-----------------------------------");
						System.out.println("No service requested on this ID");
						System.out.println("-----------------------------------");
						
					}
					else
					{
					System.out.println("Service_ID\tService_Description\t\tAccount_ID\tService_Raised_Date\tService_status");
					System.out.println(service.getServiceID()+"\t\t"+service.getService_Description()+"\t\t\t"+service.getAccount_ID()+"\t\t"+service.getService_Raised_Date()+"\t\t\t"+service.getService_status());
					}
				}
				catch(Exception e)
				{
					e.getMessage();
				}

			}
			
			private static void viewStatementCustomer()
			{
				int accountId;
				int option=0;
				System.out.println("Enter the type of statement you want to generate");
				System.out.println("1. View Mini Statement");
				System.out.println("2. View Detailed Statement");
				System.out.println("3. exit");
				
				try{
				option=sc.nextInt();
				
				switch(option)
				{
				case 1: 
						System.out.println("Enter Account No: ");
						accountId=sc.nextInt();
			
						ArrayList<Transaction> al1=new ArrayList<Transaction>();
						try
						{
								al1=customerService.getMiniStatement(accountId);
								System.out.println("Transaction_ID\tTransaction Description\t\tDate of Transaction\tTransaction Type\tTransaction Amount\tAccount No.");
								for(Transaction i:al1)
								{
										System.out.println(i.getTransaction_ID()+"\t\t"+i.getTran_description()+"\t\t\t"+i.getDateofTransaction()+"\t\t"+i.getTransactionType()+"\t\t\t"+i.getTranAmount()+"\t\t\t"+i.getAccount_No());
								}
						}catch(Exception e){
							e.getMessage();
						}
						
						break;
						
							
				case 2: 
						System.out.println("Enter Account No: ");
						accountId=sc.nextInt();
						System.out.println("Enter starting and ending date: ");
						//take input
						
						ArrayList<Transaction> al2=new ArrayList<Transaction>();
						try
						{
							al2=customerService.fetchDetailedStmnt();
							System.out.println("Transaction_ID\tTransaction Description\t\tDate of Transaction\tTransaction Type\tTransaction Amount\tAccount No.");
							for(Transaction i:al2)
							{
								System.out.println(i.getTransaction_ID()+"\t\t"+i.getTran_description()+"\t\t\t"+i.getDateofTransaction()+"\t\t"+i.getTransactionType()+"\t\t\t"+i.getTranAmount()+"\t\t\t"+i.getAccount_No());
							}
						}catch(Exception e){
							e.getMessage();
						}
						
						break;
						
				case 3:	return;
				
				default:
					System.out.println("Enter a valid option[1-3]");
				}// end of switch
			}

			catch (InputMismatchException e) {
				sc.nextLine();
				System.err.println("Please enter a numeric value, try again");
			}

						
						
				
				}
				
				

			}

}
