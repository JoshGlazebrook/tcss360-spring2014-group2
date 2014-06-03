package group2;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JComboBox;
/**
 * 
 * @author Mina Messak, Anh Bui
 * @version 5.22.2014
 */
public class LogInPanel extends JPanel {
	private ConferenceManager conferences = new ConferenceManager();
	public UserManager userManager = new UserManager();
	private NewUserPanel newUser = new NewUserPanel(userManager);
	private ConferencePanel conferencePanel;
	private final JPasswordField passwordField = new JPasswordField();
	private final JTextField usernameField = new JTextField();
	private String userName = "";
	private String password = "";
	
	/**
	 * Create the panel.
	 */
	public LogInPanel(final MainGUI gui) {
		setSize(500, 500);
		setLayout(null);
	
		
		JLabel titleLabel = new JLabel("Welcome To Scrum It Up! ");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titleLabel.setBounds(74, 44, 352, 37);
		add(titleLabel);
		
		
		JButton addUserBtn = new JButton("Add User");
		addUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clearTxt();
				newUser = new NewUserPanel(userManager);
				newUser.show();
			}
		});
		addUserBtn.setBounds(250, 326, 87, 28);
		add(addUserBtn);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(115, 159, 269, 138);
		add(panel2);
		panel2.setLayout(null);
		
		JLabel usernameLabel = new JLabel("User Name");
		usernameLabel.setBounds(15, 16, 87, 20);
		panel2.add(usernameLabel);
		
		usernameField.setBounds(110, 16, 146, 26);
		panel2.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(15, 52, 69, 20);
		panel2.add(passwordLabel);
		
		passwordField.setBounds(110, 52, 146, 26);
		panel2.add(passwordField);
		passwordField.setColumns(10);
		
		JButton logInBtn = new JButton("Log In");
		logInBtn.setBounds(150, 326, 68, 28);
		logInBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userName = usernameField.getText();
			    password = new String(passwordField.getPassword());
				if (!userManager.findID(userName, password)) {
					popMsg();
				} else {
					conferencePanel = new ConferencePanel(conferences, gui, new User(userName, password));
					gui.setPanel(conferencePanel);
				}
			}
		});
		add(logInBtn);
		
	    /*
		JLabel conferenceLabel = new JLabel("Confrence:");
		conferenceLabel.setBounds(15, 91, 69, 16);
		panel2.add(conferenceLabel);
		
		JComboBox conferenceComboBox = new JComboBox();
		conferenceComboBox.setBounds(110, 86, 146, 26);
		panel2.add(conferenceComboBox);*/
		
		/*
		JButton newConferenceBtn = new JButton("New Conference");
		newConferenceBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				newConferencePanel.show();
			}
		});
		newConferenceBtn.setBounds(186, 326, 127, 28);
		add(newConferenceBtn);*/
	}
	
	public void clearTxt() {
		usernameField.setText("");
		passwordField.setText("");
	}
	
	private void popMsg() {
		clearTxt();
		JOptionPane.showMessageDialog(this, "Wrong ID or password!");
	}
	
	public UserManager getUserManager() {
		return userManager;
	}
}
