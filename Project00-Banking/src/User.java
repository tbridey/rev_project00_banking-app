
import java.io.Serializable;




public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String userName;
	private String password;
	private String SSN;
	private int accNum;
	public String state;
	public String type;
	private double balance=0.00;
	
	@Override
	public String toString() {
		String str = "User: "+name+" | #"+accNum+"\nBalance: $"+balance;
		return str;
		
	}
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void credCheck() {
		
	}
	public String getSSN() {
		return SSN;
	}
	public void setSSN(String sSN) {
		SSN = sSN;
	}
	public int getAccNum() {
		return accNum;
	}
	public void setAccNum(int accNum) {
		this.accNum = accNum;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	public double getBalance() {
		return balance;
	}


	public void setPositiveBalance(double balance) {
		this.balance += balance;
	}
	public void setNegativeBalance(double balance) {
		this.balance -= balance;
	}
}
