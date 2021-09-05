import java.io.Serializable;
import java.util.HashMap;

public class Database implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected HashMap<String, Customer> customerList;
	protected HashMap<String, Employee> employeeList;
	protected HashMap<String, Admin> adminList;
	
	public Database() {
		this.customerList= new HashMap<String, Customer>();
		this.employeeList= new HashMap<String, Employee>();
		this.adminList= new HashMap<String, Admin>();
	}
	
	public Database(HashMap<String, Customer> cl, HashMap<String, Employee> el, HashMap<String, Admin> al) {
		this.customerList=cl;
		this.employeeList=el;
		this.adminList=al;
	}
	
}
