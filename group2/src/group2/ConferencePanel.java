package group2;

import java.awt.Font;
import java.awt.Frame;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListSelectionModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConferencePanel extends JPanel {
	/*
	final StringBuilder stringBuilder = new StringBuilder();
	final JFileChooser fileChooser = new JFileChooser();
	*/
	
	/**
	 * Create the panel.
	 */
	public ConferencePanel() {
		setSize(500, 500);
		setLayout(null);
		
		/*
		final JEditorPane textArea = new JEditorPane();
		//JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 71, 460, 240);
		JScrollPane pane = new JScrollPane(textArea);
		pane.setBounds(15, 71, 480, 240);
		add(pane);*/
		
		String[] array = {"a", "b", "c"};
		final JList list = new JList(array);
		list.setVisibleRowCount(3);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		list.setBounds(15, 71, 480, 240);
		add(list);
		//JPanel listPanel = new JPanel();
		
		JLabel titleLabel = new JLabel("Conferences");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titleLabel.setBounds(154, 15, 191, 37);
		add(titleLabel);
		
		/*
		JButton btnAssignReviewers = new JButton("Assign Reviewers");
		btnAssignReviewers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] reviewers = { "reviewer 1", "reviewer 2", "reviewer 3", "reviewer 4" };
				String dialogBox = (String) JOptionPane.showInputDialog(new Frame(), 
				        "Please select a reviewer! ",
				        "Reviewers",
				        JOptionPane.QUESTION_MESSAGE, 
				        null, 
				        reviewers, 
				        reviewers[0]);
			}
		});
		btnAssignReviewers.setBounds(330, 329, 155, 29);
		add(btnAssignReviewers); */
		
		JButton btnOpenFile = new JButton("Create New Conference");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
	
		btnOpenFile.setBounds(25, 329, 200, 29);
		add(btnOpenFile);
		
		/*
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
		*/
	}
	
	/*
	public void getFile() throws Exception{
		if(fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			
			java.io.File file = fileChooser.getSelectedFile();
			
			Scanner input = new Scanner(file);
			
			while(input.hasNext()){
				stringBuilder.append(input.nextLine());
				stringBuilder.append("\n");
			}
			input.close();
		}else {
			JOptionPane.showMessageDialog(this, "Please Select a File!");
		}
	}*/
}
