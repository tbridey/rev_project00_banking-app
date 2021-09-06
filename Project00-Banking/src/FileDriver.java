import java.io.*;
import java.util.HashMap;

public class FileDriver {
	
	public final String cusFilePath="testUser/customers.txt";
	//public final String emFilePath
	//public final String adFilePath

	public void read(Database data) {
		  try {
	            FileInputStream fis = new FileInputStream(cusFilePath);
	            ObjectInputStream ons = new ObjectInputStream(fis);
	            
	            //data.customerList=HashMap<String, Customer>;
	            
	            
	        } catch (IOException e) {
	            e.printStackTrace();
	        }

	    }

	public void write(HashMap<String, Customer> customerList) {
		try {
	         FileOutputStream fileOut = new FileOutputStream("testUser/customers.json");
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(customerList);
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         System.out.println("catching object not serializing");
	      }
	}
}
