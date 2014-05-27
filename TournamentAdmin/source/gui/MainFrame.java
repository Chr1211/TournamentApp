package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import service.Service;

public class MainFrame extends JFrame {


	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	@SuppressWarnings("unused")
	private static Service service;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		service = Service.getInstance();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
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
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 491, 331);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btnOpretNyTurnering = new JButton("Create new tournament");
		btnOpretNyTurnering.setBounds(12, 13, 173, 25);
		contentPane.add(btnOpretNyTurnering);
		btnOpretNyTurnering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//TODO
				CreateTournamentFrame ctf = new CreateTournamentFrame();
				ctf.setVisible(true);
			}
		});

		JButton btnAdministrerTurnering = new JButton("Manage tournament");
		btnAdministrerTurnering.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ManageTournamentFrame mtf;
				try {
					ManageTournamentFrame mtf = new ManageTournamentFrame();
					mtf.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAdministrerTurnering.setBounds(12, 94, 173, 25);
		contentPane.add(btnAdministrerTurnering);

		JButton btnEksisterendeTurneringer = new JButton("Existing tournaments");
		btnEksisterendeTurneringer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ExistingTournamentsFrame etf;
				try {
					ExistingTournamentsFrame etf = new ExistingTournamentsFrame();
					etf.setVisible(true);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnEksisterendeTurneringer.setBounds(12, 132, 173, 25);
		contentPane.add(btnEksisterendeTurneringer);

		JButton btnAdministrerBrugere = new JButton("Manage users");
		btnAdministrerBrugere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				ManageUsersFrame muf;
				try {
//					service.loadPlayers();
					ManageUsersFrame muf = new ManageUsersFrame();
					muf.setVisible(true);
					
					} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnAdministrerBrugere.setBounds(12, 231, 173, 25);
		contentPane.add(btnAdministrerBrugere);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(244, 11, 217, 209);
		contentPane.add(textArea);

		JButton btnLogUd = new JButton("Log out");
		btnLogUd.setBounds(364, 248, 97, 25);
		contentPane.add(btnLogUd);
		btnLogUd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		
		JButton btnProfileSettings = new JButton("Profile settings");
		btnProfileSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfilesettingsFrame psf = new ProfilesettingsFrame();
				psf.setVisible(true);
			}
		});
		btnProfileSettings.setBounds(12, 170, 173, 25);
		contentPane.add(btnProfileSettings);
		
		JButton btnCreateNewPlayer = new JButton("Create new Player");
		btnCreateNewPlayer.setBounds(12, 56, 173, 25);
		contentPane.add(btnCreateNewPlayer);
		btnCreateNewPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateNewPlayerFrame cnpf = new CreateNewPlayerFrame();
				cnpf.setVisible(true);
			}
		});
		
	}
}
