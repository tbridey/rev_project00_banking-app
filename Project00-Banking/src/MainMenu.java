import java.util.Scanner;

/*
 * prints the main menu to the console and checks against incorrect input
 */
public class MainMenu {

	Scanner scan = new Scanner(System.in);
	
	/*
	 *  print the menu specified by the return
	 *  m=main
	 *  c=customer
	 *  e=employee
	 */
	public void printTopMenu(char m) {
		Database list = new Database();
		switch(m) {
			case 'm': System.out.println("*************************");
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
				System.out.println("4. Admin log-in");
				System.out.println("5. Quit");
			break;
			case 'c': System.out.println("*************************");
					  System.out.println("        Welcome!         ");
					  System.out.println("*************************");
					  System.out.println(list.customerList);
					  System.out.println("What would you like to do?");
					  System.out.println("--------------------------");
					  System.out.println("1. Withdraw");
					  System.out.println("2. Deposit");
					  System.out.println("3. Transfer");
					  System.out.println("4. Open a Joint Acct. ");
			break;
			case 'e': System.out.println("*************************");
			  System.out.println("        Welcome!         ");
			  System.out.println("*************************");
			  System.out.println("What would you like to do?");
			  System.out.println("--------------------------");
			  System.out.println("1. Find/View Account");
			  System.out.println("2. View Open Applications");

			  break;
			case 'a': System.out.println("*************************");
			  System.out.println("        Welcome!         ");
			  System.out.println("*************************");
			  System.out.println("What would you like to do?");
			  System.out.println("--------------------------");
			  System.out.println("1. Find/View Account");
			  System.out.println("2. View Open Applications");
			  break;
			case 'p': System.out.println("*************************");
			  System.out.println("        Welcome!         ");
			  System.out.println("*************************");
			  System.out.println("Input");
			  System.out.println("--------------------------");
			  System.out.println("1. Find/View Account");
			  System.out.println("2. View Open Applications");
			  break;
			
		}
	}
	
	//print sub menu
	public void printSubMenu(int menuType) {
		switch(menuType) {
		case 1:break; //customer account balance/account info
		case 2:break; //find customer
		case 3:break; //employee/admin customer info (balance, account info, personal info)
		case 4:break; //open applications
		}
	}
	
	// scan for and check the input
	public int checkInput() {
		int input = scan.nextInt();
		return input;
	}
	
}

	

