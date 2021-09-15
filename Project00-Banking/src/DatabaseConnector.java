import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

	public static Connection connector(){
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection conn=DriverManager.getConnection(Main.db_url, Main.user, Main.password);
			return conn;
		}catch(ClassNotFoundException e){
			System.out.println("ERROR: unable to load driver class");
			return null;
		}catch(SQLException e){
			System.out.println("ERROR: SQL exception in Connector");
			e.printStackTrace();
			return null;
		}
	}
}
