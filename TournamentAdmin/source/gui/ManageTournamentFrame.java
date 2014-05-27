package gui;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
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
import javax.swing.JList;
import javax.swing.ListSelectionModel;

import model.Tournament;
import service.Service;

public class ManageTournamentFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nametxt;
	private JTextField startdatetxt;
	private JTextField endDatetxt;
	private JTextField maxplayerstxt;
	private static Service service;
	private static JList<Tournament> list;
	private DefaultListModel<Tournament> model;
	private static ArrayList<Tournament> tournaments = new ArrayList<Tournament>();
	private JTextField specialRuletxt;

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
	 * @throws SQLException 
	 */
	public ManageTournamentFrame() throws SQLException {
		service = Service.getInstance();
		service.loadTournaments();
		tournaments = service.getAllTournaments();


		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 479, 315);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblTournaments = new JLabel("Tournaments:");
		lblTournaments.setBounds(12, 13, 101, 16);
		contentPane.add(lblTournaments);

		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(272, 0, 56, 16);
		contentPane.add(lblName);

		nametxt = new JTextField();
		nametxt.setBounds(272, 13, 137, 22);
		contentPane.add(nametxt);
		nametxt.setColumns(10);

		JLabel lblStartDate = new JLabel("Start Date:");
		lblStartDate.setBounds(272, 43, 82, 16);
		contentPane.add(lblStartDate);

		startdatetxt = new JTextField();
		startdatetxt.setBounds(272, 58, 137, 22);
		contentPane.add(startdatetxt);
		startdatetxt.setColumns(10);

		JLabel lblEndDate = new JLabel("End Date:");
		lblEndDate.setBounds(272, 90, 68, 16);
		contentPane.add(lblEndDate);

		endDatetxt = new JTextField();
		endDatetxt.setBounds(272, 108, 137, 22);
		contentPane.add(endDatetxt);
		endDatetxt.setColumns(10);

		JLabel lblMaxPlayers = new JLabel("Max players:");
		lblMaxPlayers.setBounds(272, 131, 82, 16);
		contentPane.add(lblMaxPlayers);

		maxplayerstxt = new JTextField();
		maxplayerstxt.setBounds(272, 151, 137, 22);
		contentPane.add(maxplayerstxt);
		maxplayerstxt.setColumns(10);

		model = new DefaultListModel<Tournament>();

		list = new JList<Tournament>(model);
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
				Tournament t = (Tournament) list.getSelectedValue();
				if(t != null){
					nametxt.setText(t.getName());
					startdatetxt.setText(t.getStartDate());
					endDatetxt.setText(t.getEndDate());
					maxplayerstxt.setText(t.getMaxPlayers() + "");
					specialRuletxt.setText(t.getSpecialRule());
				}
			}
		});


		JButton btnBack = new JButton("Back");
		btnBack.setBounds(12, 232, 97, 25);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(169, 232, 113, 25);
		contentPane.add(btnSaveChanges);
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//TODO
				try {
					service.updateTournament(nametxt.getText(), startdatetxt.getText(), endDatetxt.getText(), Integer.parseInt(maxplayerstxt.getText()), specialRuletxt.getText());
					updateJList();
					ManageTournamentFrame.this.dispose();
				} catch (NumberFormatException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnAddPlayers = new JButton("Add Players");
		btnAddPlayers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Tournament t=(Tournament) list.getSelectedValue();
				if (t!=null) {
					AddPlayerToTournamentFrame aptt;
					try {
						aptt = new AddPlayerToTournamentFrame(t);
						aptt.setVisible(true);
					} catch (ClassNotFoundException | SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			}
		});
		btnAddPlayers.setBounds(312, 232, 137, 25);
		contentPane.add(btnAddPlayers);


		JLabel lblSpecialRule = new JLabel("Special Rule:");
		lblSpecialRule.setBounds(272, 179, 82, 16);
		contentPane.add(lblSpecialRule);

		specialRuletxt = new JTextField();
		specialRuletxt.setBounds(272, 197, 137, 22);
		contentPane.add(specialRuletxt);
		specialRuletxt.setColumns(10);


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
