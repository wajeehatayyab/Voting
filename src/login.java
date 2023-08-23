import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class login extends JFrame {

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
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
		
	
	/**
	 * Create the frame
	 */
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 469, 368);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Voter Login Page");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 22));
		lblNewLabel.setBounds(84, 22, 226, 60);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("User name");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(37, 69, 90, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(37, 166, 90, 29);
		contentPane.add(lblNewLabel_1_1);
		
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 16));
		textField.setBounds(186, 110, 142, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(186, 166, 142, 29);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(240, 240, 240));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText(null);
				passwordField.setText(null);
			}
		});
		btnNewButton.setBounds(254, 239, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Login");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					Statement stmt = conn.createStatement();
					String sql="SELECT `first_name`, `last_name`, `email`, `age`, `gender`, `dob`, `cnic`, "
					+ "`city`, `address`, `phoneno`, `username`, `password` FROM `registration` WHERE username ='"+ textField.getText() +"' and password ='"+passwordField.getText()+"'" ;
					ResultSet rs=stmt.executeQuery(sql);
					if (rs.next()) {
					
					JOptionPane.showMessageDialog(btnNewButton_1,"Login successfully");
					String name=rs.getString("first_name");
					String cnic=rs.getString("cnic");
					String age=rs.getString("age");
					String gender=rs.getString("gender");
					String city=rs.getString("city");
					String address=rs.getString("address");
					
					
					Voter v=new Voter();
					 
				      v.lblNewLabel_1_1.setText(name);
				      v.lblNewLabel_1_2_3_1.setText(address);
				      v.lblNewLabel_1_2_2_1_1.setText(city);
				      v.lblNewLabel_1_2_5_1.setText(cnic);
				      v.lblNewLabel_1_2_2_2.setText(gender);
				      v.lblNewLabel_1_2_1_1.setText(age);
				      v.setVisible(true);
				      dispose();
					
					
					
					
					}else {
						JOptionPane.showMessageDialog(btnNewButton_1,"Login Failed");
					}
				}catch(Exception e1) {
				System.out.println(e1);
				}
			}
			
			
			private Object setText(String name) {
				// TODO Auto-generated method stub
				return null;
			}


			private String getText(String string) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		btnNewButton_1.setBounds(22, 239, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Registration");
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Registration r= new Registration();
				r.setVisible(true);
				dispose();
			
			}
		});
		btnNewButton_2.setBounds(128, 239, 116, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Back");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome w=new Welcome();
				w.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(354, 239, 89, 23);
		contentPane.add(btnNewButton_3);
	}
}
