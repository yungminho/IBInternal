package pos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Finalize2 {

	private JFrame frame;

	public Finalize2() {
		initialize();
	}
	
	public void setVisible() {
		frame.setVisible(true);
	}

	private void initialize() {
		
		Database database = new Database();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Card");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				database.card(GuiMainEmp.sum);
				GuiMainEmp.sum = 0.0;
				frame.dispose();
			}
		});
		btnNewButton.setBounds(237, 31, 219, 96);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnCash = new JButton("Cash");
		btnCash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				database.cash(GuiMainEmp.sum);
				GuiMainEmp.sum = 0.0;
				frame.dispose();
			}
		});
		btnCash.setBounds(6, 31, 219, 96);
		frame.getContentPane().add(btnCash);
		frame.setResizable(false);
		frame.setBounds(100, 100, 460, 202);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}

}
