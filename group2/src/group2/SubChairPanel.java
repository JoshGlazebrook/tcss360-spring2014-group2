package group2;
/**
 * 
 * @author Mina Messak
 * @version 5.22.2014
 */
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
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
		for(String paper: curConf.getSubprogramListKeys().get(currentUser.userName)) {
			paperNameList.add(paper);
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
					String paper = null;
					ArrayList<String> papers = curConf.getSubprogramListKeys().get(currentUser.userName);
					String[] paperArray = new String[4];
					for(int i=0; i<papers.size(); i++) {
						paperArray[i] = papers.get(i);
					}
					for(String thePaper: paperArray) {
						if(thePaper.equals(paperNameList.get(paperList.getSelectedIndex()))) {
							paper = thePaper;
							break;
						}
					}
					if(user.role.equals("Reviewer") && !curConf.getPaperManager().getPaper(paper).
							getAuthor().userName.equals(user.getUserName())) {
						if(!curConf.getReviewerListKeys().containsKey(user.userName)) {
							ArrayList<String> listOfPapers = new ArrayList<String>();
							listOfPapers.add(paper);
							curConf.getReviewerListKeys().put(user.userName, listOfPapers);
							curConf.getPaperManager().getPaper(paper).getReviews().add(new Review(user.userName));
							showDialogForPaper();
						} else {
							if(curConf.getReviewerListKeys().get(user.userName).size() < 4) {
								if(!curConf.getReviewerListKeys().get(user.userName).contains(paper)) {
									curConf.getReviewerListKeys().get(user.userName).add(paper);
									curConf.getPaperManager().getPaper(paper).getReviews().add(new Review(user.userName));
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

		JButton btnOpenFile = new JButton("Assignments");
		btnOpenFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SubprogramList newSub = new SubprogramList(curConf, currentUser.userName);
				newSub.show();
			}
		});
		btnOpenFile.setBounds(15, 380, 99, 29);
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
	
	class SubprogramList extends JPanel{
		JFrame frame = new JFrame();
		public SubprogramList(Conference conf, String subName) {
			setSize(500, 500);
			setLayout(null);
			JLabel lblTitle = new JLabel("Papers");
			lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
			lblTitle.setBounds(186, 16, 127, 37);
			add(lblTitle);
			
			StringBuilder list = new StringBuilder();
			for(String paper : conf.getSubprogramListKeys().get(subName)) {
				list.append("Paper: " + paper + "\n  Reviewers: ");
				for(Review r : conf.getPaperManager().getPaper(paper).getReviews()) {
					list.append(r.getReviewer() + ", ");
				}
				list.append("\n");
			}
			
			JEditorPane programList = new JEditorPane();
			programList.setBounds(15, 71, 480, 240);
			programList.setText(list.toString());
			add(programList);
		}
		public void show(){
			frame.setResizable(false);
			frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/group2/logo.jpg")));
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			frame.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			frame.setSize(500, 500);
			frame.getContentPane().add(this);
			frame.show();
		}
	}
}
