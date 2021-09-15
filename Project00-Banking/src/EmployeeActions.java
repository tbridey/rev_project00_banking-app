import java.util.List;
import java.util.Scanner;

public class EmployeeActions {

	/*
	 *  -will find user by name and display all associated accounts and data.
	 *  -call Transaction() for depositing or withdrawing from the chosen account if 
	 */
	public void searchUser(Scanner scan, Employee empObj) {
		//System.out.println(empObj);
		EmployeeOracleDAO empDao=new EmployeeOracleDAO();
		CustomerOracleDAO cusDao=new CustomerOracleDAO();
		boolean cont=true;
		while(cont==true) {
			System.out.println("\nCustomer search");
			System.out.println("----------------");
			System.out.println("\nWhat is the Customer's Username?");
			System.out.println("Username:");
			String username=scan.nextLine();
			
			Customer custObj=cusDao.setCustomerAccountObj(username);
			if(custObj!=null) {
				
				List<Account> custAccts= custObj.getAccounts();
				
				System.out.println("\nWhat actions would you like to preform with "+custObj.getUsername()+"?");
				System.out.println("---------------------------------------");
				String permissions=empObj.getAdmin();
				if(permissions==null) {
					permissions="none";
				}
				switch(permissions) {
				case "admin": System.out.println("a. Account Transactions");
					System.out.println("v. View Details");
					System.out.println("b. Back");
				break;
				default: 
					System.out.println("v. View Details");
					System.out.println("b. Back");
					break;
				}
				String choice=scan.nextLine();
				switch(choice) {
				case "a":
					if(empObj.getAdmin().equals("admin")) {
						Transaction trans=new Transaction();
						System.out.println("Select the account:");
						System.out.println("-------------------");
						  for(int i=0;i<custAccts.size();i++) {
								System.out.println((i+1)+". "+custAccts.get(i).getType()
										+" #"+custAccts.get(i).getAcctNum());
							}
						  System.out.println("0. Back");
						  Account account=null;
						  int choice2=scan.nextInt();
						  switch(choice2) {
						  case 1: 
							  account=custAccts.get(0);
						  break;
						  case 2: 
							  account=custAccts.get(1);
						  break;
						  case 3: 
							  account=custAccts.get(2);
							  break;
						  case 0: cont=false;
						  }
						  
						  System.out.println("\n"+account.getType()+" #"+account.getAcctNum()+" actions");
						  System.out.println("--------------------------");
						  System.out.println("1. Withdraw");
						  System.out.println("2. Deposit");
						  System.out.println("3. Transfer");
						  int choice3 = scan.nextInt();
						  
						  if(choice3==1) {
							  trans.withdraw(scan, account);
							  cont=false;
						  }
						  else if(choice3==2) {
							  trans.deposit(scan, account);
							  cont=false;
						  }
						  else if(choice3==2) {
							  trans.transfer(scan, custObj);
							  cont=false;
						  }
					}else {
						System.out.println("returning...");
						cont=false;
					}
					break;
				case "v":
					System.out.println("Name: "+custObj.getName());
					System.out.println("Username: "+custObj.getUsername());
					System.out.println("password: "+custObj.getPassword());
					System.out.println("SSN(last four digits): "+custObj.getSSN());
					System.out.println("Address: "+custObj.getAddress());
					System.out.println("Accounts: ");
					for(int i=0;i<custAccts.size();i++){
						System.out.println(i+1+")");
						System.out.println("    "+custAccts.get(i).getType());
						System.out.println("    "+custAccts.get(i).getAcctNum());
						System.out.println("    $"+custAccts.get(i).getBalance());
						System.out.println("    "+custAccts.get(i).getState());
					}
					cont=false;
				case "b": System.out.println("returning...");
					cont=false;
				}
			}
		}
	}
	/*
	 * -will display a list of accounts that are open for review with attached name
	 * -account status can be changed
	 */
	public void viewApplicationsByState(Scanner scan, Employee empObj) {
		EmployeeOracleDAO empDao = new EmployeeOracleDAO();
		String state="open";
		//
		boolean contOuter = true;
		while(contOuter==true) {
			String permissions=empObj.getAdmin();
			if(permissions==null) {
				permissions="none";
			}
			if(permissions.equals("none")) {
				List<Account> openAccounts=empDao.getAccountByState(state);
				if(openAccounts==null) {
					System.out.println("No current acounts are "+state);
					contOuter=false;
				}
				else {
					for(int i=0;i<openAccounts.size();i++) {
						System.out.println((i+1)+" | "+openAccounts.get(i).getAcctNum()+" | "+openAccounts.get(i).getBalance()+" | "+openAccounts.get(i).getType()+" | "+openAccounts.get(i).getState());
					}
					System.out.println("Select account to set it to 'active' or '0' to go back");
					int choice=scan.nextInt();
					  switch(choice) {
					  case 1:
						  empDao.updateAccountState(openAccounts.get(0), "active");
						  contOuter=false;
					  break;
					  case 2:
						  empDao.updateAccountState(openAccounts.get(1), "active");
						  contOuter=false;
					  break;
					  case 3:
						  empDao.updateAccountState(openAccounts.get(2), "active");
						  contOuter=false;
					  break;
					  case 4:
						  empDao.updateAccountState(openAccounts.get(3), "active");
						  contOuter=false;
					  break;
					  case 5:
						  empDao.updateAccountState(openAccounts.get(4), "active");
						  contOuter=false;
					  break;
					  case 6:
						  contOuter=false;
					  break;
					  }
					 break;
				}
			}
			else if(permissions.equals("admin")){
				System.out.println("Which accounts would you like to see?");
				System.out.println("1. Open");
				System.out.println("2. Closed");
				System.out.println("3. Active");
				System.out.println("0. Back");
				int selection=scan.nextInt();
				switch(selection) {
				case 2: state="closed";
				break;
				case 3: state="active";
				break;
				case 0: contOuter=false;
				}
			}
		List<Account> accountsList=empDao.getAccountByState(state);
		if(accountsList==null) {
			System.out.println("No current acounts are "+state);
			contOuter=false;
		}
		else {
			 for(int i=0;i<accountsList.size();i++) {
					System.out.println((i+1)+" | "+accountsList.get(i).getAcctNum()+" | "+accountsList.get(i).getBalance()+" | "+accountsList.get(i).getType()+" | "+accountsList.get(i).getState());
				}
			  System.out.println("Select account to change its state or '0' to go back");
			  
			  Account account=null;
			  //
			  boolean contInner=true;
			  while(contInner==true) {
				  int choice=scan.nextInt();
				  switch(choice) {
				  case 1:
					  System.out.println("Will you be setting the new state to:");
					  System.out.println("1. Open");
					  System.out.println("2. Closed");
					  System.out.println("3. Active");
					  int action=scan.nextInt();
					  if(action==1){
						  state="open";
						  empDao.updateAccountState(accountsList.get(0), state);
					  }
					  else if(action==2){
						  state="closed";
						  empDao.updateAccountState(accountsList.get(0), state);
					  }
					  else if(action==3){
						  state="active";
						  empDao.updateAccountState(accountsList.get(0), state);
					  }
					  contInner=false;
				  break;
				  case 2:
					  System.out.println("Will you be setting the new state to:");
					  System.out.println("1. Open");
					  System.out.println("2. Closed");
					  System.out.println("3. Active");
					  int action2=scan.nextInt();
					  if(action2==1){
						  state="open";
						  empDao.updateAccountState(accountsList.get(1), state);
					  }
					  else if(action2==2){
						  state="closed";
						  empDao.updateAccountState(accountsList.get(1), state);
					  }
					  else if(action2==3){
						  state="active";
						  empDao.updateAccountState(accountsList.get(1), state);
					  }
					  contInner=false;
				  break;
				  case 3:
					  System.out.println("Will you be setting the new state to:");
					  System.out.println("1. Open");
					  System.out.println("2. Closed");
					  System.out.println("3. Active");
					  int action3=scan.nextInt();
					  if(action3==1){
						  state="open";
						  empDao.updateAccountState(accountsList.get(2), state);
					  }
					  else if(action3==2){
						  state="closed";
						  empDao.updateAccountState(accountsList.get(2), state);
					  }
					  else if(action3==3){
						  state="active";
						  empDao.updateAccountState(accountsList.get(2), state);
					  }
					  contInner=false;
				  break;
				  case 4:
					  System.out.println("Will you be setting the new state to:");
					  System.out.println("1. Open");
					  System.out.println("2. Closed");
					  System.out.println("3. Active");
					  int action4=scan.nextInt();
					  if(action4==1){
						  state="open";
						  empDao.updateAccountState(accountsList.get(3), state);
					  }
					  else if(action4==2){
						  state="closed";
						  empDao.updateAccountState(accountsList.get(3), state);
					  }
					  else if(action4==3){
						  state="active";
						  empDao.updateAccountState(accountsList.get(3), state);
					  }
					  contInner=false;
				  break;
				  case 5:
					  System.out.println("Will you be setting the new state to:");
					  System.out.println("1. Open");
					  System.out.println("2. Closed");
					  System.out.println("3. Active");
					  int action5=scan.nextInt();
					  if(action5==1){
						  state="open";
						  empDao.updateAccountState(accountsList.get(4), state);
					  }
					  else if(action5==2){
						  state="closed";
						  empDao.updateAccountState(accountsList.get(4), state);
					  }
					  else if(action5==3){
						  state="active";
						  empDao.updateAccountState(accountsList.get(4), state);
					  }
					  contInner=false;
				  break;
				  case 0: contInner=false;
				  contOuter=false;
				  break;
				  }
				  break;
			  }
			}
		}
	}
	/*
	 * if admin, the account can be closed and removed from the database
	 */
	public void closeAccount(Scanner scan) {
		EmployeeOracleDAO dao=new EmployeeOracleDAO();
		boolean contOuter=true;
		while(contOuter==true) {
			boolean contInner=true;
			while(contInner==true) {
				System.out.println("\nEnter the account number of the closing account:");
				System.out.println("------------------------------------------------");
				System.out.println("Account number:");
				int accountNum=scan.nextInt();
				System.out.println("\nAre you sure you wish to remove "+accountNum+" from the records?\n(This is irriversable");
				System.out.println("1. Yes, continue");
				System.out.println("2. No, re-enter the account number");
				System.out.println("3. No, quit this menu");
				int choice=scan.nextInt();
				switch(choice) {
				case 1:
					System.out.println("removing account...");
					dao.removeAccount(accountNum);
					System.out.println("account removed");
					contInner=false;
					contOuter=false;
					break;
				case 2:
					contInner=false;
					break;
				case 3:
					contInner=false;
					contOuter=false;
					break;
				}
			}
		}
	}	
}