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

public class Voter extends JFrame  {

	private JPanel contentPane;
	JLabel lblNewLabel_1_1;
	JLabel lblNewLabel_1_2_3_1;
	JLabel lblNewLabel_1_2_2_1_1;
	JLabel lblNewLabel_1_2_1_1;
	JLabel lblNewLabel_1_2_2_2;
	JLabel lblNewLabel_1_2_5_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Voter frame = new Voter();
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

	
	
	public Voter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 459, 571);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(new Color(255, 175, 175));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVoter = new JLabel(" Voter information");
		lblVoter.setForeground(Color.BLUE);
		lblVoter.setBackground(new Color(240, 240, 240));
		lblVoter.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblVoter.setBounds(92, 11, 220, 46);
		contentPane.add(lblVoter);
		
		JLabel lblNewLabel_1 = new JLabel("Voter name");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(10, 106, 99, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_2_1 = new JLabel("Voter Age");
		lblNewLabel_1_2_1.setForeground(Color.BLUE);
		lblNewLabel_1_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1.setBounds(10, 256, 89, 25);
		contentPane.add(lblNewLabel_1_2_1);
		
		JLabel lblNewLabel_1_2_2 = new JLabel("Voter Gender");
		lblNewLabel_1_2_2.setForeground(Color.BLUE);
		lblNewLabel_1_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_2.setBounds(10, 209, 109, 25);
		contentPane.add(lblNewLabel_1_2_2);
		
		JLabel lblNewLabel_1_2_5 = new JLabel("Voter Cnic");
		lblNewLabel_1_2_5.setForeground(Color.BLUE);
		lblNewLabel_1_2_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_5.setBounds(10, 160, 99, 25);
		contentPane.add(lblNewLabel_1_2_5);
		
		JLabel lblNewLabel_1_2_2_1 = new JLabel("Voter City");
		lblNewLabel_1_2_2_1.setForeground(Color.BLUE);
		lblNewLabel_1_2_2_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_2_1.setBounds(10, 307, 82, 25);
		contentPane.add(lblNewLabel_1_2_2_1);
		
		JLabel lblNewLabel_1_2_3 = new JLabel("Voter Address");
		lblNewLabel_1_2_3.setForeground(Color.BLUE);
		lblNewLabel_1_2_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_3.setBounds(10, 356, 124, 25);
		contentPane.add(lblNewLabel_1_2_3);
		
		JButton btnNewButton_1 = new JButton("Vote");
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vote v=new Vote();
				v.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(226, 425, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(10, 425, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Back");
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_1.setForeground(Color.BLUE);
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login v=new login();
				v.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3_1.setBounds(109, 425, 89, 23);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("Logout");
		btnNewButton_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_2.setForeground(Color.BLUE);
		btnNewButton_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a = JOptionPane.showConfirmDialog(btnNewButton_3_2, "Are you sure?");
                // JOptionPane.setRootFrame(null);
                if (a == JOptionPane.YES_OPTION) {
                    dispose();
                    login obj = new login();
                    obj.setTitle("Login");
                    obj.setVisible(true);
                }
                dispose();
                login obj = new login();
			}
		});
		btnNewButton_3_2.setBounds(326, 425, 89, 23);
		contentPane.add(btnNewButton_3_2);
		
		lblNewLabel_1_1 = new JLabel("Voter name is");
		lblNewLabel_1_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(165, 106, 220, 25);
		contentPane.add(lblNewLabel_1_1);
		
		lblNewLabel_1_2_5_1 = new JLabel("Voter Cnic is");
		lblNewLabel_1_2_5_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_2_5_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_5_1.setBounds(165, 160, 147, 25);
		contentPane.add(lblNewLabel_1_2_5_1);
		
		lblNewLabel_1_2_2_2 = new JLabel("Voter Gender is");
		lblNewLabel_1_2_2_2.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_2_2_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_2_2.setBounds(165, 209, 147, 25);
		contentPane.add(lblNewLabel_1_2_2_2);
		
		 lblNewLabel_1_2_1_1 = new JLabel("Voter Age is ");
		 lblNewLabel_1_2_1_1.setForeground(new Color(100, 149, 237));
		 lblNewLabel_1_2_2_2.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_1_1.setBounds(165, 256, 147, 25);
		contentPane.add(lblNewLabel_1_2_1_1);
		
		lblNewLabel_1_2_2_1_1 = new JLabel("Voter City is ");
		lblNewLabel_1_2_2_1_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_2_2_2.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_2_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_2_1_1.setBounds(165, 307, 141, 25);
		contentPane.add(lblNewLabel_1_2_2_1_1);
		
		lblNewLabel_1_2_3_1 = new JLabel("Voter Address is");
		lblNewLabel_1_2_3_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_2_2_2.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_2_3_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2_3_1.setBounds(165, 356, 168, 25);
		contentPane.add(lblNewLabel_1_2_3_1);
	}
}
