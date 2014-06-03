package group2;

import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;
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

/**
 * 
 * @author Anh Bui
 *
 */
public class ConferencePanel extends JPanel {
	/*
	final StringBuilder stringBuilder = new StringBuilder();
	final JFileChooser fileChooser = new JFileChooser();
	*/
	
	ArrayList<Conference> confList = new ArrayList<Conference>();
	
	/**
	 * Create the panel.
	 */
	public ConferencePanel(final ArrayList<Conference> confList, final MainGUI gui, final User currUser) {
		setSize(500, 500);
		setLayout(null);
		
		/*
		final JEditorPane textArea = new JEditorPane();
		//JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 71, 460, 240);
		JScrollPane pane = new JScrollPane(textArea);
		pane.setBounds(15, 71, 480, 240);
		add(pane);*/
		
		Conference tempConf;
		Conference[] testArray = new Conference[5];
		for(int i = 0; i < 5; i++) {
			String tempS = "" + i;
			tempConf = new Conference(new User(tempS, tempS), tempS, tempS, tempS);
			testArray[i] = tempConf;
		}
		
		String[] confArray = new String[confList.size()];
		for (int i = 0; i < confList.size(); i++) {
//			confArray[i] = confList.get(i).getName();
			confArray[i] = confList.get(i).getName();
		}
		
		final JList list = new JList(confArray);
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
		
		JButton btnMakeConf = new JButton("Create New Conference");
		btnMakeConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.setPanel(new NewConferencePanel(confList, currUser, gui));
			}
		});
	
		btnMakeConf.setBounds(25, 329, 200, 29);
		add(btnMakeConf);
		
		JButton btnSelectConf = new JButton("Select");
		btnSelectConf.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(confList.size() == 0) return;
				Conference curConf = confList.get(list.getSelectedIndex());
				if (curConf.confUser.containsKey(currUser.userName)) {
					if(curConf.confUser.get(currUser.userName).role.equals("Program Chair")) {
						gui.setPanel(new ProgramChairPanel());
					} else if (curConf.confUser.get(currUser.userName).role.equals("Author")) {
						Author newAuthor = new Author(currUser.userName, currUser.password);
						newAuthor.role = "Author";
						gui.setPanel(new AuthorPanel(curConf, newAuthor));
					}
				} else {
					Author newAuthor = new Author(currUser.userName, currUser.password);
					newAuthor.role = "Author";
					curConf.confUser.put(newAuthor.userName, newAuthor);
					gui.setPanel(new AuthorPanel(curConf, newAuthor));
				}
			}
		});
	
		btnSelectConf.setBounds(375, 329, 100, 29);
		add(btnSelectConf);
		
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
}
