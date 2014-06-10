package group2;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
/**
 * 
 * @author Mina Messak, Anh Bui
 * @version 5.22.2014
 */
public class MainGUI {
	public JFrame frame = new JFrame();
	private boolean loggedIn = true;
	private LogInPanel login = new LogInPanel(this);
	
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
		frame.setTitle("Conference Manager");
		frame.setIconImage(Toolkit.getDefaultToolkit().getImage(MainGUI.class.getResource("/group2/logo.jpg")));
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 600);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnOther = new JMenu("Options");
		menuBar.add(mnOther);
		
		JMenuItem mntmLogOut = new JMenuItem("Log Out");
		mntmLogOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				login.clearTxt();
				setPanel(login);
			}
		});
		
		mnOther.add(mntmLogOut);
		
		JMenu mnHelp = new JMenu("Help");
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void
			actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(login, "Scrum It Up! \nSpring 2014");
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
