import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class CustomerCreator {
	private String name;
	private String userName;
	private String password;
	private String SSN;
	private int accNum;
	private String state="open";
	private String type="Customer";
	
	Scanner scan=new Scanner(System.in);
	
	public void register(Database data) throws IOException {
		System.out.println("\n*************************");
		System.out.println("\nWhat is your first and last name?");
		name=scan.nextLine();
		System.out.println("\nSet your User-name and password");
		System.out.println("--------------------------------");
		System.out.println("\nUsername:");
		userName=scan.nextLine();
		System.out.println("\nPassword:");
		password=scan.nextLine();
		
		System.out.println("\nCredentials");
		System.out.println("------------");
		System.out.println("\nSocial Security Number");
		SSN=scan.nextLine();
		
		Random newNum=new Random();
		accNum=newNum.nextInt(1000000);
		
		
		System.out.println("Account Number: "+accNum);
		
		System.out.println("Thank you for registering!");
		
		Customer newCustomer=new Customer(name, userName, password, SSN, accNum, state, type);
		
		data.customerList.put(userName, newCustomer);
		
		FileDriver newList=new FileDriver();
		newList.write(data);
		
	
		//call save function from User()
		
		//scan.close();
		
	}
	
}
