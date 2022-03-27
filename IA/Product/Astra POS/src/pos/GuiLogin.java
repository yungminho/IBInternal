package pos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.Font;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import java.awt.Component;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;

public class GuiLogin {

	private JFrame loginWindow;
	private JTextField txtLogin;
	private JPasswordField passwordField;

	
	public void setVisible() {
		loginWindow.setVisible(true);
	}

	public GuiLogin() {
		initialize();
	}

	
	private void initialize() {
		
		Database access = new Database();
		
		loginWindow = new JFrame();
		loginWindow.getContentPane().setForeground(Color.WHITE);
		loginWindow.getContentPane().setBackground(new Color(51, 51, 51));
		loginWindow.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to the POS");
		lblNewLabel.setBounds(6, 6, 586, 115);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));
		lblNewLabel.setForeground(Color.WHITE);
		loginWindow.getContentPane().add(lblNewLabel);
		
		txtLogin = new JTextField();
		txtLogin.setFont(new Font("Arial", Font.PLAIN, 15));
		txtLogin.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtLogin.setText("");
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(txtLogin.getText().isEmpty()) {
					txtLogin.setText("Login");
				}
			}
		});
		
		txtLogin.setText("Login");
		txtLogin.setBounds(184, 218, 238, 39);
		loginWindow.getContentPane().add(txtLogin);
		txtLogin.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				passwordField.setText("");	
			}
			@Override
			public void focusLost(FocusEvent e) {
				if(passwordField.getText().isEmpty()) {
					passwordField.setText("Haslo");
				}
			}
		});
		passwordField.setText("Haslo");
		passwordField.setFont(new Font("Arial", Font.PLAIN, 15));
		passwordField.setBounds(184, 296, 238, 39);
		loginWindow.getContentPane().add(passwordField);
		

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(171, 373, 295, 39);
		
		JButton btnNewButton = new JButton("Log in");
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Arial", Font.BOLD, 20));
		btnNewButton.setBackground(new Color(102, 102, 102));
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(access.Access(txtLogin.getText(), passwordField.getText()) == true) {
					loginWindow.setVisible(false);
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								if(access.adm == true) {
									GuiMainAdm window = new GuiMainAdm();
									window.setVisible();
								}else {
									GuiMainEmp window = new GuiMainEmp();
									window.setVisible();
								}
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} else {
					lblNewLabel_1.setText("Login error. Try again.");
				}
				
			}
		});
		btnNewButton.setBounds(184, 455, 238, 60);
		loginWindow.getContentPane().add(btnNewButton);
		
		JLabel lblZalogujSiZaby = new JLabel("Please log in to continue");
		lblZalogujSiZaby.setHorizontalAlignment(SwingConstants.CENTER);
		lblZalogujSiZaby.setForeground(Color.WHITE);
		lblZalogujSiZaby.setFont(new Font("Arial", Font.BOLD, 25));
		lblZalogujSiZaby.setBounds(6, 73, 586, 115);
		loginWindow.getContentPane().add(lblZalogujSiZaby);
		
		
		loginWindow.getContentPane().add(lblNewLabel_1);
		loginWindow.setResizable(false);
		loginWindow.setTitle("Astra POS v1.0");
		loginWindow.setBackground(new Color(51, 51, 51));
		loginWindow.setSize(600,618);
		loginWindow.setLocationRelativeTo(null);
		loginWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
