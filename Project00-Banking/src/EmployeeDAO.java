import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface EmployeeDAO {

	void updateUser(Customer customer, String user);
	void updateJointBalance(Account account);
	void updateBalance(Account account);
	void updateAccountState(Account account, String state);
	ArrayList<String> getAllData(String usersname);
	//void createCustomer(Customer customer, String username, String name, String password, String SSN, String address);
	HashMap<String, String> getAccounts(String username);
	void removeAccount(int accountNum);
	void addJointAccount(Account account, String username);
	Employee setEmployeeObj(String username);
	List<Account> getAccountByState(String accountState);
	Account setAccountObj(int accountNumber);
}
