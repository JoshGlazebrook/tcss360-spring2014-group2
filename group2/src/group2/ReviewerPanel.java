package group2;

import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ReviewerPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public ReviewerPanel() {
		setLayout(null);
		setSize(500, 500);
		
		JButton btnFindFile = new JButton("Find File...");
		btnFindFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnFindFile.setBounds(15, 392, 115, 29);
		add(btnFindFile);
		
		JButton btnEdit = new JButton("Submit Edits");
		btnEdit.setBounds(367, 392, 121, 29);
		add(btnEdit);
		
		JButton btnConfrence = new JButton("Select Confrence");
		btnConfrence.setBounds(15, 330, 149, 29);
		add(btnConfrence);
		
		JLabel lblConfrenceName = new JLabel("Confrence Name");
		lblConfrenceName.setBounds(193, 334, 117, 20);
		add(lblConfrenceName);
		
		JLabel lblDeadline = new JLabel("Deadline");
		lblDeadline.setBounds(217, 396, 69, 20);
		add(lblDeadline);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.setBounds(373, 330, 115, 29);
		add(btnUpload);
		
		JButton btnReview = new JButton("Review Sheet");
		btnReview.setBounds(186, 435, 127, 29);
		add(btnReview);
		JEditorPane textArea = new JEditorPane();
		//JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 58, 460, 240);

		JScrollPane pane = new JScrollPane(textArea);
		pane.setBounds(15, 58, 480, 240);
		add(pane);
		
		JLabel lblReviewer = new JLabel("Reviewer");
		lblReviewer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblReviewer.setBounds(189, 15, 122, 37);
		add(lblReviewer);

	}

}
