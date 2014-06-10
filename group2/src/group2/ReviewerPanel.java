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
	String curPaper;

	/**
	 * Create the panel.
	 */
	public ReviewerPanel(final Conference curConf, final Reviewer curReviewer) {
		setLayout(null);
		setSize(500, 500);
		
		final JEditorPane textArea = new JEditorPane();
		//JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 58, 460, 180);
		textArea.setEditable(false);

		JScrollPane pane = new JScrollPane(textArea);
		pane.setBounds(15, 58, 480, 180);
		add(pane);
		
		final JEditorPane reviewArea = new JEditorPane();
		reviewArea.setBounds(15, 248, 460, 50);
		
		JScrollPane paneReview = new JScrollPane(reviewArea);
		paneReview.setBounds(15, 248, 480, 50);
		add(paneReview);
		
//		JButton btnOpenFile = new JButton("Open File...");
//		btnOpenFile.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				try {
//					getFile();
//				} catch (Exception e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
//				
//				textArea.setText(stringBuilder.toString());
//			}
//		});
//		btnOpenFile.setBounds(15, 392, 115, 29);
//		add(btnOpenFile);
		
		JButton btnEdit = new JButton("Submit Review");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(curPaper == null) return;
				curConf.getPaperManager().getPaper(curPaper).getCurReview(curReviewer.userName).
				setReview(reviewArea.getText());
			}
		});
		btnEdit.setBounds(364, 330, 121, 29);
		add(btnEdit);
		
		JButton btnSelectPaper = new JButton("Select Paper");
		btnSelectPaper.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
//					String[] papers = curConf.getPaperManager().getReviews(curReviewer);
					String[] papers = curConf.getReviewerListKeys().get(curReviewer.userName).
							toArray(new String[0]);
					if (papers.length == 0) return;
					curPaper = (String) JOptionPane.showInputDialog(new Frame(), 
					        "Please select a paper! ",
					        "Conferences",
					        JOptionPane.QUESTION_MESSAGE, 
					        null, 
					        papers, 
					        papers[0]);
					if(curPaper == null) return;
					textArea.setText(curConf.getPaperManager().getPaper(curPaper).getData());
					if(curConf.getPaperManager().getPaper(curPaper).
							getCurReview(curReviewer.userName) != null) {
						reviewArea.setText(curConf.getPaperManager().getPaper(curPaper).
								getCurReview(curReviewer.userName).getReview());
					}
					
				}
		});
		btnSelectPaper.setBounds(15, 330, 149, 29);
		add(btnSelectPaper);
		
		JLabel lblConfrenceName = new JLabel("Conference Name");
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
