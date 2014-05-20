package group2;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

public class MainGUI extends JFrame {
	private JPanel panel = new JPanel();
	private JPanel author = new AuthorPanel();
	private JPanel LogIn = new LogInPanel();
	private LogInPanel log = new LogInPanel();

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
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/group2/logo.jpg")));
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500, 500);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnUsers = new JMenu("Users");
		menuBar.add(mnUsers);
		
		JMenuItem mntmAuthor = new JMenuItem("Author");
		mntmAuthor.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(LogIn);
				repaint();
			}
		});
		mnUsers.add(mntmAuthor);
		mnUsers.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(LogIn);
				repaint();
			}
		});
		
		JMenuItem mntmReviewer = new JMenuItem("Reviewer");
		mnUsers.add(mntmReviewer);
		mntmReviewer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(LogIn);
				repaint();
			}
		});
		
		JMenuItem mntmSubChair = new JMenuItem("Sub Chair");
		mnUsers.add(mntmSubChair);
		mntmSubChair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(LogIn);
				repaint();
			}
		});
		
		JMenuItem mntmProgramChair = new JMenuItem("Program Chair");
		mnUsers.add(mntmProgramChair);
		mntmProgramChair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setPanel(LogIn);
				repaint();
			}
		});
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mnHelp.add(mntmAbout);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mnHelp.add(mntmExit);
		getContentPane().setLayout(null);
		
	}
		
	public void setPanel(JPanel the_panel){
//		remove(getParent());
		getContentPane().add(the_panel);
	}
}
