package group2;

import java.awt.Font;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Map;
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

public class ProgramChairPanel extends JPanel {
	
	final StringBuilder stringBuilder = new StringBuilder();
	final JFileChooser fileChooser = new JFileChooser();

	/**
	 * Create the panel.
	 */
	public ProgramChairPanel(final Conference curConf) {
		setSize(500, 500);
		setLayout(null);
		
		//
		/*
		Conference tempConf;
		Conference[] testArray = new Conference[5];
		for(int i = 0; i < 5; i++) {
			String tempS = "" + i;
			tempConf = new Conference(new User(tempS, tempS), tempS, tempS, tempS);
			testArray[i] = tempConf;
		}*/
		
		/*
		int paperSize = curConf.getPaperManager().size();
		String[] paperArray = new String[paperSize];
		for (int i = 0; i < paperSize; i++) {
//			confArray[i] = confList.get(i).getName();
			//paperArray[i] = curConf.getPaperManager().getPapers();
		}*/

		
		final ArrayList<String> paperNameList = new ArrayList<String>();
		for(Paper paper: curConf.getPapers()) {
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
			keyList.add(user.getUserName());
			userNameList.add(user.getUserName() + " " + user.role);
		}
		
		final JList userList = new JList(userNameList.toArray());
		userList.setVisibleRowCount(3);
		userList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		userList.setBounds(255, 71, 230, 240); //before 480 width
		add(userList);
		
		//
		
		/*
		final JEditorPane textArea = new JEditorPane();
		//JTextArea textArea = new JTextArea();
		textArea.setBounds(15, 71, 460, 240);
		JScrollPane pane = new JScrollPane(textArea);
		pane.setBounds(15, 71, 480, 240);
		add(pane);*/
		
		JLabel titleLabel = new JLabel("Program Chair");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titleLabel.setBounds(154, 15, 191, 37);
		add(titleLabel);
		
		JButton btnAssignReviewers = new JButton("Assign Paper");
		btnAssignReviewers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/*String[] reviewers = { "reviewer 1", "reviewer 2", "reviewer 3", "reviewer 4" };
				String dialogBox = (String) JOptionPane.showInputDialog(new Frame(), 
				        "Please select a reviewer! ",
				        "Reviewers",
				        JOptionPane.QUESTION_MESSAGE, 
				        null, 
				        reviewers, 
				        reviewers[0]);*/
				//}
				if(paperList.getSelectedIndex() >= 0 && userList.getSelectedIndex() >= 0) {
					User user = curConf.confUser.get(keyList.get(userList.getSelectedIndex()));
					Paper paper = null;
					Paper[] paperArray = curConf.getPaperManager().getPapers();
					for(Paper thePaper: paperArray) {
						if(thePaper.getName().equals(paperNameList.get(paperList.getSelectedIndex()))) {
							paper = thePaper;
							break;
						}
					}
					if(user.role.equals("Subprogram Chair") && !paper.getAuthor()
							.getUserName().equals(user.getUserName())) {
						if(!curConf.getSubprogramListKeys().containsKey(user)) {
							ArrayList<Paper> listOfPapers = new ArrayList<Paper>();
							listOfPapers.add(paper);
							curConf.getSubprogramListKeys().put(user, listOfPapers);
							showDialogForPaper();
						} else {
							if(curConf.getSubprogramListKeys().get(user).size() < 4) {
								if(!curConf.getSubprogramListKeys().get(user).contains(paper)) {
									curConf.getSubprogramListKeys().get(user).add(paper);
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
		}});
		btnAssignReviewers.setBounds(298, 329, 141, 29);
		add(btnAssignReviewers);
		
		/*
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
		btnOpenFile.setBounds(25, 329, 99, 29);
		add(btnOpenFile);
		*/
		
		JButton btnSubChair = new JButton("Assign Subprogram Chairs");
		btnSubChair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(userList.getSelectedIndex() >= 0) {
					if(curConf.confUser.get(keyList.get(userList.getSelectedIndex())).role.
							equals("Reviewer")) {
						curConf.confUser.get(keyList.get(userList.getSelectedIndex())).role
						= "Subprogram Chair";
						showDialogToPromote();
					}
				}
			}
		});
		btnSubChair.setBounds(15, 329, 200, 29);
		add(btnSubChair);
	
		ButtonGroup bg = new ButtonGroup();
		JRadioButton rdbtnAccept = new JRadioButton("Accept");
		rdbtnAccept.setBounds(50, 374, 79, 29);
		bg.add(rdbtnAccept);
		add(rdbtnAccept);
		
		JRadioButton rdbtnReject = new JRadioButton("Reject");
		rdbtnReject.setBounds(136, 374, 75, 29);
		bg.add(rdbtnReject);
		add(rdbtnReject);
		
		/*
		JButton btnSubmitToConfrence = new JButton("Submit To Conference");
		btnSubmitToConfrence.setBounds(139, 329, 183, 29);
		add(btnSubmitToConfrence);*/
	
		JButton btnRecomendation = new JButton("Recomendation");
		btnRecomendation.setBounds(298, 374, 141, 29);
		add(btnRecomendation);

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
	
	public void showDialogToAssign(){
		JOptionPane.showMessageDialog(this, "Please select a paper and user.");
	}
	
	public void showDialogToPromote() {
		JOptionPane.showMessageDialog(this, "User has been promoted.");
	}
	
	public void showDialogForPaper(){
		JOptionPane.showMessageDialog(this, "Paper has been assigned.");
	}
	
	public void showDialogMaxPaper() {
		JOptionPane.showMessageDialog(this, "No more papers allowed. Try different user.");
	}
}
