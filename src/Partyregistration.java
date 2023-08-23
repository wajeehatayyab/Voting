import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Partyregistration extends JFrame {

	private JPanel contentPane;
	private JTextField pname;
	private JTextField psymbol;
	private JTextField pabb;
	private JTextField pleader;
	private JTextField puname;
	private JTextField ppassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Partyregistration frame = new Partyregistration();
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
	public Partyregistration() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 546);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Party Registration");
		lblWelcome.setForeground(Color.BLUE);
		lblWelcome.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblWelcome.setBounds(125, 28, 213, 46);
		contentPane.add(lblWelcome);
		
		JLabel lblNewLabel_1 = new JLabel("Party name");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(27, 119, 106, 28);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Party Symbol");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(27, 175, 120, 28);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Party Abbrevition");
		lblNewLabel_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(27, 225, 144, 28);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Party Leader");
		lblNewLabel_1_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1.setBounds(27, 282, 144, 28);
		contentPane.add(lblNewLabel_1_1_1_1);
		
		pname = new JTextField();
		pname.setColumns(10);
		pname.setBounds(195, 125, 206, 20);
		contentPane.add(pname);
		
		psymbol = new JTextField();
		psymbol.setColumns(10);
		psymbol.setBounds(195, 181, 206, 20);
		contentPane.add(psymbol);
		
		pabb = new JTextField();
		pabb.setColumns(10);
		pabb.setBounds(195, 231, 206, 20);
		contentPane.add(pabb);
		
		pleader = new JTextField();
		pleader.setColumns(10);
		pleader.setBounds(195, 288, 206, 20);
		contentPane.add(pleader);
		
		JButton btnNewButton_3_2 = new JButton("Login");
		btnNewButton_3_2.setForeground(Color.BLUE);
		btnNewButton_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PartyLogin w=new PartyLogin();
                w.setVisible(true);
                dispose();
			}
		});
		btnNewButton_3_2.setBounds(312, 439, 89, 23);
		contentPane.add(btnNewButton_3_2);
		
		JButton btnNewButton_3_1 = new JButton("Back");
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_1.setForeground(Color.BLUE);
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome w=new Welcome();
                        w.setVisible(true);
                        dispose();
			}
		});
		btnNewButton_3_1.setBounds(172, 439, 89, 23);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(28, 439, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Clear");
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pname.setText(null);
			    psymbol.setText(null);
				pabb.setText(null);
				pleader.setText(null);
			    puname.setText(null);
			    ppassword.setText(null);
				
			}
		});
		btnNewButton_2.setBounds(82, 473, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_2_1 = new JButton("Submit");
		btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2_1.setForeground(Color.BLUE);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root",
					"");
					PreparedStatement ps = conn.prepareStatement("INSERT INTO `pregistration`(`Partyname`, `Partysymbol`, `PartyAddrevation`, `Partyleader`, `PartyUname`, `PartyPassword`) values(?,?,?,?,?,?); ");
					ps.setString(1, pname.getText());
					ps.setString(2, psymbol.getText());
					ps.setString(3, pabb.getText());
					ps.setString(4, pleader.getText());
					ps.setString(5, puname.getText());
					ps.setString(6, ppassword.getText());
					
					int x = ps.executeUpdate();
					if (x>0) {
						JOptionPane.showMessageDialog(btnNewButton_2_1,"Registration successfully");
					}else {
						JOptionPane.showMessageDialog(btnNewButton_2_1,"Registration Failed");
					}
				}catch(Exception e1) {
				System.out.println(e1);
				}
				
				
				
			}
		});
		btnNewButton_2_1.setBounds(238, 473, 89, 23);
		contentPane.add(btnNewButton_2_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Party Username");
		lblNewLabel_1_1_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBounds(27, 332, 144, 28);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Party pasword");
		lblNewLabel_1_1_1_1_2.setForeground(Color.BLUE);
		lblNewLabel_1_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_2.setBounds(27, 388, 144, 28);
		contentPane.add(lblNewLabel_1_1_1_1_2);
		
		puname = new JTextField();
		puname.setColumns(10);
		puname.setBounds(195, 338, 206, 20);
		contentPane.add(puname);
		
		ppassword = new JTextField();
		ppassword.setColumns(10);
		ppassword.setBounds(195, 388, 206, 20);
		contentPane.add(ppassword);
	}

}
