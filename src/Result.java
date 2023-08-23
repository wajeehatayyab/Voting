import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class Result extends JFrame {

	private JPanel contentPane;
	private JTextField textppp;
	private JTextField textFpmln;
	private JTextField textpmlq;
	private JTextField textmqm;
	private JTextField textanp;
	private JTextField textwinner;
	private JTextField textpti;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Result frame = new Result();
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
	public Result() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 581, 551);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setForeground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		JButton btnNewButton = new JButton("Election Result");
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBounds(199, 448, 202, 23);
		btnNewButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent e) {			   
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
					Statement stmt = conn.createStatement();
					 
					ArrayList listNames = new ArrayList();
					 
					String sql="Select vote from votes ";
					ResultSet rs=stmt.executeQuery(sql);
					while (rs.next()) {
						listNames.add(rs.getString("vote"));	
						
					}
					System.out.println(listNames);
					listNames.contains("PPP");
					int PPP = Collections.frequency(listNames, "PPP");	
					System.out.println(PPP);
					int PTI = Collections.frequency(listNames, "PTI");	
					System.out.println(PTI);
					int MQM = Collections.frequency(listNames, "MQM");	
					System.out.println(MQM);
					int ANP = Collections.frequency(listNames, "ANP");	
					System.out.println(ANP);
					int PMLQ = Collections.frequency(listNames, "PML (Q)");	
					System.out.println(PMLQ);
					int PMLN = Collections.frequency(listNames, "PML N");	
					System.out.println(PMLN);
					
					
					
					int large = 0;
					if(PPP > PTI) {
					    large = PPP;
					    textwinner.setText("PPP  has won"); 
					}else {
					    large = PTI;
					    textwinner.setText("PTI  has won");   
					}
					if(MQM > large) {
					    large = MQM;
					    textwinner.setText("MQM  has won"); 
					}
					if(ANP > large) {
					    large = ANP;
					    textwinner.setText("ANP  has won"); 
					}
					if(PMLN > large) {
					    large = PMLN;
					    textwinner.setText(" PML N  has won");    
					}
					if(PMLQ> large) {
					    large = PMLQ;
					    textwinner.setText("PML(Q) has won");
					}
					textpti.setText(String.valueOf(PTI));
					textppp.setText(String.valueOf(PPP));	
					textFpmln.setText(String.valueOf(PMLN));	
					textpmlq.setText(String.valueOf(PMLQ));	
					textanp.setText(String.valueOf(ANP));	
					textmqm.setText(String.valueOf(MQM));	
						
					  
			       
				}catch(Exception e1) {
				System.out.println(e1);
				}
		
}
			
		});
		contentPane.setLayout(null);
		contentPane.add(btnNewButton);
		
		JLabel lblElectionResult = new JLabel("Election Result");
		lblElectionResult.setForeground(Color.BLUE);
		lblElectionResult.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblElectionResult.setBounds(200, 11, 220, 46);
		contentPane.add(lblElectionResult);
		
		JLabel lblNewLabel_1 = new JLabel("PTI Votes");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1.setBounds(26, 113, 99, 25);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PPP Votes");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(26, 155, 99, 25);
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("PML N Votes");
		lblNewLabel_1_2.setForeground(Color.BLUE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(26, 203, 110, 25);
		contentPane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("PML Q Votes");
		lblNewLabel_1_3.setForeground(Color.BLUE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(26, 251, 110, 25);
		contentPane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("MQM Votes");
		lblNewLabel_1_4.setForeground(Color.BLUE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(26, 304, 99, 25);
		contentPane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("ANP Votes");
		lblNewLabel_1_5.setForeground(Color.BLUE);
		lblNewLabel_1_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(26, 352, 99, 25);
		contentPane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("Winner");
		lblNewLabel_1_6.setForeground(Color.BLUE);
		lblNewLabel_1_6.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(26, 404, 99, 25);
		contentPane.add(lblNewLabel_1_6);
		
		textppp = new JTextField();
		textppp.setColumns(10);
		textppp.setBounds(199, 159, 225, 20);
		contentPane.add(textppp);
		
		textFpmln = new JTextField();
		textFpmln.setColumns(10);
		textFpmln.setBounds(199, 203, 225, 20);
		contentPane.add(textFpmln);
		
		textpmlq = new JTextField();
		textpmlq.setColumns(10);
		textpmlq.setBounds(195, 255, 225, 20);
		contentPane.add(textpmlq);
		
		textmqm = new JTextField();
		textmqm.setColumns(10);
		textmqm.setBounds(195, 308, 225, 20);
		contentPane.add(textmqm);
		
		textanp = new JTextField();
		textanp.setColumns(10);
		textanp.setBounds(195, 352, 225, 20);
		contentPane.add(textanp);
		
		textwinner = new JTextField();
		textwinner.setColumns(10);
		textwinner.setBounds(199, 404, 225, 20);
		contentPane.add(textwinner);
		
		textpti = new JTextField();
		textpti.setColumns(10);
		textpti.setBounds(195, 117, 225, 20);
		contentPane.add(textpti);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome r=new Welcome();
				r.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setBounds(36, 448, 89, 23);
		contentPane.add(btnNewButton_1);
	}
}
