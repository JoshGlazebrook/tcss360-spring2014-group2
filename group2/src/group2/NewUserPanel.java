package group2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
/**
 * 
 * @author Mina Messak, Anh Bui, Jugbir Singh - Jay
 * @version 5.22.2014
 */
public class NewUserPanel extends JPanel {
	private JFrame frame = new JFrame("New User");
	private String userName;
	private String password;
	private User user;
	public UserManager userManager;

	/**
	 * Create the panel.
	 */
	public NewUserPanel(final UserManager theUserManager) {
		userManager = theUserManager;
		setSize(500, 500);
		setLayout(null);
		
		JLabel lblNewUser = new JLabel("New User");
		lblNewUser.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewUser.setBounds(186, 16, 127, 37);
		add(lblNewUser);
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(123, 112, 84, 20);
		add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(123, 168, 73, 20);
		add(lblPassword);
		
		final JTextField txtUserName = new JTextField();
		txtUserName.setBounds(242, 112, 146, 26);
		add(txtUserName);
		txtUserName.setColumns(10);
		
		final JPasswordField txtPassword = new JPasswordField();
		txtPassword.setBounds(242, 168, 146, 26);
		add(txtPassword);
		txtPassword.setColumns(10);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			
			/**
			 * If save button is clicked, either a user will be created or a message dialog will pop-up.
			 * @author Jugbir Singh - Jay
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				password = new String(txtPassword.getPassword());
				userName = txtUserName.getText();
				if(theUserManager.signUp(userName, password)) {
					frame.dispose();
				} else {
					showMessage();
				}
			}
		});
		btnSave.setBounds(210, 240, 69, 28);
		add(btnSave);
	}
	
	public void show(){
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/group2/logo.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		frame.setSize(500, 500);
		frame.getContentPane().add(this);
		frame.show();
	}
	
	/**
	 * Get the User.
	 * @author Jugbir Singh - Jay
	 * @return user
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * A message dialog (when username is unavailable).
	 * @author Jugbir Singh - Jay
	 */
	public void showMessage() {
		JOptionPane.showMessageDialog(this, "Username is unavailable: please select a different username");
	}
}
