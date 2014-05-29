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
 * @author Mina Messak
 * @version 5.22.2014
 */
public class NewUserPanel extends JPanel {
	private JFrame frame = new JFrame("New User");
	//private JTextField txtName;
	private String userName;
	private String password;
	private User user;
	public UserManager userManager;
	private ConferencePanel conferencePanel = new ConferencePanel();

	/**
	 * Create the panel.
	 */
	public NewUserPanel(UserManager theUserManager) {
		userManager = theUserManager;
		setSize(500, 500);
		setLayout(null);
		
		JLabel lblNewUser = new JLabel("New User");
		lblNewUser.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewUser.setBounds(186, 16, 127, 37);
		add(lblNewUser);
		/*
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(123, 112, 69, 20);
		add(lblName);*/
		
		JLabel lblUserName = new JLabel("User Name:");
		lblUserName.setBounds(123, 168, 84, 20);
		add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setBounds(123, 227, 73, 20);
		add(lblPassword);
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setBounds(123, 276, 78, 20);
		add(lblUserType);
		
		/*txtName = new JTextField();
		txtName.setBounds(242, 109, 146, 26);
		add(txtName);
		txtName.setColumns(10);*/
		
		JTextField txtUserName = new JTextField();
		txtUserName.setBounds(242, 165, 146, 26);
		add(txtUserName);
		txtUserName.setColumns(10);
		userName = txtUserName.getText();
		
		JPasswordField txtPassword = new JPasswordField();
		txtPassword.setBounds(242, 224, 146, 26);
		add(txtPassword);
		txtPassword.setColumns(10);
		password = new String(txtPassword.getPassword());
		
		final JComboBox UserTypes = new JComboBox();
		UserTypes.setModel(new DefaultComboBoxModel(new String[] {"Author", "Reviewer ", "Sub Program Chair", "Program Chair"}));
		UserTypes.setBounds(242, 273, 146, 26);
		add(UserTypes);
		
		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new ActionListener() {
			/**
			 * If save button is clicked, either a user will be created or a message dialog will pop-up.
			 * @author Jugbir Singh - Jay
			 * @param e
			 */
			public void actionPerformed(ActionEvent e) {
				if(createUser()) {
					frame.dispose();
				} else {
					showMessage();
				}
			}
		});
		btnSave.setBounds(123, 380, 69, 28);
		add(btnSave);
		
		JLabel lblConfrence = new JLabel("Confrence:");
		lblConfrence.setBounds(123, 330, 69, 16);
		add(lblConfrence);
		
		JComboBox confrences = new JComboBox();
		confrences.setBounds(242, 325, 146, 26);
		add(confrences);
		
		JButton btnNewConfrence = new JButton("New Confrence");
		btnNewConfrence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				conferencePanel.show();
				UserTypes.setModel(new DefaultComboBoxModel(new String[] {"Program Chair"}));
			}
		});
		btnNewConfrence.setBounds(261, 380, 127, 28);
		add(btnNewConfrence);

	}
	
	public void show(){
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/group2/logo.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
//		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.getContentPane().add(this);
		frame.show();
	}
	
	/**
	 * Checks if a User can be created. 
	 * @author Jugbir Singh - Jay 
	 * @return whether or not user was created
	 */
	public boolean createUser() {
		if(userName != null && password != null) {
			return userManager.signUp(userName, password);
		}
		return false;
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
