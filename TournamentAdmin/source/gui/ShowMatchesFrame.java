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
import javax.swing.JList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

import model.Match;
import service.Service;

public class ShowMatchesFrame extends JFrame {

	private JPanel contentPane;
	private static Service service;
	private DefaultListModel<Match> model;
	private static ArrayList<Match> matches = new ArrayList<Match>();
	private JList<Match> matchList;
	private JComboBox comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShowMatchesFrame frame = new ShowMatchesFrame();
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
	public ShowMatchesFrame() {
		service = Service.getInstance();
		//		matches = service.getAllMatches();


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		model = new DefaultListModel<Match>();

		matchList = new JList<Match>(model);
		matchList.setBounds(12, 38, 183, 166);
		contentPane.add(matchList);
		JScrollPane scrollPane = new JScrollPane();
		matchList.add(scrollPane);
		matchList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		matchList.addListSelectionListener(new ListSelectionListener() {
			@Override
			public void valueChanged(ListSelectionEvent arg0) {
				if(matchList.getSelectedIndex() != -1 && matches.size() > 0){
					int index = matchList.getSelectedIndex();
					
					
					
					
				}
			}
		});

		comboBox = new JComboBox();
		comboBox.setBounds(251, 35, 149, 25);
		contentPane.add(comboBox);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 217, 97, 25);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}

		});

		JButton btnSelectWinner = new JButton("Select Winner");
		btnSelectWinner.setBounds(293, 217, 127, 25);
		contentPane.add(btnSelectWinner);
		btnSelectWinner.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//				TODO
			}
		});


		JLabel lblPlayers = new JLabel("Players:");
		lblPlayers.setBounds(251, 6, 56, 16);
		contentPane.add(lblPlayers);

		JLabel lblMatches = new JLabel("Matches:");
		lblMatches.setBounds(12, 9, 56, 16);
		contentPane.add(lblMatches);

		updateJList();
	}

	public void updateJList(){
		for(Match match : matches){
			model.addElement(match);
		}
		matchList.setModel(model);
		matchList.setSelectedIndex(0);
		//		if(matches.size() > 0){
		//			matchList.setSelectedIndex(0);
		//		}

	}

}
