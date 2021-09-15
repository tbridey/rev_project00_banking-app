import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.sql.*;
/*
 * prints the main menu to the console and checks against incorrect input
 */
public class MainMenu {

	int option;
	
	/*
	 *  print the menu specified by the return
	 *  m=main
	 *  c=customer
	 *  e=employee
	 */
	public void printMain() {
			System.out.println("\n*************************");
			System.out.println("     SUPER COOL BANK     ");
			System.out.println("*************************");
			System.out.println("Welcome to Super Cool Banking!");
			System.out.println("\n");
			System.out.println("MAIN MENU");
			System.out.println("---------");
			//System.out.println("\n");
			System.out.println("1. Account Application");
			System.out.println("2. Customer log-in");
			System.out.println("3. Employee log-in");
			System.out.println("5. Quit");
	}
	public Account printRunCustomer(Scanner scanner, Customer custObj) 
	{
		
		Scanner scan=scanner;
		Account account = null;
		//CustomerOracleDAO dao=new CustomerOracleDAO();
	
		System.out.println("\n*************************");
		System.out.println("        Welcome!         ");
		System.out.println("*************************");

	  	System.out.println("Welcome "+custObj.getName()+"!");
	  	System.out.println("\n");
	  	List<Account> custAccts= custObj.getAccounts();
		  	
		for(int i=0;i<custAccts.size();i++) {
			System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
			System.out.println("--- "+custAccts.get(i).getType()
			+": $"+custAccts.get(i).getBalance()
					+"\n--- Account Number: "+custAccts.get(i).getAcctNum());
		}
		System.out.println("+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+-+");
			
	  System.out.println("\nWhat would you like to do?");
	  System.out.println("--------------------------");
	  for(int i=0;i<custAccts.size();i++) {
			System.out.println((i+1)+". "+custAccts.get(i).getType()
					+" #"+custAccts.get(i).getAcctNum());
		}
	  System.out.println("9. Open another account ");
	  System.out.println("0. Back to Main menu");
	  
	  int choice=scan.nextInt();
	  switch(choice) {
	  case 1: account=custAccts.get(0);
	  option=1;
	  break;
	  case 2: account=custAccts.get(1);
	  option=1;
	  break;
	  case 3: account=custAccts.get(2);
	  option=1;
	  break;
	  case 9:option=2;
	  break;
	  case 0:option=3;
	  break;
	  }
	return account;
	}
			
	
	//print sub menu
	public void printRunEmployee(Scanner scan, Employee empObj) {
		System.out.println("\n*************************");
		System.out.println("        Welcome!         ");
		System.out.println("*************************");

	  	System.out.println("Welcome "+empObj.getName()+"!");
	  	System.out.println("\n");
	  	System.out.println("\nWhat would you like to do?");
		System.out.println("---------------------------");
		System.out.println("1. Search for Customer");
		System.out.println("2. View pending applications/closed accounts");
		String permissions=empObj.getAdmin();
		if(permissions==null) {
			permissions="none";
		}
		if(permissions.equals("admin")) {
			System.out.println("3. Remove account from records");
		}
		System.out.println("0. Back to Main menu");
		int choice=scan.nextInt();
		  switch(choice) {
		  case 1: option=1;
		  break;
		  case 2: option=2;
		  break;
		  case 3: option=3;
		  break;
		  case 0:option=3;
		  break;
		  }
	}
	
	// scan for and check the input
	public int checkInput(Scanner scan) {
		int input = scan.nextInt();
		scan.nextLine();
		//System.out.println(input);
		return input;
	}
	
}

	

