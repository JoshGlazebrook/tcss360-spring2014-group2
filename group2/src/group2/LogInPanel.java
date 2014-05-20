package group2;

import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class LogInPanel extends JPanel {
	public String userType = "null";
	
	private JPasswordField passwordField;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public LogInPanel() {
		
		setSize(500, 500);
		
		setLayout(null);
	
		
		JLabel label = new JLabel("Welcome To Scrum It Up! ");
		label.setFont(new Font("Tahoma", Font.PLAIN, 30));
		label.setBounds(74, 44, 352, 37);
		add(label);
		
		JButton logInBtn = new JButton("Log In");
		logInBtn.setBounds(82, 326, 115, 29);
		add(logInBtn);
		
		JButton button_1 = new JButton("Add User");
		button_1.setBounds(319, 326, 115, 29);
		add(button_1);
		
		JPanel panel = new JPanel();
		panel.setBounds(122, 159, 269, 92);
		add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("User Name");
		label_1.setBounds(15, 16, 87, 20);
		panel.add(label_1);
		
		textField = new JTextField();
		textField.setBounds(110, 16, 146, 26);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("Password");
		label_2.setBounds(15, 52, 69, 20);
		panel.add(label_2);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(110, 52, 146, 26);
		panel.add(passwordField);
		passwordField.setColumns(10);

	}

}
