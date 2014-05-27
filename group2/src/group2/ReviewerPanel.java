package group2;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
/**
 * 
 * @author Mina Messak
 * @version 5.22.2014
 */
public class ReviewerPanel extends JPanel {
	
	final StringBuilder stringBuilder = new StringBuilder();
	final JFileChooser fileChooser = new JFileChooser();

	/**
	 * Create the panel.
	 */
	public ReviewerPanel() {
		setLayout(null);
		setSize(500, 500);
		
		final JEditorPane textArea = new JEditorPane();
		//JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 58, 460, 240);

		JScrollPane pane = new JScrollPane(textArea);
		pane.setBounds(15, 58, 480, 240);
		add(pane);
		
		JButton btnOpenFile = new JButton("Open File...");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					getFile();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				textArea.setText(stringBuilder.toString());
			}
		});
		btnOpenFile.setBounds(15, 392, 115, 29);
		add(btnOpenFile);
		
		JButton btnEdit = new JButton("Submit Edits");
		btnEdit.setBounds(364, 330, 121, 29);
		add(btnEdit);
		
		JButton btnConfrence = new JButton("Select Confrence");
		btnConfrence.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] conferences = { "conference 1", "conference 2", "conference 3", "conference 4" };
				String dialogBox = (String) JOptionPane.showInputDialog(new Frame(), 
				        "Please select a conference! ",
				        "Conferences",
				        JOptionPane.QUESTION_MESSAGE, 
				        null, 
				        conferences, 
				        conferences[0]);	
			}
		});
		btnConfrence.setBounds(15, 330, 149, 29);
		add(btnConfrence);
		
		JLabel lblConfrenceName = new JLabel("Confrence Name");
		lblConfrenceName.setBounds(191, 334, 117, 20);
		add(lblConfrenceName);
		
		JLabel lblDeadline = new JLabel("Deadline");
		lblDeadline.setBounds(219, 396, 61, 20);
		add(lblDeadline);
		
		JButton btnReview = new JButton("Review Sheet");
		btnReview.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textArea.removeAll();
				textArea.setText(" Review Sheet\n\n Paper Name:\n\n Review Date:\n\n Comments:\n\n");
			}
		});
		btnReview.setBounds(358, 392, 127, 29);
		add(btnReview);
		
		JLabel lblReviewer = new JLabel("Reviewer");
		lblReviewer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblReviewer.setBounds(189, 15, 122, 37);
		add(lblReviewer);

	}
	/**
	 * File display from text file. 
	 * @throws Exception
	 */
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
	}

}
