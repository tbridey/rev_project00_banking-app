import java.io.*;
import java.util.HashMap;

public class FileDriver {
	
	public final String cusFilePath="testUser/customers.ser";
	//public final String emFilePath
	//public final String adFilePath

	public void readCustomer(Database data) {
		try {
	         FileInputStream fileIn = new FileInputStream(cusFilePath);
	         ObjectInputStream in = new ObjectInputStream(fileIn);
	         data.customerList = (HashMap<String, Customer>) in.readObject();
	         in.close();
	         fileIn.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	         return;
	      } catch (ClassNotFoundException c) {
	         c.printStackTrace();
	         return;
	      }
	    }

	public void writeCustomer(HashMap<String, Customer> customerList) {
		try {
	         FileOutputStream fileOut = new FileOutputStream(cusFilePath);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(customerList);
	         out.close();
	         fileOut.close();
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
}
