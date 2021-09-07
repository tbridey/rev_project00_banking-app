import java.util.Scanner;

public class Transaction {

	public void withdraw(Scanner scan, String user, Database data) {
		boolean cont = true;
		while(cont==true) {
			System.out.println("How much would you like to Withdraw?(no dollar sign)");
			
			double amount = scan.nextDouble();
			double existingAmount = data.customerList.get(user).getBalance();
			
			System.out.println("\nDATA STORED"+data.customerList.get(user).getBalance());
			
			if(amount <= existingAmount) {
				System.out.println("Is $"+amount+" Correct?");
				System.out.println("1.Yes");
				System.out.println("2.No");
				System.out.println("3.Back");
				int answer = scan.nextInt();
				if(answer == 1) {
				data.customerList.get(user).setNegativeBalance(amount);
					//System.out.println("set balance: $"+amount);
					//System.out.println("recorded balance: $"+data.customerList.get(user).getBalance());
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
	
	public void deposit(Scanner scan, String user, Database data) {
		boolean cont = true;
		while(cont==true) {
			System.out.println("How much would you like to deposit?(no dollar sign)");
			
			double amount = scan.nextDouble();
			double existingAmount = data.customerList.get(user).getBalance();
			//System.out.println("\nCORRECT DATA STORED");
			
			System.out.println("Is $"+amount+" Correct?");
			System.out.println("1.Yes");
			System.out.println("2.No");
			System.out.println("3.Back");
			int answer = scan.nextInt();
			if(answer == 1) {
				data.customerList.get(user).setPositiveBalance(amount);
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
	
	public void transfer() {
		
	}
}
