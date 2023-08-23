import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class PartyLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PartyLogin frame = new PartyLogin();
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
	public PartyLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 327);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPartyLoginPage = new JLabel("Party Login Page");
		lblPartyLoginPage.setForeground(Color.BLUE);
		lblPartyLoginPage.setBackground(Color.BLUE);
		lblPartyLoginPage.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblPartyLoginPage.setBounds(108, 11, 226, 60);
		contentPane.add(lblPartyLoginPage);
		
		JLabel lblNewLabel_1 = new JLabel("User name");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(29, 124, 90, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(29, 182, 90, 29);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					Statement stmt = conn.createStatement();
					String sql="SELECT * FROM `pregistration` WHERE Partyuname ='"+ textField.getText() +"' and Partypassword ='"+passwordField.getText()+"'" ;
					ResultSet rs=stmt.executeQuery(sql);
					if (rs.next()) {
					
					JOptionPane.showMessageDialog(btnNewButton_1,"Login successfully");
					String Partyname=rs.getString("Partyname");
					String Partysymbol=rs.getString("Partysymbol");
					String PartyAddrevation=rs.getString("PartyAddrevation");
					String Partyleader=rs.getString("Partyleader");
					
					
					Parties v=new Parties();
					 
				      v.lblNewLabel_1_2.setText(Partyname);
				      v.lblNewLabel_1_1_2.setText(Partysymbol);
				      v.lblNewLabel_1_1_1_2.setText(PartyAddrevation);
				      v.lblNewLabel_1_1_1_1_1.setText(Partyleader);
				     
				      v.setVisible(true);
				      dispose();
					
					}else {
						JOptionPane.showMessageDialog(btnNewButton_1,"Login Failed");
					}
				}catch(Exception e1) {
				System.out.println(e1);
				}
			
			}
		});
		btnNewButton_1.setBounds(29, 254, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Registration");
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Partyregistration p =new Partyregistration();
				p.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(138, 254, 120, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnNewButton.setBounds(280, 254, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome w = new Welcome();
				w.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(379, 254, 89, 23);
		contentPane.add(btnNewButton_3);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setColumns(10);
		textField.setBounds(213, 124, 142, 29);
		contentPane.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(213, 184, 142, 29);
		contentPane.add(passwordField);
	}
}
