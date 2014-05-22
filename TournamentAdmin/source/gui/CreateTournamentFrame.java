package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

import service.Service;

public class CreateTournamentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nametxt;
	private JTextField startDatetxt;
	private JTextField maxplayerstxt;
	private JTextField textField;
	private static Service service;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		service = Service.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateTournamentFrame frame = new CreateTournamentFrame();
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
	public CreateTournamentFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 566, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setBounds(12, 13, 56, 16);
		contentPane.add(lblNewLabel);
		
		JLabel lblStartDate = new JLabel("Start date:");
		lblStartDate.setBounds(12, 42, 74, 16);
		contentPane.add(lblStartDate);
		
		JLabel lblMaxPlayers = new JLabel("Max players:");
		lblMaxPlayers.setBounds(12, 100, 74, 16);
		contentPane.add(lblMaxPlayers);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 271, 97, 25);
		contentPane.add(btnBack);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(439, 271, 97, 25);
		contentPane.add(btnCreate);
		btnCreate.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					service.createNewTournament(nametxt.getText(), startDatetxt.getText(), textField.getText(), maxplayerstxt.getText());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				nametxt.setText("");
				startDatetxt.setText("");
				textField.setText("");
				maxplayerstxt.setText("");
			}
		});
		
		JButton btnAddAllGamemasters = new JButton("Add Alt Gamemasters");
		btnAddAllGamemasters.setBounds(191, 271, 162, 25);
		contentPane.add(btnAddAllGamemasters);
		
		nametxt = new JTextField();
		nametxt.setBounds(94, 10, 198, 22);
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		
		startDatetxt = new JTextField();
		startDatetxt.setBounds(94, 39, 198, 22);
		contentPane.add(startDatetxt);
		startDatetxt.setColumns(10);
		
		maxplayerstxt = new JTextField();
		maxplayerstxt.setBounds(94, 97, 198, 22);
		contentPane.add(maxplayerstxt);
		maxplayerstxt.setColumns(10);
		
		JLabel lblEndDate = new JLabel("End date:");
		lblEndDate.setBounds(12, 71, 74, 16);
		contentPane.add(lblEndDate);
		
		textField = new JTextField();
		textField.setBounds(94, 68, 198, 22);
		contentPane.add(textField);
		textField.setColumns(10);
	}

}
