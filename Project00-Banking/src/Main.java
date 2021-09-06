import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;


/*
 * Main initializes the program and introduces the menu.
 * main will loop until the program is quit by the user
 */
public class Main{
	
//	public static HashMap<String, Customer> customerList=new HashMap<String, Customer>();

	public static boolean quit = false;
	
	public static void main(String[] args) throws IOException {
		
		//Scanner scan = new Scanner(System.in);
		
		//HashMap<String, Customer> customerList;
		
		Database data= new Database();
		
		do {
			char menu='m';
			MainMenu start = new MainMenu();
			start.printTopMenu(menu);
			int input = start.checkInput();
			switch(input) {
			case 1:
				menu='p';
				CustomerCreator newCus=new CustomerCreator();
				newCus.register(data);
				System.out.println("Current customer list: "+data.customerList.entrySet());
			      
				
				//FileDriver newList=new FileDriver();
				//newList.write(data);
				
			break;
			case 2:
				menu='c';
				//Customer c=new Customer();
				userLogin ul=new userLogin();
				String un = ul.loginUser();
				String pw = ul.loginPass();
				// use this class to check for valid username 
				//and password
				Validator checker=new Validator();
				boolean x=checker.usernamePasswordCheck(data, un, pw);
				if(x == true) {
					start.printTopMenu(menu);
				}
				else {
					System.out.println("\nERROR: invalid credentials");
				}
				int inputC = start.checkInput();
			break;
			case 3:
				menu='e';
				Employee e=new Employee();
				//e.login();
				start.printTopMenu(menu);
				int inputE = start.checkInput();
			break;
			case 4:
				menu='a';
				Admin a=new Admin();
				//a.login();
				start.printTopMenu(menu);
				int inputA = start.checkInput();
			break;
			case 5: System.out.println("Goodbye!");
				quit = true;
			}
			
//			if (input == 5) {
//				System.out.println("Goodbye!");
//				quit = true;
//			}
		
		}while(quit == false);

	}

}
