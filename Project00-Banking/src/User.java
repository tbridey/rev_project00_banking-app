
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;




public class User implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String name;
	private String username;
	private String password;
	private String SSN;
	private String address;
	protected List<Account> accounts = new ArrayList<Account>();
	
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String userName) {
		this.username = userName;
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
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


//	public double getBalance() {
//		double balance =userAcc.getBalance();
//		return balance;
//	}
//
//
//	public void setPositiveBalance(double balance) {
//		double newBalance =userAcc.getBalance();
//		newBalance+=balance;
//		userAcc.setBalance(newBalance);
//	}
//	public void setNegativeBalance(double balance) {
//		double newBalance =userAcc.getBalance();
//		newBalance-=balance;
//		userAcc.setBalance(newBalance);
//	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts2) {
		for(int i=0;i<accounts2.size();i++) {
			this.accounts.add(accounts2.get(i));
		}
	}
}
