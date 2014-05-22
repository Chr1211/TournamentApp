package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

public class ManageUsersFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUsersFrame frame = new ManageUsersFrame();
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
	public ManageUsersFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlayers = new JLabel("Players:");
		lblPlayers.setBounds(12, 13, 87, 16);
		contentPane.add(lblPlayers);
		
		JList list = new JList();
		list.setBounds(12, 37, 159, 170);
		contentPane.add(list);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(12, 217, 97, 25);
		contentPane.add(btnBack);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(307, 217, 113, 25);
		contentPane.add(btnSaveChanges);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(280, 13, 56, 16);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setBounds(280, 35, 140, 22);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(280, 60, 56, 16);
		contentPane.add(lblEmail);
		
		textField_1 = new JTextField();
		textField_1.setBounds(280, 81, 140, 22);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblPhonenumber = new JLabel("Phonenumber:");
		lblPhonenumber.setBounds(280, 111, 97, 16);
		contentPane.add(lblPhonenumber);
		
		textField_2 = new JTextField();
		textField_2.setBounds(280, 129, 140, 22);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(280, 157, 81, 16);
		contentPane.add(lblPassword);
		
		textField_3 = new JTextField();
		textField_3.setBounds(280, 175, 140, 22);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
	}

}
