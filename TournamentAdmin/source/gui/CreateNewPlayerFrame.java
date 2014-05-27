package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.Service;

public class CreateNewPlayerFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nametxt;
	private JTextField emailtxt;
	private JTextField phoneNumbertxt;
	private JTextField passwordtxt;
	private static Service service;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		service = Service.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewPlayerFrame frame = new CreateNewPlayerFrame();
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
	public CreateNewPlayerFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(12, 13, 56, 16);
		contentPane.add(lblName);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(12, 42, 56, 16);
		contentPane.add(lblEmail);
		
		JLabel lblPhonenumber = new JLabel("Phonenumber:");
		lblPhonenumber.setBounds(12, 71, 84, 16);
		contentPane.add(lblPhonenumber);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 100, 70, 16);
		contentPane.add(lblPassword);
		
		final JCheckBox chckbxAdmin = new JCheckBox("Admin");
		chckbxAdmin.setBounds(12, 125, 113, 25);
		contentPane.add(chckbxAdmin);
		
		nametxt = new JTextField();
		nametxt.setBounds(98, 10, 141, 22);
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		
		emailtxt = new JTextField();
		emailtxt.setBounds(98, 39, 141, 22);
		contentPane.add(emailtxt);
		emailtxt.setColumns(10);
		
		phoneNumbertxt = new JTextField();
		phoneNumbertxt.setBounds(98, 68, 141, 22);
		contentPane.add(phoneNumbertxt);
		phoneNumbertxt.setColumns(10);
		
		passwordtxt = new JTextField();
		passwordtxt.setBounds(98, 97, 141, 22);
		contentPane.add(passwordtxt);
		passwordtxt.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 217, 97, 25);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		
		JButton btnCreatePlayer = new JButton("Create Player");
		btnCreatePlayer.setBounds(301, 217, 119, 25);
		contentPane.add(btnCreatePlayer);
		btnCreatePlayer.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					service.createNewPlayer(emailtxt.getText(), nametxt.getText(), phoneNumbertxt.getText(), passwordtxt.getText(), false);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				emailtxt.setText("");
				nametxt.setText("");
				phoneNumbertxt.setText("");
				passwordtxt.setText("");
				chckbxAdmin.setSelected(false);
			}
		});
	}
}
