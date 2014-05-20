package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;

public class CreateTournamentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nametxt;
	private JTextField startDatetxt;
	private JTextField maxplayerstxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
		lblMaxPlayers.setBounds(12, 71, 74, 16);
		contentPane.add(lblMaxPlayers);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 271, 97, 25);
		contentPane.add(btnBack);
		
		JButton btnCreate = new JButton("Create");
		btnCreate.setBounds(439, 271, 97, 25);
		contentPane.add(btnCreate);
		
		JButton btnAddAllGamemasters = new JButton("Add All Gamemasters");
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
		maxplayerstxt.setBounds(94, 71, 198, 22);
		contentPane.add(maxplayerstxt);
		maxplayerstxt.setColumns(10);
	}

}
