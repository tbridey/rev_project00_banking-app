import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class Customer extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String type="customer";
	
	public Customer(String use, String name, String pass, String SSN, String address, List<Account> accounts) {
		this.setName(name);
		this.setUsername(use);
		this.setPassword(pass);
		this.setSSN(SSN);
		this.setAddress(address);
		this.setAccounts(accounts);
//		this.setBalance(0.00);
	}


	/*
	 * public char printCustomerMenu() { char m='c'; MainMenu menu=new MainMenu();
	 * menu.printTopMenu('c'); return m; }
	 */
	
}
