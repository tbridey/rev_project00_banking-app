import java.io.*;
import java.util.HashMap;

public class FileDriver {
	
	public final String cusFilePath="./testUser/customers.txt";
	//public final String emFilePath
	//public final String adFilePath

	public void read(Database data) {
		  try {
	            FileInputStream fis = new FileInputStream(cusFilePath);
	            ObjectInputStream ons = new ObjectInputStream(fis);
	            
	            data.customerList=(HashMap<String, Customer>) ons.readObject();
	            
	            
	        } catch (IOException | ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	    }

	public void write(Database data) {
		 try {
	            FileOutputStream fos = new FileOutputStream(cusFilePath);
	            ObjectOutputStream out = new ObjectOutputStream(fos);
	            System.out.println("Writing List");
	            out.writeObject(data.customerList);
	            System.out.println("Writing complete");
	            System.out.println(data.customerList);
	            out.flush();
	            out.close();
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	}
}
