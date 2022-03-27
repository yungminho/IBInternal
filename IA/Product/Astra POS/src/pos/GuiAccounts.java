package pos;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.BorderLayout;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTable;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;

public class GuiAccounts {

	private JFrame mainWindow;
	private JTable table_1;
	String[] columnNames = new String[4];
	String[] gap = new String[4];
	String[] row1 = new String[4];
	String[] row2 = new String[4];
	String[] row3 = new String[4];
	String[] row4 = new String[4];
	String[] row5 = new String[4];

	public void setVisible() {
		mainWindow.setVisible(true);
	}

	public void CloseFrame() {
		mainWindow.dispose();
	}
	public GuiAccounts() {
		initialize();
	}

	private void initialize() {
		
		Database database = new Database();
		
		listAccount list = new listAccount();
		
		
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
		panel.setBounds(807, 6, 187, 328);
		desktopPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Add account");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							addAcount window = new addAcount();
							window.setVisible();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(6, 37, 175, 65);
		panel.add(btnNewButton);
		
		JButton btnAsortytment = new JButton("Delete account");
		btnAsortytment.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							delAccount window = new delAccount();
							window.setVisible();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAsortytment.setFont(new Font("Arial", Font.PLAIN, 15));
		btnAsortytment.setBounds(6, 114, 175, 65);
		panel.add(btnAsortytment);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CloseFrame();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GuiMainAdm window = new GuiMainAdm();
							window.setVisible();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_3.setBounds(6, 191, 175, 65);
		panel.add(btnNewButton_3);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(10, 11, 785, 323);
		desktopPane.add(panel_2);
		
		
		JLabel lblNewLabel = new JLabel("List of Accounts");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel.setBounds(6, 6, 773, 26);
		panel_2.add(lblNewLabel);
		
		String[] columnNames = {"","Surname","Name","Login","Account type"};
		String[] gap = {"","","","",""};
		String[][] data = {
				{"","Surname","Name","Login","Account type"},
				{"","","","",""},
				{"1.",list.listSurname(1),list.listName(1),list.listLogin(1),list.listType(1)},
				{"","","","",""},
				{"2.",list.listSurname(2),list.listName(2),list.listLogin(2),list.listType(2)},
				{"","","","",""},
				{"3.",list.listSurname(3),list.listName(3),list.listLogin(3),list.listType(3)},
				{"","","","",""},
				{"4.",list.listSurname(4),list.listName(4),list.listLogin(4),list.listType(4)},
		};
		
		table_1 = new JTable(data,columnNames);
		table_1.setRowHeight(20);
		table_1.setFont(new Font("Arial", Font.PLAIN, 20));
		table_1.setBounds(16, 44, 763, 238);
		panel_2.add(table_1);
		
		
		
		mainWindow.setResizable(false);
		mainWindow.setSize(1000,375);
		mainWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mainWindow.setLocationRelativeTo(null);
		
	}
}
