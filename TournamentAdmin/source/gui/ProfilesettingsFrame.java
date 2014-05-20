package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ProfilesettingsFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nametxt;
	private JTextField emailtxt;
	private JTextField phonetxt;
	private JTextField passwordtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilesettingsFrame frame = new ProfilesettingsFrame();
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
	public ProfilesettingsFrame() {
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
		
		JLabel lblPhone = new JLabel("Phone:");
		lblPhone.setBounds(12, 71, 56, 16);
		contentPane.add(lblPhone);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(12, 100, 70, 16);
		contentPane.add(lblPassword);
		
		nametxt = new JTextField();
		nametxt.setBounds(80, 10, 162, 22);
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		
		emailtxt = new JTextField();
		emailtxt.setBounds(80, 39, 162, 22);
		contentPane.add(emailtxt);
		emailtxt.setColumns(10);
		
		phonetxt = new JTextField();
		phonetxt.setBounds(80, 68, 162, 22);
		contentPane.add(phonetxt);
		phonetxt.setColumns(10);
		
		passwordtxt = new JTextField();
		passwordtxt.setBounds(80, 97, 162, 22);
		contentPane.add(passwordtxt);
		passwordtxt.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBack.setBounds(12, 217, 97, 25);
		contentPane.add(btnBack);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(121, 217, 121, 25);
		contentPane.add(btnSaveChanges);
	}

}
