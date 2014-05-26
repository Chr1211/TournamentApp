package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import model.Player;
import model.Tournament;
import service.Service;

public class ManageTournamentFrame extends JFrame {

	private JPanel contentPane;
	private JTextField nametxt;
	private JTextField startdatetxt;
	private JTextField endDatetxt;
	private JTextField maxplayerstxt;
	private static Service service;
	private static JList list;
	private DefaultListModel<Tournament> model;
	private static ArrayList<Tournament> tournaments = new ArrayList<Tournament>();

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
		service = Service.getInstance();
		//BACKEND loadTournaments();
		tournaments = service.getAllTournaments();
		
		
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
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(132, 217, 113, 25);
		contentPane.add(btnSaveChanges);
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				//updateTournament();
//				Evt. dispose frame
				updateJList();
			}
		});
		
		JButton btnAddPlayers = new JButton("Add Players");
		btnAddPlayers.setBounds(272, 217, 137, 25);
		contentPane.add(btnAddPlayers);
		
		model = new DefaultListModel<Tournament>();
		
		list = new JList(model);
		list.setBounds(12, 42, 198, 153);
		contentPane.add(list);
		JScrollPane scrollPane = new JScrollPane();
		list.add(scrollPane);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				//TODO
//				Set tournament info i textfields!
			}
		});
		
		updateJList();
	}
	
	public void updateJList(){
		model = new DefaultListModel<Tournament>();
		for(Tournament tournament : tournaments){
			model.addElement(tournament);
		}
		list.setModel(model);
		
		list.setSelectedIndex(0);
	}
}
