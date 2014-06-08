package group2;
/**
 * 
 * @author Mina Messak
 * @version 5.22.2014
 */
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

public class SubChairPanel extends JPanel {
	
	final StringBuilder stringBuilder = new StringBuilder();
	final JFileChooser fileChooser = new JFileChooser();

	/**
	 * Create the panel.
	 */
	public SubChairPanel(final Conference curConf, final User currentUser) {
		setSize(500, 500);
		setLayout(null);
		
		/*
		final JEditorPane textArea = new JEditorPane();
		//JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 71, 460, 240);
		JScrollPane pane = new JScrollPane(textArea);
		pane.setBounds(15, 71, 480, 240);
		add(pane);*/
		
		final ArrayList<String> paperNameList = new ArrayList<String>();
		for(Paper paper: curConf.getSubprogramListKeys().get(currentUser)) {
			paperNameList.add(paper.getName());
		}
		
		final JList paperList = new JList(paperNameList.toArray());
		paperList.setVisibleRowCount(3);
		paperList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		paperList.setBounds(15, 71, 230, 240); //before 480 width
		add(paperList);
		
		//
		
		final ArrayList<String> userNameList = new ArrayList<String>();
		final ArrayList<String> keyList = new ArrayList<String>();
		for(User user: curConf.confUser.values()) {
			if(user.role.equals("Reviewer")) {
				keyList.add(user.getUserName());
				userNameList.add(user.getUserName() + " " + user.role);
			}
		}
		
		final JList userList = new JList(userNameList.toArray());
		userList.setVisibleRowCount(3);
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userList.setBounds(255, 71, 230, 240); //before 480 width
		add(userList);
		
		//
		JLabel titleLabel = new JLabel("Subprogram Chair");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titleLabel.setBounds(124, 15, 251, 37);
		add(titleLabel);
		
		JButton btnAssignPapers = new JButton("Assign Papers");
		btnAssignPapers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String[] reviewers = { "reviewer 1", "reviewer 2", "reviewer 3", "reviewer 4" };
				String dialogBox = (String) JOptionPane.showInputDialog(new Frame(), 
				        "Please select a reviewer! ",
				        "Reviewers",
				        JOptionPane.QUESTION_MESSAGE, 
				        null, 
				        reviewers, 
				        reviewers[0]);*/
				if(paperList.getSelectedIndex() >= 0 && userList.getSelectedIndex() >= 0) {
					User user = curConf.confUser.get(keyList.get(userList.getSelectedIndex()));
					Paper paper = null;
					ArrayList<Paper> papers = curConf.getSubprogramListKeys().get(currentUser);
					Paper[] paperArray = new Paper[4];
					for(int i=0; i<papers.size(); i++) {
						paperArray[i] = papers.get(i);
					}
					for(Paper thePaper: paperArray) {
						if(thePaper.getName().equals(paperNameList.get(paperList.getSelectedIndex()))) {
							paper = thePaper;
							break;
						}
					}
					if(user.role.equals("Reviewer") && !paper.getAuthor()
							.getUserName().equals(user.getUserName())) {
						if(!curConf.getReviewerListKeys().containsKey(user)) {
							ArrayList<Paper> listOfPapers = new ArrayList<Paper>();
							listOfPapers.add(paper);
							curConf.getReviewerListKeys().put(user, listOfPapers);
							showDialogForPaper();
						} else {
							if(curConf.getReviewerListKeys().get(user).size() < 4) {
								if(!curConf.getReviewerListKeys().get(user).contains(paper)) {
									curConf.getReviewerListKeys().get(user).add(paper);
									showDialogForPaper();
								}
							} else {
								showDialogMaxPaper();
							}
						}
					}
				} else {
					showDialogToAssign();
				}
			}
		});
		btnAssignPapers.setBounds(330, 330, 155, 29);
		add(btnAssignPapers);
		
		JButton btnOpenFile = new JButton("Open File...");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					getFile();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				//textArea.setText(stringBuilder.toString());
			}
		});
		btnOpenFile.setBounds(15, 330, 99, 29);
		add(btnOpenFile);
		
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rdbtnRecomend = new JRadioButton("Recommend");
		rdbtnRecomend.setBounds(128, 330, 107, 29);
		bg.add(rdbtnRecomend);
		add(rdbtnRecomend);
		
		JRadioButton rdbtnDecline = new JRadioButton("Decline");
		rdbtnDecline.setBounds(236, 330, 83, 29);
		bg.add(rdbtnDecline);
		add(rdbtnDecline);

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
	
	public void showDialogToAssign(){
		JOptionPane.showMessageDialog(this, "Please select a paper and user.");
	}
	
	public void showDialogForPaper(){
		JOptionPane.showMessageDialog(this, "Paper has been assigned.");
	}
	
	public void showDialogMaxPaper() {
		JOptionPane.showMessageDialog(this, "No more papers allowed. Try different user.");
	}
}
