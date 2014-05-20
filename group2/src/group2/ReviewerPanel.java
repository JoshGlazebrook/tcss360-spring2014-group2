package group2;

import javax.swing.JPanel;
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
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 84, 470, 240);
		add(textArea);
		
		JLabel lblReviewer = new JLabel("Reviewer");
		lblReviewer.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblReviewer.setBounds(190, 34, 122, 37);
		add(lblReviewer);
		
		JButton button = new JButton("Find File...");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setBounds(15, 412, 115, 29);
		add(button);
		
		JButton btnEdit = new JButton("Submit Edits");
		btnEdit.setBounds(367, 412, 121, 29);
		add(btnEdit);
		
		JButton btnConfrence = new JButton("Select Confrence");
		btnConfrence.setBounds(15, 350, 149, 29);
		add(btnConfrence);
		
		JLabel lblConfrenceName = new JLabel("Confrence Name");
		lblConfrenceName.setBounds(193, 354, 117, 20);
		add(lblConfrenceName);
		
		JLabel lblDeadline = new JLabel("Deadline");
		lblDeadline.setBounds(217, 416, 69, 20);
		add(lblDeadline);
		
		JButton btnUpload = new JButton("Upload");
		btnUpload.setBounds(373, 350, 115, 29);
		add(btnUpload);

	}

}
