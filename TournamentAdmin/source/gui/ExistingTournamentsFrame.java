package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Tournament;
import service.Service;

public class ExistingTournamentsFrame extends JFrame {

	private JPanel contentPane;
	private static Service service;
	private DefaultListModel<Tournament> model;
	private static ArrayList<Tournament> existingTournaments = new ArrayList<Tournament>();
	private JList<Tournament> tournamentList;

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
	 * @throws SQLException 
	 */
	public ExistingTournamentsFrame() throws SQLException {
		service = Service.getInstance();
		service.loggedInTournaments();
		service.getAllLoggedTournaments();
		existingTournaments = service.getAllLoggedTournaments();


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 595, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JTextArea textArea = new JTextArea();
		textArea.setBounds(289, 37, 256, 219);
		contentPane.add(textArea);
		textArea.setEditable(false);

		model = new DefaultListModel<Tournament>();

		tournamentList = new JList<Tournament>(model);
		tournamentList.setBounds(12, 37, 206, 219);
		contentPane.add(tournamentList);
		JScrollPane scrollPane = new JScrollPane();
		tournamentList.add(scrollPane);
		tournamentList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tournamentList.addListSelectionListener(new ListSelectionListener() {

			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(tournamentList.getSelectedIndex() != -1 && existingTournaments.size() > 0){
					int index = tournamentList.getSelectedIndex();


					textArea.setText("Name: " + existingTournaments.get(index).getName()+ '\n' + 
							"Start Date: " + existingTournaments.get(index).getStartDate() + '\n' + 
							"End date: " + existingTournaments.get(index).getEndDate() + '\n' + 
							"Max players: " + existingTournaments.get(index).getMaxPlayers() + '\n' + 
							"Special Rules: " + existingTournaments.get(index).getSpecialRule());
				}

			}
		});

		JLabel lblTournaments = new JLabel("Tournaments:");
		lblTournaments.setBounds(12, 13, 92, 16);
		contentPane.add(lblTournaments);

		JLabel lblTournamentInfo = new JLabel("Tournament info:");
		lblTournamentInfo.setBounds(289, 13, 122, 16);
		contentPane.add(lblTournamentInfo);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				resetJList();
				dispose();
			}
		});
		btnBack.setBounds(12, 293, 97, 25);
		contentPane.add(btnBack);

		updateJList();

	}

	public void resetJList(){
//		for(int i = 0; i < existingTournaments.size(); i++){
//			if(existingTournaments.size() > 0){
//				model.clear();
//			}
//		}
	}


	public void updateJList(){

		for(Tournament tournament : existingTournaments){
			model.addElement(tournament);
		}
		tournamentList.setModel(model);
		if(existingTournaments.size() > 0){
			tournamentList.setSelectedIndex(0);
		}

	}


}
