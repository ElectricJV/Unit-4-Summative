import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.*;
import javax.swing.*;

/**
 * 
 */

/**
 * @author Joshua
 *
 */
public class CreateAccount extends JFrame implements ActionListener {

	private JLabel lUsername, lPassword;
	private JTextField tUser, tPass, txtName, txtAddress, txtPhone;
	private String user, pass, name, address, phone;
	private JButton bClose, bCreateAccount;
	private Picture logo;
	private Container frame;

	/**
	 * 
	 */
	public CreateAccount() {
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
		bClose = new JButton("Close");

		frame.setLayout(null);

		// Placing the components
		lUsername.setBounds (90, 148, 100, 15);   // Username
		frame.add (lUsername);

		lPassword.setBounds (90, 181, 100, 15);  // Password
		frame.add (lPassword);

		tUser.setBounds (170, 142, 175, 25);  // Username
		frame.add (tUser);

		tPass.setBounds (170, 175, 175, 25); // Password
		frame.add (tPass);

		bClose.setBounds (170, 443, 150, 25);  // Close button
		frame.add (bClose);
		
		bCreateAccount = new JButton("Create Account");
		bCreateAccount.setBounds(170, 350, 150, 25);
		getContentPane().add(bCreateAccount);
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(90, 218, 100, 15);
		getContentPane().add(lblName);
		
		txtName = new JTextField("");
		txtName.setBounds(170, 212, 175, 25);
		getContentPane().add(txtName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(90, 258, 100, 15);
		getContentPane().add(lblAddress);
		
		txtAddress = new JTextField("");
		txtAddress.setBounds(170, 252, 175, 25);
		getContentPane().add(txtAddress);
		
		JLabel lblPhone = new JLabel("Phone");
		lblPhone.setBounds(90, 289, 100, 15);
		getContentPane().add(lblPhone);
		
		txtPhone = new JTextField("");
		txtPhone.setBounds(170, 285, 175, 25);
		getContentPane().add(txtPhone);

		//logo = new Picture(new ImageIcon("DiamondBankLogo.png"), 10, 10);
		//frame.add (logo);

		Dimension dim = Toolkit.getDefaultToolkit ().getScreenSize ();
		this.setLocation (dim.width / 2 - this.getSize ().width / 2, dim.height / 2 - this.getSize ().height / 2);
		bClose.addActionListener(this);
		bCreateAccount.addActionListener(this);

		setVisible(true);
		setResizable(false);
	}

	public void actionPerformed(ActionEvent e)
	{
		Account owner = new Account();
		if (e.getSource() == bCreateAccount)
		{
			try{
			    PrintWriter account = new PrintWriter(tUser.getText() + ".txt");
			    account.println(tUser.getText());
			    account.println(tPass.getText());
			    account.println(txtName.getText());
			    account.println(txtAddress.getText());
			    account.println(txtPhone.getText());
			    account.println(owner.readAccountNumber());
			    account.close();
			} catch (IOException m) {
			   // do something
			}
			dispose();
			new CustomerAccount();
		}
		else if(e.getSource() == bClose)
		{
			System.exit(0);
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		new CreateAccount();
	}
}
