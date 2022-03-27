package pos;

import java.awt.EventQueue;


import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addAcount {

	private JFrame frmAstraPosV;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JPasswordField passwordField;


	public addAcount() {
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
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel.setBounds(16, 18, 129, 33);
		frmAstraPosV.getContentPane().add(lblNewLabel);
		
		JLabel lblNazwisko = new JLabel("Surname");
		lblNazwisko.setForeground(Color.WHITE);
		lblNazwisko.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNazwisko.setBounds(16, 52, 129, 33);
		frmAstraPosV.getContentPane().add(lblNazwisko);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setFont(new Font("Arial", Font.PLAIN, 15));
		lblLogin.setBounds(16, 97, 129, 33);
		frmAstraPosV.getContentPane().add(lblLogin);
		
		JLabel lblHaso = new JLabel("Password");
		lblHaso.setForeground(Color.WHITE);
		lblHaso.setFont(new Font("Arial", Font.PLAIN, 15));
		lblHaso.setBounds(16, 142, 129, 33);
		frmAstraPosV.getContentPane().add(lblHaso);
		
		JLabel lblTypKonta = new JLabel("Account type");
		lblTypKonta.setForeground(Color.WHITE);
		lblTypKonta.setFont(new Font("Arial", Font.PLAIN, 15));
		lblTypKonta.setBounds(16, 187, 129, 33);
		frmAstraPosV.getContentPane().add(lblTypKonta);
		
		textField = new JTextField();
		textField.setBounds(157, 21, 287, 26);
		frmAstraPosV.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(157, 55, 287, 26);
		frmAstraPosV.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(157, 100, 287, 26);
		frmAstraPosV.getContentPane().add(textField_2);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Admin");
		tglbtnNewToggleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		tglbtnNewToggleButton.setFont(new Font("Arial", Font.PLAIN, 15));
		tglbtnNewToggleButton.setBounds(213, 190, 161, 29);
		frmAstraPosV.getContentPane().add(tglbtnNewToggleButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(157, 145, 287, 26);
		
		JButton btnNewButton = new JButton("Create");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean b = false;
				if(tglbtnNewToggleButton.isSelected() == true) {
					b = true;
				}
				database.addAccount(textField_2.getText(), passwordField.getText(), textField.getText(), textField_1.getText(), b);
				frmAstraPosV.dispose();
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(157, 228, 117, 29);
		frmAstraPosV.getContentPane().add(btnNewButton);
		
		
		frmAstraPosV.getContentPane().add(passwordField);
		frmAstraPosV.setBounds(100, 100, 450, 300);
		frmAstraPosV.setLocationRelativeTo(null);
		frmAstraPosV.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}
