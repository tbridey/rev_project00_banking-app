import java.io.IOException;
import java.io.Serializable;

public class Customer extends User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String type="customer";
	
	public Customer(String name, String use, String pass, String SSN, int acct, String state, String type) {
		this.setName(name);
		this.setUserName(use);
		this.setPassword(pass);
		this.setSSN(SSN);
		this.setAccNum(acct);
		this.type=type;
		this.state=state;
//		this.setBalance(0.00);
	}

	/*
	 * public char printCustomerMenu() { char m='c'; MainMenu menu=new MainMenu();
	 * menu.printTopMenu('c'); return m; }
	 */
	
}
