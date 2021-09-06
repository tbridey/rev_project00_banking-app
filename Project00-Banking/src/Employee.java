import java.io.IOException;
import java.io.Serializable;

public class Employee extends User implements Serializable{
	

	public char printEmployeeMenu() {
		char m='e';
		MainMenu menu=new MainMenu();
		menu.printTopMenu('e');
		return m;
	}
	
}
