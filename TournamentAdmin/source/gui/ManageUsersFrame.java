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
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.Player;
import service.Service;

public class ManageUsersFrame extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField nametxt;
	private JTextField emailtxt;
	private JTextField phoneNumbertxt;
	private JTextField passwordtxt;
	private static JList<Player> list;
	private DefaultListModel<Player> model;
	private static Service service;
	private static ArrayList<Player> players = new ArrayList<Player>();
	

	/**
	 * Launch the application.
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ManageUsersFrame frame = new ManageUsersFrame();
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
	public ManageUsersFrame() throws SQLException{
		service = Service.getInstance();
		service.loadPlayers();
		players = service.getAllPlayers();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPlayers = new JLabel("Players:");
		lblPlayers.setBounds(12, 13, 87, 16);
		contentPane.add(lblPlayers);
		
		
		model = new DefaultListModel<Player>();
		
		list = new JList<Player>(model);
		list.setBounds(12, 37, 159, 170);
		contentPane.add(list);
		JScrollPane scrollPane = new JScrollPane();
		list.add(scrollPane);
		
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
//			int i = list.getSelectedIndex();
//			nametxt.setText(players.get(i).getName());
//			emailtxt.setText(players.get(i).getEmail());
//			phoneNumbertxt.setText(players.get(i).getPhoneNumber());
//			passwordtxt.setText(players.get(i).getPassword());
				
			Player p=(Player) list.getSelectedValue();
			if(p != null){
			nametxt.setText(p.getName());
			emailtxt.setText(p.getEmail());
			phoneNumbertxt.setText(p.getPhoneNumber());
			passwordtxt.setText(p.getPassword());
			}
			
			}
		});
		

		
		
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBounds(12, 217, 97, 25);
		contentPane.add(btnBack);
		
		JButton btnSaveChanges = new JButton("Save Changes");
		btnSaveChanges.setBounds(307, 217, 113, 25);
		contentPane.add(btnSaveChanges);
		btnSaveChanges.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					service.updatePlayer(nametxt.getText(), emailtxt.getText(), phoneNumbertxt.getText(), passwordtxt.getText());
					updateJList();
					ManageUsersFrame.this.dispose();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(280, 13, 56, 16);
		contentPane.add(lblName);
		
		nametxt = new JTextField();
		nametxt.setBounds(280, 35, 140, 22);
		contentPane.add(nametxt);
		nametxt.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(280, 60, 56, 16);
		contentPane.add(lblEmail);
		
		emailtxt = new JTextField();
		emailtxt.setBounds(280, 81, 140, 22);
		contentPane.add(emailtxt);
		emailtxt.setColumns(10);
		
		JLabel lblPhonenumber = new JLabel("Phonenumber:");
		lblPhonenumber.setBounds(280, 111, 97, 16);
		contentPane.add(lblPhonenumber);
		
		phoneNumbertxt = new JTextField();
		phoneNumbertxt.setBounds(280, 129, 140, 22);
		contentPane.add(phoneNumbertxt);
		phoneNumbertxt.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(280, 157, 81, 16);
		contentPane.add(lblPassword);
		
		passwordtxt = new JTextField();
		passwordtxt.setBounds(280, 175, 140, 22);
		contentPane.add(passwordtxt);
		passwordtxt.setColumns(10);
		
		updateJList();
	}
	
	public void updateJList() throws SQLException{
		model = new DefaultListModel<Player>();
		for(Player player : players){
			model.addElement(player);
		}
		list.setModel(model);
		
		list.setSelectedIndex(0);
	}
	
	


}
