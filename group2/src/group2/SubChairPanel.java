package group2;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class SubChairPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public SubChairPanel() {
		setSize(500, 500);
		setLayout(null);
		
		JLabel titleLabel = new JLabel("Sub Program Chair");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titleLabel.setBounds(124, 29, 251, 37);
		add(titleLabel);
		
		JButton btnAssignReviewers = new JButton("Assign Reviewers");
		btnAssignReviewers.setBounds(330, 330, 155, 29);
		add(btnAssignReviewers);
		
		JButton btnOpenFile = new JButton("Open File");
	
		btnOpenFile.setBounds(15, 330, 99, 29);
		add(btnOpenFile);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 71, 470, 240);
		add(textArea);
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rdbtnRecomend = new JRadioButton("Recomend");
		rdbtnRecomend.setBounds(128, 330, 107, 29);
		bg.add(rdbtnRecomend);
		add(rdbtnRecomend);
		
		JRadioButton rdbtnDecline = new JRadioButton("Decline");
		rdbtnDecline.setBounds(236, 330, 83, 29);
		bg.add(rdbtnDecline);
		add(rdbtnDecline);
		
		

	}
}