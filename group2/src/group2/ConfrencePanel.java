package group2;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;


public class ConfrencePanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ConfrencePanel() {
		setLayout(null);
		setSize(500, 500);
		
		JTextField txtName;
		
		JLabel lblNewConfrence = new JLabel("New Confrence");
		lblNewConfrence.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewConfrence.setBounds(149, 27, 202, 37);
		add(lblNewConfrence);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setBounds(118, 123, 47, 20);
		add(lblName);
		
		txtName = new JTextField();
		txtName.setColumns(10);
		txtName.setBounds(237, 120, 146, 26);
		add(txtName);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setBounds(118, 162, 38, 20);
		add(lblDate);
		
		JButton btnSave = new JButton("Save");
		btnSave.setBounds(189, 398, 122, 29);
		add(btnSave);

	}
}
