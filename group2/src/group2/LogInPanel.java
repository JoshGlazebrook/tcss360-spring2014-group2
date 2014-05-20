package group2;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LogInPanel extends JPanel {
	private NewUserPanel newUser = new NewUserPanel();
	public String userType = "null";

	/**
	 * Create the panel.
	 */
	public LogInPanel() {
		setSize(500, 500);
		setLayout(null);
	
		JPasswordField passwordField;
		JTextField usernameField;
		JLabel titleLabel = new JLabel("Welcome To Scrum It Up! ");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titleLabel.setBounds(74, 44, 352, 37);
		add(titleLabel);
		
		JButton logInBtn = new JButton("Log In");
		logInBtn.setBounds(82, 326, 115, 29);
		add(logInBtn);
		
		JButton addUserBtn = new JButton("Add User");
		addUserBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newUser.show();
			}
		});
		addUserBtn.setBounds(319, 326, 115, 29);
		add(addUserBtn);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(122, 159, 269, 92);
		add(panel2);
		panel2.setLayout(null);
		
		JLabel usernameLabel = new JLabel("User Name");
		usernameLabel.setBounds(15, 16, 87, 20);
		panel2.add(usernameLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(110, 16, 146, 26);
		panel2.add(usernameField);
		usernameField.setColumns(10);
		
		JLabel passwordLabel = new JLabel("Password");
		passwordLabel.setBounds(15, 52, 69, 20);
		panel2.add(passwordLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(110, 52, 146, 26);
		panel2.add(passwordField);
		passwordField.setColumns(10);
		
	}

}
