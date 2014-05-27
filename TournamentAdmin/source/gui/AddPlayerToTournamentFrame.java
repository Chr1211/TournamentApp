package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import service.Service;
import model.Player;
import model.Tournament;

public class AddPlayerToTournamentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textSearch;
	private Player currentPlayer;
	private Map<Player, Boolean> playersToBeAdded;
	private Service service;
	
	JList<Player> listAllPlayers;
	JList<Player> listTournamentPlayers;
	JLabel lblPlayers;
	JLabel lblPlayersInTournament;

	JButton btnAddPlayer;
	JButton btnSaveChanges;
	JButton btnCancelChanges;
	Tournament tournament;
	
	DefaultListModel<Player> modelAllplayers;
	DefaultListModel<Player> modelPlayersInTournament;
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
	 * @throws SQLException 
	 * @throws ClassNotFoundException 
	 */
	public AddPlayerToTournamentFrame(Tournament tournament) throws ClassNotFoundException, SQLException {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 510, 422);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		service=Service.getInstance();
		this.tournament=tournament;
		playersToBeAdded=new HashMap<>();
		
		listAllPlayers = new JList<>();
		listAllPlayers.setBounds(25, 79, 189, 213);
		getContentPane().add(listAllPlayers);
		
		listTournamentPlayers = new JList<>();
		listTournamentPlayers.setBounds(242, 42, 175, 248);
		contentPane.add(listTournamentPlayers);
		
		modelPlayersInTournament=new DefaultListModel<>();
		FillModel(service.getPlayersInTournament(tournament.getName()), modelPlayersInTournament);
		listTournamentPlayers.setModel(modelPlayersInTournament);
		
		modelAllplayers=new DefaultListModel<>();
		FillModel(service.getPlayerNotInTournament(tournament.name), modelAllplayers);
		listAllPlayers.setModel(modelAllplayers);
		
		
		lblPlayers = new JLabel("Players");
		lblPlayers.setBounds(25, 13, 56, 16);
		contentPane.add(lblPlayers);
		
		lblPlayersInTournament = new JLabel("Players In tournament");
		lblPlayersInTournament.setBounds(242, 13, 126, 16);
		contentPane.add(lblPlayersInTournament);
		
		
		
		
		btnAddPlayer = new JButton("Add Player");
		
		

		btnAddPlayer.setBounds(71, 327, 126, 25);
		contentPane.add(btnAddPlayer);
		
		btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				for (Entry<Player, Boolean> playerEntry: playersToBeAdded.entrySet()) {
					int gm=0;
					if (playerEntry.getValue()) {
						gm=1;
					}
					
					
					try {
						service.addPlayerToTournament(playerEntry.getKey().getEmail(), tournament.name, gm);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				dispose();
			}
		});
		btnSaveChanges.setBounds(290, 300, 126, 25);
		contentPane.add(btnSaveChanges);
		
		btnCancelChanges = new JButton("Cancel");
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
				currentPlayer=listAllPlayers.getSelectedValue();
				if (currentPlayer!=null) {
					currentPlayer=listAllPlayers.getSelectedValue();
					Boolean isGameMaster=chckbxGameMaster.isSelected();
					playersToBeAdded.put(currentPlayer, isGameMaster);
					modelAllplayers.removeElement(currentPlayer);
					modelPlayersInTournament.addElement(currentPlayer);
					currentPlayer=null;
					chckbxGameMaster.setSelected(false);
				}
			}
		});
	}
	
	private void FillModel(List<Player> players, DefaultListModel<Player> model) {
		for (Player p: players) {
			model.addElement(p);
		}
	}
}
