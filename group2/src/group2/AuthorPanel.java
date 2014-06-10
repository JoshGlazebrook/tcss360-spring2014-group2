package group2;

import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.text.EditorKit;
/**
 * 
 * @author Mina Messak, Anh Bui, Jugbir Singh - Jay
 * @version 5.22.2014
 */
public class AuthorPanel extends JPanel {
	private final JFileChooser fileChooser = new JFileChooser();
	private final StringBuilder stringBuilder = new StringBuilder();
	private JLabel lblConference = new JLabel("Conference Name");
	private JLabel lblDate = new JLabel("Date");
	private JLabel lblDeadline = new JLabel("Deadline");
	private boolean submitted = false;
	int count = 0;

	/**
	 * Create the panel.
	 */
	public AuthorPanel(final Conference curConf, final Author curAuthor) {
		lblConference.setText(curConf.getName());
		lblDate.setText(curConf.getDate());
		lblDeadline.setText(curConf.getDeadline());
		setLayout(null);
		setSize(500, 500);
		EditorKit kc;
		
		JLabel nameLabel = new JLabel("Name: ");
		nameLabel.setBounds(15, 300, 84, 20);
		add(nameLabel);

		JLabel dateLabel = new JLabel("Date: ");
		dateLabel.setBounds(15, 320, 84, 20);
		add(dateLabel);
		
		JLabel deadlineLabel = new JLabel("Deadline: ");
		deadlineLabel.setBounds(15, 340, 84, 20);
		add(deadlineLabel);
		
		final JTextField title = new JTextField();
		title.setBounds(15, 58, 480, 37);
		add(title);

		final JEditorPane textArea = new JEditorPane();
		textArea.setBounds(36, 300, 460, 203);
		
		JScrollPane pane = new JScrollPane(textArea);
		pane.setBounds(15, 95, 480, 203);
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
		btnOpenFile.setBounds(15, 370, 127, 29);
		add(btnOpenFile);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(180, 370, 115, 29);
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(!curConf.getPaperManager().hasPaper(title.getText())) count++;
				if(count > 4) {
					JOptionPane.showMessageDialog(new Frame(), "Exceeded number of submissions!");
					return;
				}
				curConf.getPaperManager().addPaper(new Paper(title.getText(),
						curAuthor, textArea.getText()));
				JOptionPane.showMessageDialog(new Frame(), "Paper is submitted");
			}
		});
		add(btnSubmit);
		
		JComboBox chooseFile = new JComboBox<>();
		
		JButton btnRemoveFile = new JButton("Remove File...");
		btnRemoveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] files = { "File 1", "File 2", "File 3", "File 4" };
				String dialogBox = (String) JOptionPane.showInputDialog(new Frame(), 
				        "Please select a paper! ",
				        "Submited Files",
				        JOptionPane.QUESTION_MESSAGE, 
				        null, 
				        files, 
				        files[0]);	
			}
		});
		btnRemoveFile.setBounds(333, 370, 133, 29);
		add(btnRemoveFile);
		
		JButton btnSelectPaper = new JButton("Select Paper");
		btnSelectPaper.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String[] papers = curConf.getPaperManager().getTitles(curAuthor.userName);
					if (papers.length == 0) return;
					String curPaper = (String) JOptionPane.showInputDialog(new Frame(), 
					        "Please select a paper! ",
					        "Conferences",
					        JOptionPane.QUESTION_MESSAGE, 
					        null, 
					        papers, 
					        papers[0]);
					if(curPaper == null) return;
					title.setText(curPaper);
					textArea.setText(curConf.getPaperManager().getPaper(curPaper).getData());
							
				}
		});
		btnSelectPaper.setBounds(15, 409, 149, 29);
		add(btnSelectPaper);
		
		JButton btnReviewer = new JButton("Become Reviewer");
		btnReviewer.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(!curAuthor.role.equals("Reviewer") && !curAuthor.role.equals("Subprogram Chair")){
						curAuthor.role = "Reviewer";
						curConf.confUser.put(curAuthor.getUserName(), curAuthor);
						showDialogPromoted();
					} else {
						showDialogRejectedPromote();
					}
				}
		});
		btnReviewer.setBounds(175, 409, 149, 29);
		add(btnReviewer);
		
		lblConference.setBounds(70, 300, 127, 20);
		add(lblConference);
		
		lblDate.setBounds(70, 320, 83, 20);
		add(lblDate);
		
		lblDeadline.setBounds(70, 340, 83, 20);
		add(lblDeadline);

		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAuthor.setBounds(205, 15, 89, 37);
		add(lblAuthor);
	}
	
	private void changeLabel(JLabel label, String text){
		label.setText(text);
	}
	
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
	
	public void showDialogPromoted() {
		JOptionPane.showMessageDialog(this, "Promoted to Reviewer.");
	}
	
	public void showDialogRejectedPromote() {
		JOptionPane.showMessageDialog(this, "Already a reviewer.");
	}
}
