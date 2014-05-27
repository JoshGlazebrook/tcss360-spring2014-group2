package group2;

import java.awt.Font;
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
import javax.swing.JTextArea;
import javax.swing.text.EditorKit;
/**
 * 
 * @author Mina Messak
 * @version 5.22.2014
 */
public class AuthorPanel extends JPanel {
	
	
	final JFileChooser fileChooser = new JFileChooser();
	final StringBuilder stringBuilder = new StringBuilder();

	/**
	 * Create the panel.
	 */
	public AuthorPanel() {
	
		setLayout(null);
		setSize(500, 500);
		EditorKit kc;
//		final JTextArea textArea = new JTextArea();
		final JEditorPane textArea = new JEditorPane();
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
		btnOpenFile.setBounds(358, 330, 127, 29);
		add(btnOpenFile);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(370, 375, 115, 29);
		add(btnSubmit);
		
		JButton btnRemoveFile = new JButton("Remove File...");
		btnRemoveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveFile.setBounds(15, 375, 133, 29);
		add(btnRemoveFile);
		
		JButton btnSelectConfrence = new JButton("Select Confrence");
		btnSelectConfrence.setBounds(15, 330, 149, 29);
		add(btnSelectConfrence);
		
		JLabel lblConfrence = new JLabel("Confrence Name");
		lblConfrence.setBounds(191, 330, 117, 20);
		add(lblConfrence);
		
		JLabel lblDeadline = new JLabel("Deadline");
		lblDeadline.setBounds(219, 379, 61, 20);
		add(lblDeadline);
		
		
		JLabel lblAuthor = new JLabel("Author");
		lblAuthor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblAuthor.setBounds(205, 15, 89, 37);
		add(lblAuthor);

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
