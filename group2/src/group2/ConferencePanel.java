package group2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * 
 * @author Mina Messak
 * @version 5.22.2014
 */
public class ConferencePanel extends JPanel {
	private JFormattedTextField txtDate;
	private JFormattedTextField txtDeadline;
	//private ArrayList<Conference> confrences;

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
		btnSave.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				//confrences.add(new Conference(new User("MinaM", "mina"), "Confrence 1", "05/11/2014", "05/30/2014"));
				
			}
		});
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
	
	public void show(){
		JFrame frame = new JFrame("Conference");
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
