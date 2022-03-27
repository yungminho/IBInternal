package pos;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class delAccount {

	private JFrame frmAstraPosV;
	private JTextField textField;


	public delAccount() {
		initialize();
	}
	
	public void setVisible() {
		frmAstraPosV.setVisible(true);
	}


	private void initialize() {
		Database database = new Database();
		frmAstraPosV = new JFrame();
		frmAstraPosV.setTitle("Astra POS v1.0");
		frmAstraPosV.setResizable(false);
		frmAstraPosV.getContentPane().setBackground(new Color(51, 51, 51));
		frmAstraPosV.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				database.delAccount(textField.getText());
				frmAstraPosV.dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(160, 60, 117, 29);
		frmAstraPosV.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Login:");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(43, 25, 68, 29);
		frmAstraPosV.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(122, 26, 251, 26);
		frmAstraPosV.getContentPane().add(textField);
		textField.setColumns(10);
		frmAstraPosV.setBounds(100, 100, 381, 128);
		frmAstraPosV.setLocationRelativeTo(null);
		frmAstraPosV.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
