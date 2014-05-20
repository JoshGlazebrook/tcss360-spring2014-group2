package group2;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class NewUserPanel extends JPanel {
	private JTextField txtName;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private JTextField txtAddress;

	/**
	 * Create the panel.
	 */
	public NewUserPanel() {
		setSize(500, 500);
		setLayout(null);
		
		JLabel lblNewUser = new JLabel("New User");
		lblNewUser.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewUser.setBounds(186, 16, 127, 37);
		add(lblNewUser);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(123, 112, 69, 20);
		add(lblName);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(123, 168, 84, 20);
		add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(123, 227, 73, 20);
		add(lblPassword);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setBounds(123, 285, 63, 20);
		add(lblAddress);
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setBounds(123, 344, 78, 20);
		add(lblUserType);
		
		txtName = new JTextField();
		txtName.setBounds(242, 109, 146, 26);
		add(txtName);
		txtName.setColumns(10);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(242, 165, 146, 26);
		add(txtUserName);
		txtUserName.setColumns(10);
		
		txtPassword = new JTextField();
		txtPassword.setBounds(242, 224, 146, 26);
		add(txtPassword);
		txtPassword.setColumns(10);
		
		txtAddress = new JTextField();
		txtAddress.setBounds(242, 282, 146, 26);
		add(txtAddress);
		txtAddress.setColumns(10);
		
		JComboBox UserTypes = new JComboBox();
		UserTypes.setModel(new DefaultComboBoxModel(new String[] {"Author", "Reviewer ", "Sub Program Chair", "Program Chair"}));
		UserTypes.setBounds(242, 341, 146, 26);
		add(UserTypes);

	}
}
