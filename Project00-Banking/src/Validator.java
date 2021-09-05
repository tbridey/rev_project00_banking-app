/*
 * Check the password and username against its database
 */
public class Validator {

	public boolean usernamePasswordCheck(Database data, String user, String pass) {
		
		boolean userExists = data.customerList.containsKey(user);
		
		
		//if: the username matches one in the system
		if (userExists==true){
			String passwordToCheck = data.customerList.get(user).getPassword();
			//System.out.println("username to check: "+user);
			//System.out.println("Customer List: "+data.customerList);
		//if: password is associated to user
			if(passwordToCheck.equals(pass)) {
				return true;
			}
			else {
				return false;
			}
		}		
			//else:false
		else {
			return false;
		}
		
	}
}
