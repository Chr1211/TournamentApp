package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class ManageTournamentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nametxt;
	private JTextField startdatetxt;
	private JTextField endDatetxt;
	private JTextField maxplayerstxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageTournamentFrame frame = new ManageTournamentFrame();
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
	public ManageTournamentFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTournaments = new JLabel("Tournaments:");
		lblTournaments.setBounds(12, 13, 101, 16);
		contentPane.add(lblTournaments);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(272, 13, 56, 16);
		contentPane.add(lblName);
		
		nametxt = new JTextField();
		nametxt.setBounds(272, 31, 137, 22);
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		
		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(272, 55, 82, 16);
		contentPane.add(lblStartDate);
		
		startdatetxt = new JTextField();
		startdatetxt.setBounds(272, 77, 137, 22);
		contentPane.add(startdatetxt);
		startdatetxt.setColumns(10);
		
		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setBounds(272, 102, 68, 16);
		contentPane.add(lblEndDate);
		
		endDatetxt = new JTextField();
		endDatetxt.setBounds(272, 119, 137, 22);
		contentPane.add(endDatetxt);
		endDatetxt.setColumns(10);
		
		JLabel lblMaxPlayers = new JLabel("Max players:");
		lblMaxPlayers.setBounds(272, 143, 82, 16);
		contentPane.add(lblMaxPlayers);
		
		maxplayerstxt = new JTextField();
		maxplayerstxt.setBounds(272, 160, 137, 22);
		contentPane.add(maxplayerstxt);
		maxplayerstxt.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 217, 97, 25);
		contentPane.add(btnBack);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(132, 217, 113, 25);
		contentPane.add(btnSaveChanges);
		
		JButton btnAddPlayers = new JButton("Add Players");
		btnAddPlayers.setBounds(272, 217, 137, 25);
		contentPane.add(btnAddPlayers);
		
		JComboBox tournamentscBox = new JComboBox();
		tournamentscBox.setBounds(12, 42, 137, 22);
		contentPane.add(tournamentscBox);
	}
}
