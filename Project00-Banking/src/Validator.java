import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * Check the password and username against its database
 */
public class Validator {

	public boolean usernamePasswordCheck(String user, String pass) {
		
		try {
			
			Connection conn = DatabaseConnector.connector();
			Statement stmt=conn.createStatement();
			String str="Select password from customers where username='"+user+"'";
			ResultSet rs=stmt.executeQuery(str);
			if(rs.next()) {
				if(pass.equals(rs.getString("password"))) {
					return true;
				}
				else {
					System.out.println("Error: incorrect username or password");
					return false;
				}
			}
			else {
				System.out.println("Result set returned nothing");
				return false;
			}
		}catch(SQLException e){
			System.out.println("ERROR: Validator SQL exception");
			e.printStackTrace();
			return false;
		}		
	}
	
public boolean employeeLoginCheck(String user, String pass) {
		
		try {
			
			Connection conn = DatabaseConnector.connector();
			Statement stmt=conn.createStatement();
			String str="Select password from employees where username='"+user+"'";
			ResultSet rs=stmt.executeQuery(str);
			if(rs.next()) {
				if(pass.equals(rs.getString("password"))) {
					return true;
				}
				else {
					System.out.println("Error: incorrect username or password");
					return false;
				}
			}
			else {
				//System.out.println("Result set returned nothing");
				return false;
			}
		}catch(SQLException e){
			System.out.println("ERROR: Validator SQL exception");
			e.printStackTrace();
			return false;
		}	
		
	}
}

