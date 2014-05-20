package group2;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class AuthorPanel extends JPanel {
	
	
	JFileChooser jf = new JFileChooser();
	StringBuilder sb = new StringBuilder();

	/**
	 * Create the panel.
	 */
	public AuthorPanel() {
	
		setLayout(null);
		setSize(500, 500);
		
		JLabel lblUthor = new JLabel("Author");
		final JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 84, 470, 240);
		add(textArea);
		lblUthor.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblUthor.setBounds(205, 31, 89, 37);
		add(lblUthor);
		
		JButton btnGetFile = new JButton("Upload File...");
		btnGetFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					getFile();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				textArea.setText(sb.toString());
			}
		});
		btnGetFile.setBounds(358, 340, 127, 29);
		add(btnGetFile);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(370, 385, 115, 29);
		add(btnSubmit);
		
		JButton btnRemoveFile = new JButton("Remove File...");
		btnRemoveFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnRemoveFile.setBounds(15, 385, 133, 29);
		add(btnRemoveFile);
		
		JButton btnSelectConfrence = new JButton("Select Confrence");
		btnSelectConfrence.setBounds(15, 340, 149, 29);
		add(btnSelectConfrence);
		
		JLabel lblConfrence = new JLabel("Confrence Name");
		lblConfrence.setBounds(191, 340, 117, 20);
		add(lblConfrence);
		
		JLabel lblDeadline = new JLabel("Deadline");
		lblDeadline.setBounds(215, 389, 69, 20);
		add(lblDeadline);
		
		JButton btnReviewSheet = new JButton("Review Sheet");
		btnReviewSheet.setBounds(186, 439, 127, 29);
		add(btnReviewSheet);

	}
	
	public void getFile() throws Exception{
		if(jf.showOpenDialog(null) == JFileChooser.APPROVE_OPTION){
			
			java.io.File file = jf.getSelectedFile();
			
			Scanner input = new Scanner(file);
			
			while(input.hasNext()){
				sb.append(input.nextLine());
				sb.append("\n");
			}
			input.close();
		}else {
			sb.append("No file Was chosen!");
		}
	}
}
