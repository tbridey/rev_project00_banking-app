import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EmployeeOracleDAO implements EmployeeDAO{

	@Override
	public void updateUser(Customer cust, String user) {
		String userToUpdate=user;
		Customer customer=cust;
		final String query = "update customers set username=?, name=?, password=?, ssn_digits=?, address=? where username=?";
		try {
			Connection conn = DatabaseConnector.connector();
			
			PreparedStatement prepStmt=conn.prepareStatement(query);
			
			prepStmt.setString(1, customer.getUsername());
			prepStmt.setString(2, customer.getName());
			prepStmt.setString(3, customer.getPassword());
			prepStmt.setInt(4, Integer.parseInt(customer.getSSN()));
			prepStmt.setString(5, customer.getAddress());
			prepStmt.setString(6,userToUpdate);
			
			prepStmt.executeUpdate();
			
		}catch(SQLException e){
			System.out.println("ERROR: SQL exception");
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void updateJointBalance(Account acct) {
		Account account= acct;
		final String query = "update joint set account_balance=? where account_num=?";
		try {
			Connection conn = DatabaseConnector.connector();
			
			PreparedStatement prepStmt=conn.prepareStatement(query);
			
			prepStmt.setDouble(1, account.getBalance());
			prepStmt.setInt(2, account.getAcctNum());
			
			prepStmt.executeUpdate();
			
		}catch(SQLException e){
			System.out.println("ERROR: SQL exception");
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateBalance(Account acct){
		
		Account account= acct;
		final String query = "update accounts set account_balance=? where account_num=?";
		try {
			Connection conn = DatabaseConnector.connector();
			
			PreparedStatement prepStmt=conn.prepareStatement(query);
			
			prepStmt.setDouble(1, account.getBalance());
			prepStmt.setInt(2, account.getAcctNum());
			
			prepStmt.executeUpdate();
			
		}catch(SQLException e){
			System.out.println("ERROR: SQL exception");
			e.printStackTrace();
		}
	}
	@Override

	public void updateAccountState(Account account, String state) {
		final String query = "update accounts set account_state=? where account_num=?";
		try {
			Connection conn = DatabaseConnector.connector();
			
			PreparedStatement prepStmt=conn.prepareStatement(query);
			
			prepStmt.setString(1, state);
			prepStmt.setInt(2, account.getAcctNum());
			
			prepStmt.executeUpdate();
			
		}catch(SQLException e){
			System.out.println("ERROR: SQL exception");
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<String> getAllData(String username) {
		// TODO Auto-generated method stub
		try {
			
			ArrayList<String> list=new ArrayList<String>();
			
			Connection conn = DatabaseConnector.connector();
			Statement stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from customers where username='"+username+"'");
			while(rs.next()) {
				list.add(rs.getString(1));
				list.add(rs.getString(2));
				list.add(rs.getString(3));
				list.add(Integer.toString(rs.getInt(4)));
				list.add(rs.getString(5));
			}
			return list;
			
		}catch(SQLException e){
			System.out.println("ERROR: SQL exception");
			e.printStackTrace();
			return null;
		}
		
	}

	@Override
	public HashMap<String, String> getAccounts(String username) {
		try {
			
			HashMap<String, String> list=new HashMap<String, String>();
			
			Connection conn = DatabaseConnector.connector();
			Statement stmt=conn.createStatement();
			
			ResultSet rs=stmt.executeQuery("select * from Accounts where username='"+username+"'");
										 
			int i=1;
			while(rs.next()) {
				list.put("accountNumber"+i, Integer.toString(rs.getInt(1)));
				list.put("accountBalance"+i, Double.toString(rs.getInt(2)));
				list.put("username", rs.getString(3));
				list.put("accountState"+i, rs.getString(4));
				list.put("accountType"+i,rs.getString(5));
				i++;
			}
			return list;
			
		}catch(SQLException e){
			System.out.println("ERROR: SQL exception");
			e.printStackTrace();
			return null;
		}
		
	}
	
	@Override
	public void removeAccount(int accountNum) {
		String query = "delete from accounts where account_num=?";
		try {
			Connection conn = DatabaseConnector.connector();
		
			PreparedStatement prepStmt=conn.prepareStatement(query);
			
			prepStmt.setInt(1, accountNum);
	
			prepStmt.executeUpdate();
			
			
		}catch(SQLException e){
			System.out.println("ERROR: SQL exception");
			e.printStackTrace();
		}
	}
	@Override
	public void addJointAccount(Account account, String username) {
		String query = "insert into joint (account_num, username, account_balance, account_state)"+"values(?, ?, ?, ?)";
		try {
			Connection conn = DatabaseConnector.connector();
			
			PreparedStatement prepStmt=conn.prepareStatement(query);
			
			prepStmt.setInt(1, account.getAcctNum());
			prepStmt.setString(2, username);
			prepStmt.setDouble(3, account.getBalance());
			prepStmt.setString(4, account.getState());
			
			prepStmt.executeUpdate();
			
			
		}catch(SQLException e){
			System.out.println("ERROR: SQL exception");
			e.printStackTrace();
		}
	}

	@Override
	public Employee setEmployeeObj(String username) {
		try {
			Employee employee=null;
			Connection conn = DatabaseConnector.connector();
			Statement stmt=conn.createStatement();	
			//
			ResultSet rs=stmt.executeQuery("select * from employees where username='"+username+"'");
			
			while(rs.next()) {
				String user=rs.getString(1);
				String name=rs.getString(2);
				String pass=rs.getString(3);
				String ssn=(Integer.toString(rs.getInt(4)));
				String address=rs.getString(5);
				String admin=rs.getString(6);
			
				employee=new Employee(user, name, pass, ssn, address, admin);
				}
				return employee;
				
		}catch(SQLException e){
			System.out.println("ERROR: SQL exception");
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Account> getAccountByState(String accountState) {
		try {
			String query="select * from accounts where account_state=?";
			Connection conn = DatabaseConnector.connector();
			
			PreparedStatement prepStmt=conn.prepareStatement(query);
			
			prepStmt.setString(1, accountState);
	
			ResultSet rs=prepStmt.executeQuery();
			
			ArrayList<Account> accountList=new ArrayList<Account>();
			
			while(rs.next()) {
				int acctNum=rs.getInt(1);
				double balance=rs.getDouble(2);
				String state=rs.getString(4);
				String type=rs.getString(5);
				Account account=new Account(acctNum, balance, state, type);
				accountList.add(account);
//				account.add(Integer.toString(rs.getInt(1)));
//				account.add(Integer.toString(rs.getInt(2)));
//				account.add(rs.getString(3));
//				account.add(rs.getString(4));
//				account.add(rs.getString(5));
//				accountList.add(account);
			}
			return accountList;
		
		}catch(SQLException e){
			System.out.println("ERROR: SQL exception");
			e.printStackTrace();
			return null;
		}
	}
	@Override
	public Account setAccountObj(int accountNumber) {
		try {
			Connection conn = DatabaseConnector.connector();
			Statement stmt=conn.createStatement();	
			//
			ResultSet rs=stmt.executeQuery("select * from accounts where account_number='"+accountNumber+"'");
			int acctNum=0;
			double balance=0;
			String state="";
			String type="";
			while(rs.next()) {
				acctNum=rs.getInt(1);
				balance=rs.getDouble(2);
				state=rs.getString(4);
				type=rs.getString(5);
			}
				
			Account account=new Account(acctNum, balance, state, type);
			
			return account;
	}catch(SQLException e){
		System.out.println("ERROR: SQL exception");
		e.printStackTrace();
		return null;
	}
		
	}
}
