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
		
		JLabel lblSubProgramChair = new JLabel("Sub Program Chair");
		lblSubProgramChair.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblSubProgramChair.setBounds(124, 29, 251, 37);
		add(lblSubProgramChair);
		
		JButton btnAssignReviewers = new JButton("Assign Reviewers");
		btnAssignReviewers.setBounds(330, 345, 155, 29);
		add(btnAssignReviewers);
		
		JButton btnOpenFile = new JButton("Open File");
	
		btnOpenFile.setBounds(15, 345, 115, 29);
		add(btnOpenFile);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 71, 470, 240);
		add(textArea);
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rdbtnRecomend = new JRadioButton("Recomend");
		rdbtnRecomend.setBounds(15, 431, 155, 29);
		bg.add(rdbtnRecomend);
		add(rdbtnRecomend);
		
		JRadioButton rdbtnDecline = new JRadioButton("Decline");
		rdbtnDecline.setBounds(330, 431, 155, 29);
		bg.add(rdbtnDecline);
		add(rdbtnDecline);
		
		

	}
}
