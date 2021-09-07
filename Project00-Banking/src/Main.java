import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;




/*
 * Main initializes the program and introduces the menu.
 * main will loop until the program is quit by the user
 */
public class Main{
	
//	public static HashMap<String, Customer> customerList=new HashMap<String, Customer>();

	public static boolean quit = false;
	
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		//HashMap<String, Customer> customerList;
		
		Database data= new Database();
		
		FileDriver db=new FileDriver();
		
		db.readCustomer(data);
		
		Transaction trans=new Transaction();
		
		//System.out.println(data.customerList.entrySet());
		String un = null;
		String pw;
		do {
			char menu='m';
			MainMenu start = new MainMenu();
			start.printTopMenu(menu, un, data);
			int input = start.checkInput(scan);
			switch(input) {
			case 1:
				menu='p';
				CustomerCreator newCus=new CustomerCreator();
				newCus.register(data, scan);
				//System.out.println("Current customer list: "+data.customerList.entrySet());
			      
				
				//FileDriver newList=new FileDriver();
				//newList.write(data);
				
			break;
			case 2:
				menu='c';
				//Customer c=new Customer();
				userLogin ul=new userLogin();
				un = ul.loginUser();
				pw = ul.loginPass();
				// use this class to check for valid username 
				//and password
				Validator checker=new Validator();
				boolean x=checker.usernamePasswordCheck(data, un, pw);
				if(x == true) {
					
					boolean cont=true;
					while(cont==true) {
						start.printTopMenu(menu, un, data);
						
						int inputC = start.checkInput(scan);
						 
						switch(inputC) {
						case 1: trans.withdraw(scan, un, data); 
							break;
						case 2:trans.deposit(scan, un, data);
							break;
						case 3:break;
						case 4:break;
						case 5: cont=false;
							break;
						}
					}
					
				}
				else {
					System.out.println("\nERROR: invalid credentials");
				}
				
			break;
			case 3:
				menu='e';
				Employee e=new Employee();
				//e.login();
				//start.printTopMenu(menu, un);
				int inputE = start.checkInput(scan);
			break;
			case 4:
				menu='a';
				Admin a=new Admin();
				//a.login();
				//start.printTopMenu(menu, un);
				int inputA = start.checkInput(scan);
			break;
			case 5: System.out.println("Goodbye!");
				quit = true;
			}
			
//			if (input == 5) {
//				System.out.println("Goodbye!");
//				quit = true;
//			}
		
		}while(quit == false);
		db.writeCustomer(data.customerList);

	}

}
