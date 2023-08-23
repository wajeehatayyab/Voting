import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;

public class Vote extends JFrame {

	private JPanel contentPane;
	private JTextField textcnic;
	private JTextField textage;
	private JTextField textcity;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Vote frame = new Vote();
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
	public Vote() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 452, 551);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JRadioButton pti = new JRadioButton("PTI");
		pti.setBackground(Color.PINK);
		pti.setForeground(Color.BLUE);
		pti.setFont(new Font("Tahoma", Font.BOLD, 13));
		pti.setBounds(20, 337, 109, 23);
		contentPane.add(pti);
		
		JRadioButton pmln = new JRadioButton("PML N");
		pmln.setForeground(Color.BLUE);
		pmln.setBackground(Color.PINK);
		pmln.setFont(new Font("Tahoma", Font.BOLD, 13));
		pmln.setBounds(20, 426, 109, 23);
		contentPane.add(pmln);

		JRadioButton ppp = new JRadioButton("PPP");
		ppp.setForeground(Color.BLUE);
		ppp.setBackground(Color.PINK);
		ppp.setFont(new Font("Tahoma", Font.BOLD, 13));
		ppp.setBounds(20, 384, 109, 23);
		contentPane.add(ppp);
		
		JRadioButton pmlq = new JRadioButton("PML(Q)");
		pmlq.setForeground(Color.BLUE);
		pmlq.setBackground(Color.PINK);
		pmlq.setFont(new Font("Tahoma", Font.BOLD, 13));
		pmlq.setBounds(233, 337, 109, 23);
		contentPane.add(pmlq);
		
		JRadioButton rdbtnMqm = new JRadioButton("MQM");
		rdbtnMqm.setForeground(Color.BLUE);
		rdbtnMqm.setBackground(Color.PINK);
		rdbtnMqm.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnMqm.setBounds(233, 384, 109, 23);
		contentPane.add(rdbtnMqm);
		
		JRadioButton rdbtnAnp = new JRadioButton("ANP");
		rdbtnAnp.setForeground(Color.BLUE);
		rdbtnAnp.setBackground(Color.PINK);
		rdbtnAnp.setFont(new Font("Tahoma", Font.BOLD, 13));
		rdbtnAnp.setBounds(233, 426, 109, 23);
		contentPane.add(rdbtnAnp);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textage.setText(null);
				textcity.setText(null);
				textcnic.setText(null);
				pti.setSelected(false);
				ppp.setSelected(false);
				rdbtnAnp.setSelected(false);
				pmlq.setSelected(false);
				rdbtnMqm.setSelected(false);
				pmln.setSelected(false);
				
				
			}
		});
		btnNewButton.setBounds(325, 467, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Voting System");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel.setBounds(95, 21, 196, 55);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Voter v=new Voter();
				v.setVisible(true);
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_1.setBounds(10, 467, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Submit");
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int age=Integer.parseInt(textage.getText());
				if(age<18) {
					JOptionPane.showInputDialog("You are not Eligible to vote");
				}
				String vote = "";
			
				if(pti.isSelected()) {
				vote="PTI";
				}else if(ppp.isSelected()) {
					vote="PPP";
				}
				else if(pmln.isSelected()) {
					vote="PML(N)";
				}else if(pmlq.isSelected()) {
					vote="PML(Q)";
				}else if(rdbtnMqm.isSelected()) {
					vote="MQM";
				}else if(rdbtnAnp.isSelected()) {
					vote="ANP";
				}
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =
					DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root",
					"");
					PreparedStatement ps = conn.prepareStatement("insert into votes(Cnic, age, city, vote) values(?,?,?,?); ");
				
					ps.setString(1, textcnic.getText());
					ps.setString(2,textage.getText());
					ps.setString(3, textcity.getText());
					ps.setString(4, vote);
					
					
					int x = ps.executeUpdate();
					if (x>0) {
					System.out.println("Registration successfully");
					}else {
					System.out.println("Registration Failed");
					}
				}catch(Exception e1) {
				System.out.println(e1);
				}
			}
				
				
			
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_2.setBounds(114, 467, 89, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Result");
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Result r=new Result();
				r.setVisible(true);
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton_3.setBounds(212, 467, 89, 23);
		contentPane.add(btnNewButton_3);
		
		textcnic = new JTextField();
		textcnic.setBounds(180, 129, 142, 20);
		contentPane.add(textcnic);
		textcnic.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Voter Cnic");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(40, 130, 114, 19);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Voter Age");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(40, 180, 114, 23);
		contentPane.add(lblNewLabel_1_1);
		
		textage = new JTextField();
		textage.setColumns(10);
		textage.setBounds(180, 180, 142, 20);
		contentPane.add(textage);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Voter City");
		lblNewLabel_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1.setBounds(40, 235, 114, 23);
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Candidate Parties");
		lblNewLabel_1_1_2.setForeground(Color.BLUE);
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(40, 293, 182, 23);
		contentPane.add(lblNewLabel_1_1_2);
		
		textcity = new JTextField();
		textcity.setColumns(10);
		textcity.setBounds(180, 238, 142, 20);
		contentPane.add(textcity);
	}

}
