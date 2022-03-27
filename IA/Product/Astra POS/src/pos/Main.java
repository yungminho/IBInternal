package pos;

import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.SQLException;

public class Main {

	public static void main(String[] args){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GuiLogin window = new GuiLogin();
					window.setVisible();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}	
