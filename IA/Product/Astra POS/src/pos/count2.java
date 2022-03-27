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

public class count2 {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;
	Double cash = 0.0;
	Double card = 0.0;

	public void setVisible() {
		frame.setVisible(true);
	}


	public count2() {
		initialize();
	}

	private void initialize() {
		Database database = new Database();
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(51, 51, 51));
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("500");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel.setBounds(132, 53, 42, 33);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("200");
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(271, 53, 50, 33);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("100");
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(410, 53, 50, 33);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("50");
		lblNewLabel_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(549, 53, 33, 33);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("20");
		lblNewLabel_1_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1_1.setBounds(669, 53, 42, 33);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_1 = new JLabel("10");
		lblNewLabel_2_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_2_1.setBounds(132, 98, 42, 33);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_4 = new JLabel("5");
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_4.setBounds(271, 98, 42, 33);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_1_2 = new JLabel("2");
		lblNewLabel_1_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_2.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1_2.setBounds(410, 98, 33, 33);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("1");
		lblNewLabel_2_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_2.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_2_2.setBounds(549, 98, 33, 33);
		frame.getContentPane().add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_5 = new JLabel("0.50");
		lblNewLabel_5.setForeground(new Color(255, 255, 255));
		lblNewLabel_5.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_5.setBounds(669, 98, 50, 33);
		frame.getContentPane().add(lblNewLabel_5);
		
		JLabel lblNewLabel_1_3 = new JLabel("0.20");
		lblNewLabel_1_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_1_3.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_1_3.setBounds(132, 143, 42, 33);
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_2_3 = new JLabel("0.10");
		lblNewLabel_2_3.setForeground(new Color(255, 255, 255));
		lblNewLabel_2_3.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_2_3.setBounds(271, 143, 50, 33);
		frame.getContentPane().add(lblNewLabel_2_3);
		
		JLabel lblNewLabel_5_1 = new JLabel("0.05");
		lblNewLabel_5_1.setForeground(Color.WHITE);
		lblNewLabel_5_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_5_1.setBounds(410, 143, 50, 33);
		frame.getContentPane().add(lblNewLabel_5_1);
		
		JLabel lblNewLabel_5_2 = new JLabel("0.02");
		lblNewLabel_5_2.setForeground(Color.WHITE);
		lblNewLabel_5_2.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_5_2.setBounds(536, 143, 46, 33);
		frame.getContentPane().add(lblNewLabel_5_2);
		
		JLabel lblNewLabel_5_3 = new JLabel("0.01");
		lblNewLabel_5_3.setForeground(Color.WHITE);
		lblNewLabel_5_3.setFont(new Font("Arial", Font.PLAIN, 17));
		lblNewLabel_5_3.setBounds(669, 143, 50, 33);
		frame.getContentPane().add(lblNewLabel_5_3);
		
		textField = new JTextField();
		textField.setBounds(166, 57, 60, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(312, 57, 60, 26);
		frame.getContentPane().add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(448, 57, 60, 26);
		frame.getContentPane().add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(582, 57, 60, 26);
		frame.getContentPane().add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(703, 57, 60, 26);
		frame.getContentPane().add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(166, 102, 60, 26);
		frame.getContentPane().add(textField_5);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(312, 98, 60, 26);
		frame.getContentPane().add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(448, 98, 60, 26);
		frame.getContentPane().add(textField_7);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(582, 102, 60, 26);
		frame.getContentPane().add(textField_8);
		
		textField_9 = new JTextField();
		textField_9.setColumns(10);
		textField_9.setBounds(703, 102, 60, 26);
		frame.getContentPane().add(textField_9);
		
		textField_10 = new JTextField();
		textField_10.setColumns(10);
		textField_10.setBounds(166, 147, 60, 26);
		frame.getContentPane().add(textField_10);
		
		textField_11 = new JTextField();
		textField_11.setColumns(10);
		textField_11.setBounds(312, 147, 60, 26);
		frame.getContentPane().add(textField_11);
		
		textField_12 = new JTextField();
		textField_12.setColumns(10);
		textField_12.setBounds(448, 143, 60, 26);
		frame.getContentPane().add(textField_12);
		
		textField_13 = new JTextField();
		textField_13.setColumns(10);
		textField_13.setBounds(582, 143, 60, 26);
		frame.getContentPane().add(textField_13);
		
		textField_14 = new JTextField();
		textField_14.setColumns(10);
		textField_14.setBounds(703, 147, 60, 26);
		frame.getContentPane().add(textField_14);
		
		JLabel lblCard = new JLabel("Card");
		lblCard.setForeground(Color.WHITE);
		lblCard.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCard.setBounds(383, 251, 60, 33);
		frame.getContentPane().add(lblCard);
		
		textField_15 = new JTextField();
		textField_15.setBounds(448, 255, 130, 26);
		frame.getContentPane().add(textField_15);
		textField_15.setColumns(10);
		
		
		
		JLabel lblCashDifference = new JLabel("Cash difference:");
		lblCashDifference.setForeground(Color.WHITE);
		lblCashDifference.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCashDifference.setBounds(313, 296, 130, 33);
		frame.getContentPane().add(lblCashDifference);
		
		JLabel lblCardDifference = new JLabel("Card difference:");
		lblCardDifference.setForeground(Color.WHITE);
		lblCardDifference.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCardDifference.setBounds(313, 341, 130, 33);
		frame.getContentPane().add(lblCardDifference);
		
		
		JLabel lblCashDifference_1 = new JLabel("");
		lblCashDifference_1.setForeground(Color.WHITE);
		lblCashDifference_1.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCashDifference_1.setBounds(448, 296, 130, 33);
		frame.getContentPane().add(lblCashDifference_1);
		
		JLabel lblCashDifference_2 = new JLabel("");
		lblCashDifference_2.setForeground(Color.WHITE);
		lblCashDifference_2.setFont(new Font("Arial", Font.PLAIN, 17));
		lblCashDifference_2.setBounds(448, 341, 130, 33);
		
		JButton btnNewButton = new JButton("Calculate");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cash = countCash();
				lblCashDifference_1.setText(Double.toString(database.checkCash(cash)));
				lblCashDifference_2.setText(Double.toString(database.checkCard(Double.parseDouble(textField_15.getText()))));
				
			}
		});
		btnNewButton.setFont(new Font("Arial", Font.PLAIN, 15));
		btnNewButton.setBounds(312, 402, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				database.zeroCard();
				database.zeroCash();
				frame.dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							GuiMainEmp window = new GuiMainEmp();
							window.setVisible();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnBack.setFont(new Font("Arial", Font.PLAIN, 15));
		btnBack.setBounds(465, 402, 117, 29);
		frame.getContentPane().add(btnBack);
		
		frame.getContentPane().add(lblCashDifference_2);
		frame.setResizable(false);
		frame.setSize(1000,500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setLocationRelativeTo(null);
	}
	
	public Double countCash() {
		Double d = 0.0;
		d = (Double.parseDouble(textField.getText())*500) + (Double.parseDouble(textField_1.getText())*200) 
				+ (Double.parseDouble(textField_2.getText())*100) + (Double.parseDouble(textField_3.getText())*50)
				+ (Double.parseDouble(textField_4.getText())*20) + (Double.parseDouble(textField_5.getText())*10)
				+ (Double.parseDouble(textField_6.getText())*5)+(Double.parseDouble(textField_7.getText())*2) + (Double.parseDouble(textField_8.getText())*1)
				+(Double.parseDouble(textField_9.getText())*0.5) + (Double.parseDouble(textField_10.getText())*0.2) + (Double.parseDouble(textField_11.getText())*0.1)
				+ (Double.parseDouble(textField_12.getText())*0.05) + (Double.parseDouble(textField_13.getText())*0.02) + (Double.parseDouble(textField_14.getText())*0.01);
		return d;
	}

}
