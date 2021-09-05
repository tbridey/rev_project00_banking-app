import java.io.IOException;

public class Admin extends User {
	public void runLogin() {
		Admin a=new Admin();
		try {
			a.login();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public char printAdminMenu() {
		char m='a';
		MainMenu menu=new MainMenu();
		menu.printTopMenu('a');
		return m;
	}
	
}
