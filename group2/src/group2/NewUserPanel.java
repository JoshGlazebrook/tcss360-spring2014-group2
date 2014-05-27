package group2;

import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPopupMenu;
import javax.swing.JTextField;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
/**
 * 
 * @author Mina Messak
 * @version 5.22.2014
 */
public class NewUserPanel extends JPanel {
	private JTextField txtName;
	private JTextField txtUserName;
	private JTextField txtPassword;
	private ConferencePanel conferencePanel = new ConferencePanel();

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
		
		JLabel lblUserType = new JLabel("User Type:");
		lblUserType.setBounds(123, 276, 78, 20);
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
		
		JComboBox UserTypes = new JComboBox();
		UserTypes.setModel(new DefaultComboBoxModel(new String[] {"Author", "Reviewer ", "Sub Program Chair", "Program Chair"}));
		UserTypes.setBounds(242, 273, 146, 26);
		add(UserTypes);
		
		JButton btnSave = new JButton("Save");
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
			}
		});
		btnNewConfrence.setBounds(261, 380, 127, 28);
		add(btnNewConfrence);

	}
	
	public void show(){
		JFrame frame = new JFrame("New User");
		frame.setResizable(false);
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/group2/logo.jpg")));
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
//		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setSize(500, 500);
		frame.getContentPane().add(this);
		frame.show();
		
	}
}
