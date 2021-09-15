import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public class Employee extends User implements Serializable{
	
	private String admin = null;
	
	public Employee(String use, String name, String pass, String SSN, String address, String admin) {
		this.setName(name);
		this.setUsername(use);
		this.setPassword(pass);
		this.setSSN(SSN);
		this.setAddress(address);
		this.setAdmin(admin);
	}

	public String getAdmin() {
		return admin;
	}

	public void setAdmin(String admin) {
		this.admin = admin;
	}


	
}
