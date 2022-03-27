package pos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class GuiMainEmp{

	private JFrame mainWindow;
	private JTextField textField;
	static Double sum = 0.0;

	public void setVisible() {
		mainWindow.setVisible(true);
	}

	public void CloseFrame() {
		mainWindow.dispose();
	}
	public GuiMainEmp() {
		initialize();
	}

	
	private void initialize() {
		
		Database database = new Database();
		
		
		mainWindow = new JFrame();
		mainWindow.setTitle("Astra POS v1.0");
		mainWindow.getContentPane().setForeground(Color.WHITE);
		mainWindow.getContentPane().setBackground(Color.BLACK);
		mainWindow.getContentPane().setLayout(new BorderLayout(0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.BLACK);
		mainWindow.getContentPane().add(desktopPane, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.GRAY);
		panel.setBounds(807, 6, 187, 460);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		
	
		
		JButton btnNewButton_4 = new JButton("Log out");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWindow.dispose();
				database.logOut();		
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
		});
		btnNewButton_4.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_4.setBounds(6, 244, 175, 65);
		panel.add(btnNewButton_4);
		
		JButton btnEndDay = new JButton("End Day");
		btnEndDay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							mainWindow.dispose();
							count2 window = new count2();
							window.setVisible();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnEndDay.setFont(new Font("Arial", Font.PLAIN, 15));
		btnEndDay.setBounds(6, 90, 175, 65);
		panel.add(btnEndDay);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(10, 316, 789, 150);
		desktopPane.add(panel_1);
		
	
		
		textField = new JTextField();
		textField.setFont(new Font("Arial", Font.PLAIN, 15));
		textField.setBounds(6, 47, 777, 71);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Scan the barcode:");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_1.setBounds(6, 6, 211, 41);
		panel_1.add(lblNewLabel_1);
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(10, 11, 785, 293);
		desktopPane.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("Zalogowano jako:");
		lblNewLabel.setText("Logged as: "+database.Display());
		lblNewLabel.setBackground(new Color(102, 102, 102));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(6, 6, 773, 38);
		panel_2.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Arial", Font.PLAIN, 17));
		textArea.setEditable(false);
		textArea.setBounds(16, 56, 505, 204);
		panel_2.add(textArea);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setEditable(false);
		textArea_1.setFont(new Font("Arial", Font.PLAIN, 17));
		textArea_1.setBounds(662, 56, 117, 204);
		panel_2.add(textArea_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(662, 257, 85, 30);
		panel_2.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Sum:");
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(611, 257, 49, 30);
		panel_2.add(lblNewLabel_2_1);
		
		
		JButton btnNewButton_1 = new JButton("Add Product");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.append(database.barScanner(textField.getText())+"\n");
				textArea_1.append(String.valueOf(database.getPrice(textField.getText())+ " zł\n"));
				sum = sum + (database.getPrice(textField.getText()));
				lblNewLabel_2.setText(String.valueOf(sum) + " zł");
				textField.setText(null);
			}
		});
		btnNewButton_1.setBounds(600, 6, 158, 38);
		panel_1.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Finalize Transaction");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Finalize2 window = new Finalize2();
							window.setVisible();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				textArea.setText(null);
				textArea_1.setText(null);
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(6, 6, 175, 65);
		panel.add(btnNewButton);
		
		mainWindow.setResizable(false);
		mainWindow.setSize(1000,500);
		mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainWindow.setLocationRelativeTo(null);
		
		
	}
}
