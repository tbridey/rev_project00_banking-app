import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;




/*
 * Main initializes the program and introduces the menu.
 * main will loop until the program is quit by the user
 */
public class Main{
	static final String user= "admin";
	static final String password= "12345678";
	static final String db_url="jdbc:oracle:thin:@database-1.cncgozgp4gc8.us-east-2.rds.amazonaws.com:1521:ORCL";
	
//	public static HashMap<String, Customer> customerList=new HashMap<String, Customer>();

	public static boolean quit = false;
	
	public static void main(String[] args) throws IOException {
		
		Scanner scan = new Scanner(System.in);
		
		//HashMap<String, Customer> customerList;
		
		Database data= new Database();
		
		FileDriver db=new FileDriver();
		
		db.readCustomer(data);
		CustomerCreator newCus=new CustomerCreator();
		
		Transaction trans=new Transaction();
		
		//System.out.println(data.customerList.entrySet());
		String un = null;
		String pw;
		do {
			MainMenu start = new MainMenu();
			start.printMain();
			int input = start.checkInput(scan);
			switch(input) {
			case 1:
				newCus.register(data, scan);
			break;
			case 2:
				//Customer c=new Customer();
				userLogin ul=new userLogin();
				un = ul.loginUser();
				pw = ul.loginPass();
				// use this class to check for valid username 
				//and password
				Validator checker=new Validator();
				boolean x=checker.usernamePasswordCheck(un, pw);
				if(x == true) {
					
					boolean cont=true;
					
					//create customer object
					//System.out.println("un="+un);
					CustomerOracleDAO dao = new CustomerOracleDAO();
					Customer custObj=dao.setCustomerAccountObj(un);
					
					
					while(cont==true) {
						Account account=start.printRunCustomer(scan, custObj);
						int option=start.option;
						switch(option) {
						case 1:
							System.out.println("\n"+account.getType()+" #"+account.getAcctNum()+" actions");
							System.out.println("--------------------------");
							System.out.println("1. Withdraw");
							System.out.println("2. Deposit");
							System.out.println("3. Transfer");
							
							int inputC = scan.nextInt();
							 
							switch(inputC) {
							case 1: trans.withdraw(scan, account); 
								break;
							case 2:trans.deposit(scan, account);
								break;
							case 3:trans.transfer(scan, custObj);
								break;
							
							}
							break;
						case 2: newCus.addAccount(scan, custObj);
						break;
						case 3:
							cont=false;
							break;
						}
					}
					
				}
				else {
					System.out.println("\nERROR: invalid credentials");
				}
				
			break;
			case 3:
				//e.login();
				userLogin empLog=new userLogin();
				un = empLog.loginUser();
				pw = empLog.loginPass();
				// use this class to check for valid username 
				//and password
				Validator checker2=new Validator();
				boolean y=checker2.employeeLoginCheck(un, pw);
				if(y == true) {
					
					boolean cont=true;
					
					EmployeeOracleDAO dao2 = new EmployeeOracleDAO();
					Employee empObj=dao2.setEmployeeObj(un);
					System.out.println(empObj);
					EmployeeActions action=new EmployeeActions();
					
					while(cont==true) {
						start.printRunEmployee(scan, empObj);
						int option=start.option;
						switch(option) {
						case 1:	
							action.searchUser(scan, empObj);
						break;
						case 2:
							action.viewApplicationsByState(scan, empObj);
						break;
						case 3:
							cont=false;
						break;
						}
					}
					
				}
				else {
					System.out.println("\nERROR: invalid credentials");
				}
				
			break;
			case 4:
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
