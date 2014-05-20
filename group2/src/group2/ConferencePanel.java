package group2;

import java.awt.Font;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JSpinner.DateEditor;
import javax.swing.JTextField;


public class ConferencePanel extends JPanel {
	private JFormattedTextField txtDate;
	private JFormattedTextField txtDeadline;

	/**
	 * Create the panel.
	 */
	public ConferencePanel() {
		
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
		
		txtDate = new JFormattedTextField();
		txtDate.setBounds(237, 159, 146, 26);
		add(txtDate);
		txtDate.setColumns(10);
		
		JLabel lblDeadline = new JLabel("Deadline:");
		lblDeadline.setBounds(118, 198, 69, 20);
		add(lblDeadline);
		
		txtDeadline = new JFormattedTextField();
		txtDeadline.setBounds(237, 195, 146, 26);
		add(txtDeadline);
		txtDeadline.setColumns(10);

	}
}
