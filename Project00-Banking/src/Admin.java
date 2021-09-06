import java.io.IOException;
import java.io.Serializable;

public class Admin extends User implements Serializable{

	public char printAdminMenu() {
		char m='a';
		MainMenu menu=new MainMenu();
		menu.printTopMenu('a');
		return m;
	}
	
}
