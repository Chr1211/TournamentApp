package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import service.Service;
import model.Player;
import model.Tournament;

public class AddPlayerToTournamentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textSearch;
	private Player currentPlayer;
	private List<Player> allPlayers;
	private List<Player> tournamentPlayers;
	private Map<Player, Boolean> playersToBeAdded;
	private Service service;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPlayerToTournamentFrame frame = new AddPlayerToTournamentFrame(null);
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
	public AddPlayerToTournamentFrame(Tournament tournament) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		service=Service.getInstance();
		
		JList<Player> listAllPlayers = new JList<>();
		listAllPlayers.setBounds(25, 79, 189, 213);
		getContentPane().add(listAllPlayers);
		
		JList<Player> listTournamentPlayers = new JList<>();
		listTournamentPlayers.setBounds(242, 42, 175, 248);
		contentPane.add(listTournamentPlayers);
		
		JLabel lblPlayers = new JLabel("Players");
		lblPlayers.setBounds(25, 13, 56, 16);
		contentPane.add(lblPlayers);
		
		JLabel lblPlayersInTournament = new JLabel("Players In tournament");
		lblPlayersInTournament.setBounds(242, 13, 126, 16);
		contentPane.add(lblPlayersInTournament);
		
		JButton btnAddPlayer = new JButton("Add Player");
		
		

		btnAddPlayer.setBounds(71, 327, 126, 25);
		contentPane.add(btnAddPlayer);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
			}
		});
		btnSaveChanges.setBounds(290, 300, 126, 25);
		contentPane.add(btnSaveChanges);
		
		JButton btnCancelChanges = new JButton("Cancel");
		btnCancelChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnCancelChanges.setBounds(291, 327, 126, 25);
		contentPane.add(btnCancelChanges);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.setBounds(124, 41, 90, 25);
		contentPane.add(btnSearch);
		
		textSearch = new JTextField();
		textSearch.setBounds(25, 42, 103, 24);
		contentPane.add(textSearch);
		textSearch.setColumns(10);
		
		JCheckBox chckbxGameMaster = new JCheckBox("GameMaster");
		chckbxGameMaster.setBounds(113, 300, 113, 25);
		contentPane.add(chckbxGameMaster);
		
		btnAddPlayer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (currentPlayer!=null) {
					currentPlayer=listAllPlayers.getSelectedValue();
					Boolean isGameMaster=chckbxGameMaster.isSelected();
					playersToBeAdded.put(currentPlayer, isGameMaster);
					currentPlayer=null;
				}
				
				chckbxGameMaster.setSelected(false);
//				dispose();
			}
		});
	}
}
