package group2;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
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

/**
 * @author Jugbir Singh - Jay
 * @version 9 June, 2014
 */
public class ProgramChairPanel extends JPanel {
	final StringBuilder stringBuilder = new StringBuilder();
	final JFileChooser fileChooser = new JFileChooser();

	/**
	 * Create the panel.
	 */
	public ProgramChairPanel(final Conference curConf) {
		setSize(500, 500);
		setLayout(null);
		
		final ArrayList<String> paperNameList = new ArrayList<String>();
		for(Paper paper: curConf.getPapers()) {
			paperNameList.add(paper.getName());
		}
	
		final JList paperList = new JList(paperNameList.toArray());
		paperList.setVisibleRowCount(3);
		paperList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		paperList.setBounds(15, 71, 230, 240); //before 480 width
		add(paperList);
		
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
		
		JLabel titleLabel = new JLabel("Program Chair");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		titleLabel.setBounds(154, 15, 191, 37);
		add(titleLabel);
		
		JButton btnAssignReviewers = new JButton("Assign Paper");
		btnAssignReviewers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
					if(user.role.equals("Subprogram Chair") && !curConf.getPaperManager().getPaper(paper).
							getAuthor().userName.equals(user.getUserName())) {
						if(!curConf.getSubprogramListKeys().containsKey(user.userName)) {
							ArrayList<String> listOfPapers = new ArrayList<String>();
							listOfPapers.add(paper.getName());
							curConf.getSubprogramListKeys().put(user.userName, listOfPapers);
							showDialogForPaper();
						} else {
							if(curConf.getSubprogramListKeys().get(user.userName).size() < 4) {
								if(!curConf.getSubprogramListKeys().get(user.userName).contains(paper.getName())) {
									curConf.getSubprogramListKeys().get(user.userName).add(paper.getName());
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
		
		JButton btnRecomendation = new JButton("Recomendation");
		btnRecomendation.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ProgramList newProg = new ProgramList(curConf);
				newProg.show();
			}
		});
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

class ProgramList extends JPanel{
	JFrame frame = new JFrame();
	public ProgramList(Conference conf) {
		setSize(500, 500);
		setLayout(null);
		JLabel lblTitle = new JLabel("Papers");
		lblTitle.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblTitle.setBounds(186, 16, 127, 37);
		add(lblTitle);
		
		StringBuilder list = new StringBuilder();
		for(String sub : conf.getSubprogramListKeys().keySet()) {
			list.append("Subprogram Chair: " + sub + "\n");
			for(String paper : conf.getSubprogramListKeys().get(sub)) {
				list.append("    Paper: " + paper + "\n        Reviewers: ");
				for(Review r : conf.getPaperManager().getPaper(paper).getReviews()) {
					list.append(r.getReviewer() + ", ");
				}
				list.append("\n");
			}
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
