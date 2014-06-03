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
import javax.swing.JTextField;
import javax.swing.text.EditorKit;
/**
 * 
 * @author Mina Messak, Anh Bui
 * @version 5.22.2014
 */
public class AuthorPanel extends JPanel {
	
	
	private final JFileChooser fileChooser = new JFileChooser();
	private final StringBuilder stringBuilder = new StringBuilder();
	private JLabel lblConference = new JLabel("Conference Name");
	private JLabel lblDeadline = new JLabel("Deadline");
	private boolean submitted = false;

	/**
	 * Create the panel.
	 */
	public AuthorPanel(final Conference curConf, final Author curAuthor) {
		lblConference.setText(curConf.getName());
		lblDeadline.setText(curConf.getDeadline());
		setLayout(null);
		setSize(500, 500);
		EditorKit kc;
//		final JTextArea textArea = new JTextArea();
		final JTextField title = new JTextField();
		title.setBounds(15, 58, 480, 37);
		add(title);
		
		final JEditorPane textArea = new JEditorPane();
		textArea.setBounds(15, 95, 460, 203);
//		if (curConf.paperManager.hasPaper(curAuthor)) {
//			textArea.setText(curConf.paperManager.getPaper(curAuthor).getData());
//		}
		
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
		btnOpenFile.setBounds(358, 330, 127, 29);
		add(btnOpenFile);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(370, 375, 115, 29);
		btnSubmit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
//				if(!submitted){
				curConf.paperManager.addPaper(new Paper(title.getText(),
						curAuthor, textArea.getText()));
				JOptionPane.showMessageDialog(new Frame(), "Paper is submitted");
//					submitted = true;
//				}else{
//					JOptionPane.showMessageDialog(new Frame(), "You have already submitted a paper for this conference");
//				}
			}
		});
		add(btnSubmit);
		
		
		
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
		btnRemoveFile.setBounds(15, 375, 133, 29);
		add(btnRemoveFile);
		
//		JButton btnSelectConfrence = new JButton("Select Confrence");
//		btnSelectConfrence.addActionListener(new ActionListener() {
//			public void actionPerformed(ActionEvent e) {
//				String[] conferences = { "Conference 1", "conference 2", "conference 3", "conference 4" };
//				String dialogBox = (String) JOptionPane.showInputDialog(new Frame(), 
//				        "Please select a conference! ",
//				        "Conferences",
//				        JOptionPane.QUESTION_MESSAGE, 
//				        null, 
//				        conferences, 
//				        conferences[0]);
//						
//				changeLabel(lblConfrence, dialogBox);
//				changeLabel(lblDeadline, "10/12/2014");
//			}
//		});
//		btnSelectConfrence.setBounds(15, 330, 149, 29);
//		add(btnSelectConfrence);
		
		
		lblConference.setBounds(getWidth()/2, 330, 127, 20);
		add(lblConference);
		
		lblDeadline.setBounds(getWidth()/2, 379, 83, 20);
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
}
