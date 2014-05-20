package group2;

import java.awt.Font;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;

public class ProgramChairPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ProgramChairPanel() {
		setSize(500, 500);
		setLayout(null);
		
		JLabel titleLabel = new JLabel("Program Chair");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titleLabel.setBounds(154, 29, 191, 37);
		add(titleLabel);
		
		JButton btnAssignReviewers = new JButton("Assign Reviewers");
		btnAssignReviewers.setBounds(330, 329, 155, 29);
		add(btnAssignReviewers);
		
		JButton btnOpenFile = new JButton("Open File");
	
		btnOpenFile.setBounds(25, 329, 99, 29);
		add(btnOpenFile);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 71, 470, 240);
		add(textArea);
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rdbtnAccept = new JRadioButton("Accept");
		rdbtnAccept.setBounds(50, 374, 79, 29);
		bg.add(rdbtnAccept);
		add(rdbtnAccept);
		
		JRadioButton rdbtnReject = new JRadioButton("Reject");
		rdbtnReject.setBounds(136, 374, 75, 29);
		bg.add(rdbtnReject);
		add(rdbtnReject);
		
		JButton btnSubmitToConfrence = new JButton("Submit To Confrence");
		btnSubmitToConfrence.setBounds(139, 329, 183, 29);
		add(btnSubmitToConfrence);
		
		JButton btnRecomendation = new JButton("Recomendation");
		btnRecomendation.setBounds(298, 374, 141, 29);
		add(btnRecomendation);
		
		

	}
}
