package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2292455670620751734L;
	private JPanel contentPane;
	private JTextField emailtxt;
	private JTextField pwtxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginFrame frame = new LoginFrame();
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
	public LoginFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 420, 318);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);


		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO 
				MainFrame mf = new MainFrame();
				mf.setVisible(true);

			}
		});
		btnLogin.setBounds(113, 153, 97, 25);
		contentPane.add(btnLogin);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(78, 69, 56, 16);
		contentPane.add(lblEmail);

		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(78, 98, 72, 16);
		contentPane.add(lblPassword);

		emailtxt = new JTextField();
		emailtxt.setBounds(146, 66, 116, 22);
		contentPane.add(emailtxt);
		emailtxt.setColumns(10);

		pwtxt = new JPasswordField();
		pwtxt.setBounds(146, 95, 116, 22);
		contentPane.add(pwtxt);
		pwtxt.setColumns(10);

//		if(emailtxt.getText().equals("") && pwtxt.getText().equals("")){
//			btnLogin.setEnabled(false);
//		} else {
//			btnLogin.setEnabled(true);
//		}


	}
}
