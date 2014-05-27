package group2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DeleteUserPanel extends JPanel {

	private JFrame frame = new JFrame("Delete User");

	/**
	 * Create the panel.
	 */
	public DeleteUserPanel() {
		setSize(500, 500);
		setLayout(null);
		
		JLabel lblDeleteUser = new JLabel("Delete User");
		lblDeleteUser.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblDeleteUser.setBounds(173, 16, 154, 37);
		add(lblDeleteUser);
		
		JPanel panel = new JPanel();
		panel.setBounds(63, 91, 373, 161);
		add(panel);
		panel.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(164, 36, 146, 26);
		panel.add(comboBox);
		
		JLabel label = new JLabel("Select User:");
		label.setBounds(31, 97, 86, 20);
		panel.add(label);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(164, 94, 146, 26);
		panel.add(comboBox_1);
		
		JLabel label_1 = new JLabel("Confrence:");
		label_1.setBounds(31, 42, 99, 16);
		panel.add(label_1);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(192, 330, 115, 29);
		add(btnDelete);

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
}
