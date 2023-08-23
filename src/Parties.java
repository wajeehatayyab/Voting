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
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Parties extends JFrame {

	private JPanel contentPane;
	JLabel lblNewLabel_1_1_2;
	JLabel lblNewLabel_1_1_1_2;
	JLabel lblNewLabel_1_2;
	JLabel lblNewLabel_1_1_1_1_1;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parties frame = new Parties();
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
	public Parties() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 457, 486);
		contentPane = new JPanel();
		contentPane.setBackground(Color.PINK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblVoter = new JLabel("Party information");
		lblVoter.setForeground(Color.BLUE);
		lblVoter.setBounds(104, 11, 220, 38);
		lblVoter.setFont(new Font("Tahoma", Font.BOLD, 23));
		contentPane.add(lblVoter);
		
		JLabel lblNewLabel_1 = new JLabel("Party name");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(23, 91, 106, 28);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Party Symbol");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setBounds(23, 154, 120, 28);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Party Abbrevition");
		lblNewLabel_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1.setBounds(23, 221, 144, 28);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Party Leader");
		lblNewLabel_1_1_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1_1_1.setBounds(23, 285, 144, 28);
		lblNewLabel_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		contentPane.add(lblNewLabel_1_1_1_1);
		
		JButton btnNewButton_1 = new JButton("Result");
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Result v=new Result();
				v.setVisible(true);

			}
		});
		btnNewButton_1.setBounds(232, 385, 89, 23);
		contentPane.add(btnNewButton_1);
		
		
		
		JButton btnNewButton_3 = new JButton("Exit");
		btnNewButton_3.setForeground(Color.BLUE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnNewButton_3.setBounds(10, 385, 89, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_3_1 = new JButton("Back");
		btnNewButton_3_1.setForeground(Color.BLUE);
		btnNewButton_3_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PartyLogin v=new PartyLogin();
				v.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3_1.setBounds(122, 385, 89, 23);
		contentPane.add(btnNewButton_3_1);
		
		JButton btnNewButton_3_2 = new JButton("Logout");
		btnNewButton_3_2.setForeground(Color.BLUE);
		btnNewButton_3_2.setFont(new Font("Tahoma", Font.BOLD, 13));
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
		btnNewButton_3_2.setBounds(344, 385, 89, 23);
		contentPane.add(btnNewButton_3_2);
		
		lblNewLabel_1_2 = new JLabel("Party name is");
		lblNewLabel_1_2.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(193, 91, 175, 28);
		contentPane.add(lblNewLabel_1_2);
		
		lblNewLabel_1_1_1_1_1 = new JLabel("Party Leader is");
		lblNewLabel_1_1_1_1_1.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_1_1.setBounds(193, 285, 144, 28);
		contentPane.add(lblNewLabel_1_1_1_1_1);
		
		 lblNewLabel_1_1_1_2 = new JLabel("Party Abbrevition is");
		 lblNewLabel_1_1_1_2.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_1_2.setBounds(193, 221, 199, 28);
		contentPane.add(lblNewLabel_1_1_1_2);
		
		lblNewLabel_1_1_2 = new JLabel("Party Symbol is");
		lblNewLabel_1_1_2.setForeground(new Color(100, 149, 237));
		lblNewLabel_1_1_2.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel_1_1_2.setBounds(193, 154, 168, 28);
		contentPane.add(lblNewLabel_1_1_2);
	}

}
