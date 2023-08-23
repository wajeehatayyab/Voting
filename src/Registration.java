import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.sql.*;
import java.awt.Color;

public class Registration extends JFrame {

	private JPanel contentPane;
	private JPasswordField passwordField;
	private JTextField textfname;
	private JTextField textlname;
	private JTextField textemail;
	private JTextField textage;
	private JTextField textgender;
	private JTextField textcity;
	private JTextField textuname;
	private JTextField textcnic;
	private JTextField textphone;
	private JTextField textaddress;
	private JTextField textdob;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration frame = new Registration();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Registration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 495, 637);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registration form");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setBounds(118, 11, 220, 46);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("First name");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(28, 100, 99, 25);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Email");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setBounds(28, 172, 82, 25);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Last name");
		lblNewLabel_1_2.setForeground(Color.BLUE);
		lblNewLabel_1_2.setBounds(28, 136, 99, 25);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Age");
		lblNewLabel_1_2_1.setForeground(Color.BLUE);
		lblNewLabel_1_2_1.setBounds(38, 208, 71, 25);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Gender");
		lblNewLabel_1_2_2.setForeground(Color.BLUE);
		lblNewLabel_1_2_2.setBounds(28, 244, 82, 25);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Address");
		lblNewLabel_1_2_3.setForeground(Color.BLUE);
		lblNewLabel_1_2_3.setBounds(28, 346, 72, 25);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1_2_3);
		
		JLabel lblNewLabel_1_2_4 = new JLabel("Phone no");
		lblNewLabel_1_2_4.setForeground(Color.BLUE);
		lblNewLabel_1_2_4.setBounds(31, 382, 79, 25);
		lblNewLabel_1_2_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1_2_4);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("Cnic");
		lblNewLabel_1_2_5.setForeground(Color.BLUE);
		lblNewLabel_1_2_5.setBounds(38, 418, 65, 25);
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1_2_5);
		
		JLabel lblNewLabel_1_2_6 = new JLabel("User name");
		lblNewLabel_1_2_6.setForeground(Color.BLUE);
		lblNewLabel_1_2_6.setBounds(28, 454, 99, 25);
		lblNewLabel_1_2_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1_2_6);
		
		JLabel lblNewLabel_1_2_7 = new JLabel("Password");
		lblNewLabel_1_2_7.setForeground(Color.BLUE);
		lblNewLabel_1_2_7.setBounds(28, 490, 99, 25);
		lblNewLabel_1_2_7.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1_2_7);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root",
					"");
					PreparedStatement ps = conn.prepareStatement("insert into  registration(first_name, last_name, email, age, gender, dob, cnic, city, address, phoneno, username, password) values(?,?,?,?,?,?,?,?,?,?,?,?); ");
					ps.setString(1, textfname.getText());
					ps.setString(2, textlname.getText());
					ps.setString(3, textemail.getText());
					ps.setString(4, textage.getText());
					ps.setString(5, textgender.getText());
					ps.setString(6, textdob.getText());
					ps.setString(7, textcnic.getText());
					ps.setString(8, textcity.getText());
					ps.setString(9, textaddress.getText());
					ps.setString(10, textphone.getText());
					ps.setString(11, textuname.getText());
					ps.setString(12,passwordField.getText());
					int x = ps.executeUpdate();
					if (x>0) {
					JOptionPane.showMessageDialog(btnNewButton,"Registration successfully");
					
					login v=new login();
					 
				      
				      v.setVisible(true);
				      dispose();
					}else {
					JOptionPane.showMessageDialog(btnNewButton,"Registration Failed");
					}
				}catch(Exception e1) {
				System.out.println(e1);
				}
			}
			
		});
		btnNewButton.setBounds(28, 551, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textfname.setText(null);
				textlname.setText(null);
				textcity.setText(null);
				textemail.setText(null);
				textage.setText(null);
				textdob.setText(null);
				textcnic.setText(null);
				textaddress.setText(null);
				textuname.setText(null);
				textphone.setText(null);
				textgender.setText(null);
				textlname.setText(null);
				passwordField.setText(null);
			}
		});
		btnNewButton_2.setBounds(249, 551, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(366, 551, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("City");
		lblNewLabel_1_2_2_1.setForeground(Color.BLUE);
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_2_1.setBounds(45, 280, 82, 25);
		contentPane.add(lblNewLabel_1_2_2_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(137, 494, 225, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel_1_2_2_2 = new JLabel("D.O.B");
		lblNewLabel_1_2_2_2.setForeground(Color.BLUE);
		lblNewLabel_1_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_2_2.setBounds(28, 316, 82, 25);
		contentPane.add(lblNewLabel_1_2_2_2);
		
		textfname = new JTextField();
		textfname.setBounds(137, 104, 225, 20);
		contentPane.add(textfname);
		textfname.setColumns(10);
		
		textlname = new JTextField();
		textlname.setColumns(10);
		textlname.setBounds(137, 140, 225, 20);
		contentPane.add(textlname);
		
		textemail = new JTextField();
		textemail.setColumns(10);
		textemail.setBounds(137, 176, 225, 20);
		contentPane.add(textemail);
		
		textage = new JTextField();
		textage.setColumns(10);
		textage.setBounds(137, 212, 225, 20);
		contentPane.add(textage);
		
		textgender = new JTextField();
		textgender.setColumns(10);
		textgender.setBounds(137, 248, 225, 20);
		contentPane.add(textgender);
		
		textcity = new JTextField();
		textcity.setColumns(10);
		textcity.setBounds(137, 284, 225, 20);
		contentPane.add(textcity);
		
		textuname = new JTextField();
		textuname.setColumns(10);
		textuname.setBounds(137, 458, 225, 20);
		contentPane.add(textuname);
		
		textcnic = new JTextField();
		textcnic.setColumns(10);
		textcnic.setBounds(137, 422, 225, 20);
		contentPane.add(textcnic);
		
		textphone = new JTextField();
		textphone.setColumns(10);
		textphone.setBounds(137, 386, 225, 20);
		contentPane.add(textphone);
		
		textaddress = new JTextField();
		textaddress.setColumns(10);
		textaddress.setBounds(137, 350, 225, 20);
		contentPane.add(textaddress);
		
		textdob = new JTextField();
		textdob.setColumns(10);
		textdob.setBounds(137, 316, 225, 20);
		contentPane.add(textdob);
		
		JButton btnNewButton_2_1 = new JButton("Back");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login v=new login();
				v.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2_1.setForeground(Color.BLUE);
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2_1.setBounds(131, 552, 89, 23);
		contentPane.add(btnNewButton_2_1);
	}
}
