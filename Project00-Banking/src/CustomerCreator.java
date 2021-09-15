import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class CustomerCreator implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String name;
	private String username;
	private String password;
	private String SSN;
	private String address;
	private String state = "open";
	private String type;
	private int accounts;
	
	
	//Scanner scan=new Scanner(System.in);
	
	public void register(Database data, Scanner scan) throws IOException {
		System.out.println("\n*************************");
		System.out.println("\nWhat is your first and last name?");
		//name=scan.next();
		name=scan.nextLine();
		System.out.println("\nSet your User-name and password");
		System.out.println("--------------------------------");
		System.out.println("\nUsername:");
		username=scan.nextLine();
		System.out.println("\nPassword:");
		password=scan.nextLine();
		
		System.out.println("\nCredentials");
		System.out.println("------------");
		System.out.println("\nLast four digits of your Social Security Number");
		SSN=scan.nextLine();
		
		System.out.println("\nHome address");
		address=scan.nextLine();
		
		System.out.println("\nWhat type of account?");
		System.out.println("----------------------");
		System.out.println("1. Checking");
		System.out.println("2. Savings");
		System.out.println("3. Joint");
		int choice = scan.nextInt();
		switch(choice) {
		case 1: type = "checking";
		break;
		case 2: type = "savings";
		break;
		case 3: type = "joint";
		break;
		}
		
		Random newNum=new Random();
		int accNum=newNum.nextInt(1000000000);
		
		CustomerOracleDAO dao=new CustomerOracleDAO();
		
		Account account = new Account(accNum, 00.0, state, type);
		
		List<Account> accounts = new ArrayList();
		accounts.add(account);
		
		Customer customer=new Customer(username, name, password, SSN, address, accounts);
		dao.createCustomer(customer, username, name, password, SSN, address);
		
		account.setAcctNum(accNum);
		dao.addAccount(account, username, state, type);
		System.out.println("\nAccount creation successful");
	}
	
	public void addAccount(Scanner scanner, Customer customerObj) {
		CustomerOracleDAO dao = new CustomerOracleDAO();
		Scanner scan = scanner;
		Customer custObj=customerObj;
		String user = custObj.getUsername();
		Account account=null;
		Random newNum=new Random();
		int accNum=newNum.nextInt(1000000000);
		double balance=0.00;
		String state="open";
		String type="";
		
		System.out.println("\nwhat type of account would you like to open?");
		System.out.println("---------------------------------------------");
		System.out.println("1. Checking");
		System.out.println("2. Savings");
		System.out.println("3. Joint");
		int option=scan.nextInt();
		
		switch(option) {
		case 1:
			balance=0.00;
			type="checking";
			//
			account=new Account(accNum, balance, state, type);
			custObj.accounts.add(account);
			dao.addAccount(account, user, state, type);
			break;
		case 2:
			balance=0.00;
			type="savings";
			//
			account=new Account(accNum, balance, state, type);
			custObj.accounts.add(account);
			dao.addAccount(account, user, state, type);
			break;
		case 3:
			createJointAccount(scan, custObj);
			break;
		}
		System.out.println("\nAccount creation successful");
	}
	public void createJointAccount(Scanner scanner, Customer customerObj) {
		Scanner scan=scanner;
		CustomerOracleDAO dao=new CustomerOracleDAO();
		Customer custObj1 = customerObj;
		Customer custObj2 = null;
		Validator validator = new Validator();
		String state="open";
		boolean cont=true;
		while(cont==true) {
			System.out.println("\nenter the joining accounts credentials");
			System.out.println("--------------------------------------");
			System.out.println("Username:");
			String user2=scan.nextLine();
			user2=scan.nextLine();
			System.out.println("input="+user2);
			System.out.println("Password:");
			String pass2=scan.nextLine();
			System.out.println("input="+pass2);
			System.out.println("create a joint account with "+user2+"?");
			int cont2=scan.nextInt();
			boolean userExists=validator.usernamePasswordCheck(user2, pass2);
			if (userExists==true) {
				//
				custObj2 = dao.setCustomerAccountObj(user2);
				//
				Random newNum=new Random();
				int accNum=newNum.nextInt(1000000000);
				Account jointAccount=new Account(accNum, 0.0, "open", "joint");
				//
				dao.addJointAccount(jointAccount, user2);
				dao.addJointAccount(jointAccount, custObj1.getUsername());
				//
				List<Account> newAccount = new ArrayList<Account>();
				newAccount.add(jointAccount);
				custObj2.setAccounts(newAccount);
				custObj1.setAccounts(newAccount);
				//
				System.out.println("\nAccount creation successful");
				cont=false;
			}
			else {
				System.out.println("ERROR: User not found");
				cont=false;
			}
		}
	}
	
}
