package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextArea;

public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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
				ManageTournamentFrame mtf = new ManageTournamentFrame();
				mtf.setVisible(true);
			}
		});
		btnAdministrerTurnering.setBounds(12, 51, 173, 25);
		contentPane.add(btnAdministrerTurnering);

		JButton btnEksisterendeTurneringer = new JButton("Existing tournaments");
		btnEksisterendeTurneringer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ExistingTournamentsFrame etf = new ExistingTournamentsFrame();
				etf.setVisible(true);
			}
		});
		btnEksisterendeTurneringer.setBounds(12, 89, 173, 25);
		contentPane.add(btnEksisterendeTurneringer);

		JButton btnAdministrerBrugere = new JButton("Manage users");
		btnAdministrerBrugere.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ManageUsersFrame muf = new ManageUsersFrame();
				muf.setVisible(true);
			}
		});
		btnAdministrerBrugere.setBounds(12, 195, 173, 25);
		contentPane.add(btnAdministrerBrugere);

		JTextArea textArea = new JTextArea();
		textArea.setBounds(244, 11, 217, 209);
		contentPane.add(textArea);

		JButton btnLogUd = new JButton("Log out");
		btnLogUd.setBounds(364, 248, 97, 25);
		contentPane.add(btnLogUd);
		
		JButton btnProfileSettings = new JButton("Profile settings");
		btnProfileSettings.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ProfilesettingsFrame psf = new ProfilesettingsFrame();
				psf.setVisible(true);
			}
		});
		btnProfileSettings.setBounds(12, 131, 173, 25);
		contentPane.add(btnProfileSettings);
		btnLogUd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//IKKE SIKKERT DET ER HIDE DER SKAL BRUGES:
				MainFrame.this.hide();

			}
		});
	}



}
