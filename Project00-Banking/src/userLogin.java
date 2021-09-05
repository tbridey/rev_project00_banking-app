import java.io.IOException;
import java.util.Scanner;

public class userLogin {
	
	private String userName;
	private String password;
	
	public String loginUser() throws IOException {
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("\n*************************");
		System.out.println("\nLOGIN");
		System.out.println("---------");
		System.out.println("\nUsername:");
		userName=scan.nextLine();
		
		//scan.close();
		
		return userName;
	}
	
	public String loginPass() throws IOException {
		
		Scanner scan=new Scanner(System.in);
		
		System.out.println("\nPassword:");
		password=scan.nextLine();
		
		//scan.close();
		
		return password;
	}
}
