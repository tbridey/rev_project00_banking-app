
public class Account {
	private double balance=0.00;
	private int acctNum;
	//savings, checking, joint
	private String type;
	//open, closed. active
	private String state;
	
	public Account(int acctNum, double balance, String state, String type) {
		this.setAcctNum(acctNum);
		this.setBalance(balance);
		this.setState(state);
		this.setType(type);
	}

	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public int getAcctNum() {
		return acctNum;
	}
	public void setAcctNum(int acctNum) {
		this.acctNum = acctNum;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}

