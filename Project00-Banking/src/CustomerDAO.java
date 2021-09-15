import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface CustomerDAO {

	void updateJointBalance(Account account);
	void updateBalance(Account account);
	ArrayList<String> getAllData(String usersname);
	void createCustomer(Customer customer, String username, String name, String password, String SSN, String address);
	HashMap<String, String> getAccounts(String username);
	void addAccount(Account account, String username, String state, String type);
	void addJointAccount(Account account, String username);
	Customer setCustomerAccountObj(String username);
}
