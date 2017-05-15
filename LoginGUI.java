import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

/**
 * 
 */

/**
 * @author Joshua
 *
 */
public class LoginGUI extends JFrame implements ActionListener {

	private JLabel lUsername, lPassword;
	private JTextField tUser, tPass;
	private JTextArea output;
	private JButton bLogin, bClose;
	private Picture logo;
	private Container frame;
	
	/**
	 * 
	 */
	public LoginGUI() {
		super ("Login");
		setSize (500, 500);
		setLocation (720, 200);
		frame = getContentPane();
		
		
		lUsername = new JLabel("Username");
		lPassword = new JLabel("Password");
		tUser = new JTextField();
		tPass = new JTextField();
		bLogin = new JButton("Login");
		bClose = new JButton("Close");
		
		frame.setLayout(null);
		
		// Placing the components
		lUsername.setBounds (90, 200, 100, 15);   // Username
		frame.add (lUsername);

		lPassword.setBounds (90, 245, 100, 15);  // Password
		frame.add (lPassword);

		tUser.setBounds (170, 200, 175, 25);  // Username
		frame.add (tUser);

		tPass.setBounds (170, 245, 175, 25); // Password
		frame.add (tPass);
		
		bLogin.setBounds (75, 325, 150, 25);    // Login button
		frame.add (bLogin);

		bClose.setBounds (250, 325, 150, 25);  // Close button
		frame.add (bClose);
		
		logo = new Picture(new ImageIcon("DiamondBankLogo.png"), 10, 10);
		frame.add (logo);
		
		bLogin.addActionListener(this);
		bClose.addActionListener(this);
		
		setVisible(true);
		setResizable(false);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource () == bLogin) {
			
		}
		else if (e.getSource () == bClose) {
			System.exit(0);
		}
		
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new LoginGUI();

	}

}
