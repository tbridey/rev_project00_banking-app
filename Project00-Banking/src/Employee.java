import java.io.IOException;

public class Employee extends User {
	
	public void runLogin() {
		Employee e=new Employee();
		try {
			e.login();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public char printEmployeeMenu() {
		char m='e';
		MainMenu menu=new MainMenu();
		menu.printTopMenu('e');
		return m;
	}
	
}
