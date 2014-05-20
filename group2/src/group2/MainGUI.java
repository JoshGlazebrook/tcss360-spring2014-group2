package group2;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MainGUI extends JFrame {
	private boolean loggedIn = true;
	private JPanel login = new LogInPanel();
	private JPanel author = new AuthorPanel();
	private JPanel reviewer = new ReviewerPanel();
	private JPanel subPM = new SubChairPanel();
	private JPanel newUser = new NewUserPanel();
	private JPanel programChair = new ProgramChairPanel();
	private JPanel confrence = new ConferencePanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {	
			public void run() {
				try {
					MainGUI gui = new MainGUI();
					gui.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setTitle("Confrence Manager");
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/group2/logo.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 600);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsers = new JMenu("Users");
		menuBar.add(mnUsers);
		
		JMenuItem mntmAuthor = new JMenuItem("Author");
		mntmAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loggedIn) setPanel(author);
				else{
					JOptionPane.showMessageDialog(author, "Please Log In");
				}
			}
		});
		mnUsers.add(mntmAuthor);
		
		JMenuItem mntmReviewer = new JMenuItem("Reviewer");
		mntmReviewer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loggedIn) setPanel(reviewer);
				else{
					JOptionPane.showMessageDialog(reviewer, "Please Log In");
				}
			}
		});
		mnUsers.add(mntmReviewer);

		JMenuItem mntmSubChair = new JMenuItem("Sub Program Chair");
		mntmSubChair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loggedIn) setPanel(subPM);
				else{
					JOptionPane.showMessageDialog(subPM, "Please Log In");
				}
			}
		});
		mnUsers.add(mntmSubChair);

		
		JMenuItem mntmProgramChair = new JMenuItem("Program Chair");
		mntmProgramChair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(loggedIn) setPanel(programChair);
				else{
					JOptionPane.showMessageDialog(programChair, "Please Log In");
				}
			}
		});
		mnUsers.add(mntmProgramChair);
;
		
		JMenu mnOther = new JMenu("Other");
		menuBar.add(mnOther);
		
		JMenuItem mntmAddUser = new JMenuItem("Add User");
		mntmAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				newUser.show();
			}
		});
		mnOther.add(mntmAddUser);
		
		JMenuItem mntmDeleteUser = new JMenuItem("Delete User");
		mnOther.add(mntmDeleteUser);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		JMenuItem mntmCreateANew = new JMenuItem("Create a New Conference");
		mntmCreateANew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(confrence);
			}
		});
		mnOther.add(mntmCreateANew);
		mnOther.add(mntmLogOut);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(subPM, "Scrum It Up! \n Spring 2014");
			}
		});
		mnHelp.add(mntmAbout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mnHelp.add(mntmExit);
		getContentPane().setLayout(null);
		
		getContentPane().add(login).setLocation(50, 0);
		
	}
	
	public void setPanel(JPanel the_panel){
		getContentPane().removeAll();
		repaint();
		getContentPane().add(the_panel).setLocation(50, 0);
		repaint();
		revalidate();
	}
}
