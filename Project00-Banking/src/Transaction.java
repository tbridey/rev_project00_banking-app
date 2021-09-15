import java.util.List;
import java.util.Scanner;

public class Transaction {

	CustomerOracleDAO dao=new CustomerOracleDAO();

	public void withdraw(Scanner scan, Account acct) {
		Account account = acct;
		boolean cont = true;
		while(cont==true) {
			System.out.println("How much would you like to Withdraw?(no dollar sign)");
			
			double withdraw = scan.nextDouble();
			double principle = account.getBalance();
			
			//System.out.println("\nDATA STORED"+account.getBalance());
			
			if(withdraw <= principle) {
				System.out.println("Is $"+withdraw+" Correct?");
				System.out.println("1.Yes");
				System.out.println("2.No");
				System.out.println("3.Back");
				int answer = scan.nextInt();
				if(answer == 1) {
					principle-=withdraw;
					account.setBalance(principle);
					
					switch(account.getType()) {
					case "joint":
						dao.updateJointBalance(account);
						System.out.println("Withdrawl completed successfully");
						break;
					default:
						dao.updateBalance(account);
						System.out.println("Withdrawl completed successfully");
					}
					cont=false;
				}
				else if(answer == 2){
					cont = true;
				}
				else {
					cont = false;
				}
			}
			else{
				System.out.println("ERROR: insufficient funds");
				
			}
		}
	}	
	
	public void deposit(Scanner scan, Account acct) {
		Account account = acct;
		boolean cont = true;
		while(cont==true) {
			System.out.println("How much would you like to deposit?(no dollar sign)");
			
			double deposit = scan.nextDouble();
			double principle = account.getBalance();
			//System.out.println("\nCORRECT DATA STORED");
			
			System.out.println("Is $"+deposit+" Correct?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			System.out.println("3.Back");
			int answer = scan.nextInt();
			if(answer == 1) {
				principle+=deposit;
				account.setBalance(principle);
				
				switch(account.getType()) {
				case "joint":
					dao.updateJointBalance(account);
					System.out.println("Deposit completed successfully");
					break;
				default:
					dao.updateBalance(account);
					System.out.println("Deposit completed successfully");
				}
				cont=false;
			}
			else if(answer == 2){
				cont = true;
			}
			else {
				cont=false;
			}
			
		}
	}
	
	public void transfer(Scanner scanner, Customer customerObj) {
		//System.out.println(custObj.getAccounts().get(0).getType());
		Scanner scan = scanner;
		Customer custObj = customerObj;
		List<Account> custAccts = custObj.getAccounts();
		Account account1=null;
		Account account2=null;
		boolean cont = true;
		while(cont==true) {
			
			System.out.println("Which account will you transfer FROM:");
			for(int i=0;i<custAccts.size();i++) {
				System.out.println((i+1)+". "+custAccts.get(i).getType()
						+" #"+custAccts.get(i).getAcctNum());
			}
			
			 int from=scan.nextInt();
			  switch(from) {
			  case 1: account1=custAccts.get(0);
			  break;
			  case 2: account1=custAccts.get(1);
			  break;
			  case 3: account1=custAccts.get(2);
			  break;
			  }
			  System.out.println("Which account will you transfer TO:");
			  int to=scan.nextInt();
			  switch(to) {
			  case 1: account2=custAccts.get(0);
			  break;
			  case 2: account2=custAccts.get(1);
			  break;
			  case 3: account2=custAccts.get(2);
			  break;
			  }
			  
			System.out.println("How much would you like to transfer from *"+account1.getType()+"* to *"+account2.getType()+"*? (no dollar sign)");
			double transfer = scan.nextDouble();
			double principle1 = account1.getBalance();
			double principle2 = account2.getBalance();
			//System.out.println("\nCORRECT DATA STORED");
			
			System.out.println("Is $"+transfer+" Correct?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			System.out.println("3.Back");
			int answer = scan.nextInt();
			if(answer == 1) {
				principle1-=transfer;
				account1.setBalance(principle1);
				principle2+=transfer;
				account2.setBalance(principle2);
				switch(account1.getType()) {
				case "joint":
					dao.updateJointBalance(account1);
					System.out.println("Transfer completed successfully");
					break;
				default:
					dao.updateBalance(account1);
					System.out.println("Transfer completed successfully");
				}
				System.out.println("Transfer completed successfully");
				switch(account2.getType()) {
				case "joint":
					dao.updateJointBalance(account2);
					System.out.println("Transfer completed successfully");
					break;
				default:
					dao.updateBalance(account2);
					System.out.println("Transfer completed successfully");
				}
				cont=false;
			}
			else if(answer == 2){
				cont = true;
			}
			else {
				cont=false;
			}
			
		}
	}
}
