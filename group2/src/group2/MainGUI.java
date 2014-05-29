package group2;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * 
 * @author Mina Messak
 * @version 5.22.2014
 */
public class MainGUI extends Observable {
	private JFrame frame = new JFrame();
	private boolean loggedIn = true;
	private LogInPanel login = new LogInPanel(this, frame);
	private JPanel author = new AuthorPanel();
	private JPanel reviewer = new ReviewerPanel();
	private JPanel subPM = new SubChairPanel();
	private JPanel newUser = new NewUserPanel(login.userManager);
	private JPanel deleteUser = new DeleteUserPanel();
	private JPanel programChair = new ProgramChairPanel();
	private JPanel newConference = new ConferencePanel();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {	
			public void run() {
				try {
					MainGUI gui = new MainGUI();
					gui.frame.setVisible(true);
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
		frame.setTitle("Confrence Manager");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/group2/logo.jpg")));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
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
			/**
			 * Action Listener for button press. 
			 */
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
		mntmDeleteUser.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				deleteUser.show();
			}
		});
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
//				setPanel(confrence);
				newConference.show();
			}
		});
		mnOther.add(mntmCreateANew);
		mnOther.add(mntmLogOut);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void
			actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(subPM, "Scrum It Up! \nSpring 2014");
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
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(login).setLocation(50, 0);
		
	}
	/**
	 * Method that switches the panels in order to operate in different ways. 
	 * Removes the old panel and replaces is with one that is being passed in. 
	 * @param the_panel
	 */
	public void setPanel(JPanel the_panel){
		frame.getContentPane().removeAll(); //Get current Panel
		frame.repaint(); //Refresh
		frame.getContentPane().add(the_panel).setLocation(50, 0); //Add new panel
		frame.repaint();
		frame.revalidate();
	}
}
