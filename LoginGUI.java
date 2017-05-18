import java.awt.event.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
	private JTextField tUser;
	private JTextField tPass;
	private JTextArea output;
	private JButton bLogin, bClose, bCreateAccount;
	private Picture logo;
	private Container frame;

	/**
	 * 
	 */
	public LoginGUI() {
		super ("Login");
		setSize (500, 500);
		setLocation (720, 200);
		setDefaultCloseOperation (EXIT_ON_CLOSE); //exits on close
		frame = getContentPane();

		setUndecorated (true);
		frame.setLayout (null);
		setResizable (false);
		lUsername = new JLabel("Username");
		lPassword = new JLabel("Password");
		tUser = new JTextField ("");
		tPass = new JPasswordField (10);
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

		JButton bCreateAccount = new JButton("Create Account");
		bCreateAccount.setBounds(170, 376, 150, 25);
		getContentPane().add(bCreateAccount);

		//logo = new Picture(new ImageIcon("DiamondBankLogo.png"), 10, 10);
		//frame.add (logo);

		Dimension dim = Toolkit.getDefaultToolkit ().getScreenSize ();
		this.setLocation (dim.width / 2 - this.getSize ().width / 2, dim.height / 2 - this.getSize ().height / 2);

		bLogin.addActionListener(this);
		bClose.addActionListener(this);
		bCreateAccount.addActionListener(this);

		setVisible(true);
		setResizable(false);
	}

	public boolean login() throws IOException
	{  
		String password = "";
		String userName = "";

		try{
			FileReader In = new FileReader (JOptionPane.showInputDialog(null, "Enter Account Username", "Admin.txt")); 
			BufferedReader inputFile = new BufferedReader (In);

			userName = inputFile.readLine();
			password = inputFile.readLine();

			inputFile.close();

		} catch(Exception e){

		}
		if(tUser.getText().equalsIgnoreCase(userName) && tPass.getText().equalsIgnoreCase(password)){

			return true;
		}
		return false;
	}

	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource () == bLogin) 
		{
			try {
				if(login()==true)
				{
					JOptionPane.showMessageDialog(null,"Logged In");
					super.dispose();
					new CustomerAccount();                                   
				}
				else
				{ 
					JOptionPane.showMessageDialog(null,"Error");
					//sets text fields back to empty
					tUser.setText("");
					tPass.setText("");                                                
				}
			} catch (HeadlessException | IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}            

		}
		else if(e.getSource() == bClose)
		{
			System.exit(0);
		}
		else if(e.getSource() == bCreateAccount)
		{
			dispose();
			new CreateAccount();
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new LoginGUI();
	}
}
