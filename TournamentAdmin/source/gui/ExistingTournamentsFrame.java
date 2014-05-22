package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;

public class ExistingTournamentsFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ExistingTournamentsFrame frame = new ExistingTournamentsFrame();
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
	public ExistingTournamentsFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JList tournamentList = new JList();
		tournamentList.setBounds(12, 37, 206, 219);
		contentPane.add(tournamentList);
		
		JLabel lblTournaments = new JLabel("Tournaments:");
		lblTournaments.setBounds(12, 13, 92, 16);
		contentPane.add(lblTournaments);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(12, 293, 97, 25);
		contentPane.add(btnBack);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(289, 37, 256, 219);
		contentPane.add(textArea);
		
		JLabel lblTournamentInfo = new JLabel("Tournament info:");
		lblTournamentInfo.setBounds(289, 13, 122, 16);
		contentPane.add(lblTournamentInfo);
	}
}
