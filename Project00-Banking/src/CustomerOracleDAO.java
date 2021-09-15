import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CustomerOracleDAO implements CustomerDAO{

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
	public void createCustomer(Customer customer, String username, String name, String password, String SSN, String address) {
		// TODO Auto-generated method stub
		final String query = "insert into customers (username, name, password, ssn_digits, address)"+"values(?, ?, ?, ?, ?)";
		try {
			Connection conn = DatabaseConnector.connector();
			
			PreparedStatement prepStmt=conn.prepareStatement(query);
			
			prepStmt.setString(1, customer.getUsername());
			prepStmt.setString(2, customer.getName());
			prepStmt.setString(3, customer.getPassword());
			prepStmt.setString(4, customer.getSSN());
			prepStmt.setString(5, customer.getAddress());
			
			prepStmt.executeUpdate();
			
		}catch(SQLException e){
			System.out.println("ERROR: SQL exception");
			e.printStackTrace();
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
	public void addAccount(Account account, String username, String state, String type) {
		String query = "insert into accounts (account_num, account_balance, username, account_state, account_type)"+"values(?, ?, ?, ?, ?)";
		try {
			Connection conn = DatabaseConnector.connector();
			
			
			
			PreparedStatement prepStmt=conn.prepareStatement(query);
			
			prepStmt.setInt(1, account.getAcctNum());
			prepStmt.setFloat(2, (float) account.getBalance());
			prepStmt.setString(3, username);
			prepStmt.setString(4, account.getState());
			prepStmt.setString(5, account.getType());
			
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
	public Customer setCustomerAccountObj(String username) {
		try {
			Connection conn = DatabaseConnector.connector();
			Statement stmt=conn.createStatement();	
			//
			ResultSet rs=stmt.executeQuery("select * from accounts where username='"+username+"'");
			
			Account account=null;
			List<Account> accounts=new ArrayList<Account>();
				while(rs.next()) {
					int acctNum=rs.getInt(1);
					double balance=rs.getDouble(2);
					String state=rs.getString(4);
					String type=rs.getString(5);
					
					account=new Account(acctNum, balance, state, type);
					accounts.add(account);
				}
				//
				ResultSet rs3=stmt.executeQuery("select * from joint where username='"+username+"'");
				
					while(rs3.next()) {
						int acctNum=rs3.getInt(1);
						double balance=rs3.getDouble(3);
						String state=rs3.getString(4);
						
						account=new Account(acctNum, balance, state, "joint");
						accounts.add(account);
					}
					//
				Connection conn2 = DatabaseConnector.connector();
				Statement stmt2=conn2.createStatement();
				ResultSet rs2=stmt2.executeQuery("select * from customers where username='"+username+"'");
				
				Customer customer=null;
				while(rs2.next()) {
				String user=rs2.getString(1);
				String name=rs2.getString(2);
				String pass=rs2.getString(3);
				String ssn=(Integer.toString(rs2.getInt(4)));
				String address=rs2.getString(5);
			
				customer=new Customer(user, name, pass, ssn, address, accounts);
				}
				return customer;

			
		
		}catch(SQLException e){
			System.out.println("ERROR: SQL exception(setCustomerAccountObj)");
			e.printStackTrace();
			return null;
		}
	}
}
