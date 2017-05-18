import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.*;
/*
 * Date: April 20, 2017
 * Author: Muhammad Khan
 * Description: This program displays the main GUI for the customer
 * Method List: 
 */

public class CustomerAccount extends JFrame implements ActionListener
{
	private static final long serialVersionUID = 1L;

	JButton btnHome, btnExit, btnLoadFile, btnWriteFile, btnWithdraw, btnDeposit;

	JTextArea txtAccountInfo, txtChequingList, txtFinalBalance, txtWithdraw, txtSavings;

	JLabel lblInfo;

	private Customer customer;
	private Savings savingsAcct;
	private Chequing chequingAcct;

	String input, output, file = "", type = null, name, address, phone, accountNum;
	char charType;

	int key;

	Font f = new Font("Lucida Grande", Font.PLAIN, 16);

	ActionListener listener = new ActionListener() 
	{
		public void actionPerformed(ActionEvent e) 
		{
			System.out.println("Button selected: " + e.getActionCommand());
			type = e.getActionCommand();
		}
	};

	public CustomerAccount() 
	{
		setResizable(false);
		// try-catch with specific code to ensure the GUI is not distorted on a Windows computer
		try 
		{ // (https://docs.oracle.com/javase/7/docs/api/javax/swing/UIManager.html)
			UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (InstantiationException e) 
		{
			e.printStackTrace();
		} 
		catch (IllegalAccessException e) 
		{
			e.printStackTrace();
		}
		catch (UnsupportedLookAndFeelException e) 
		{
			e.printStackTrace();
		}


		setSize (786-20, 840-35);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setContentPane (new JLabel(new ImageIcon ("Images/Encryptor.png")));
		getContentPane().setLayout (null);
		setLocationRelativeTo (null);

		JToggleButton btnChequing = new JToggleButton("Chequing");
		JToggleButton btnSavings = new JToggleButton("Savings");
		btnChequing.setFont(f);
		btnSavings.setFont(f);
		btnChequing.addActionListener(listener);
		btnSavings.addActionListener(listener);
		btnChequing.setBounds(102, 165, 138, 55);
		btnSavings.setBounds(511, 165, 138, 55);
		getContentPane().add(btnChequing);
		getContentPane().add(btnSavings);


		btnHome = new JButton("Home");
		btnHome.setToolTipText("Press to Return to Home Screen");
		btnHome.setFont(f);
		btnHome.setBounds(29, 706, 138, 55);
		getContentPane().add (btnHome);


		btnExit = new JButton("Exit");
		btnExit.setToolTipText("Press to Exit Program");
		btnExit.setFont(f);
		btnExit.setBounds(607, 706, 138, 55);
		getContentPane().add (btnExit);


		btnLoadFile = new JButton("Load File");
		btnLoadFile.setToolTipText("Press to Load a File");
		btnLoadFile.setFont(f);
		btnLoadFile.setBounds(250, 705, 143, 56);
		getContentPane().add (btnLoadFile);


		btnWriteFile = new JButton("Write File");
		btnWriteFile.setToolTipText("Press to write to file");
		btnWriteFile.setFont(f);
		btnWriteFile.setBounds(405, 704, 143, 58);
		getContentPane().add (btnWriteFile);


		btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setToolTipText("Encrypt Phrase");
		btnWithdraw.setFont(f);
		btnWithdraw.setBounds(209, 630, 130, 41);
		getContentPane().add (btnWithdraw);

		btnDeposit = new JButton("Deposit");
		btnDeposit.setToolTipText("Deposit");
		btnDeposit.setFont(f);
		btnDeposit.setBounds(209, 577, 130, 41);
		getContentPane().add (btnDeposit);
		btnHome.addActionListener (this);
		btnExit.addActionListener (this);
		btnLoadFile.addActionListener (this);
		btnWriteFile.addActionListener (this);
		btnWithdraw.addActionListener(this);
		btnDeposit.addActionListener(this);

		txtAccountInfo = new JTextArea();
		txtAccountInfo.setLineWrap(true);
		txtAccountInfo.setEditable(false);
		txtAccountInfo.setFont(f);
		txtAccountInfo.setForeground(Color.BLACK);
		txtAccountInfo.setBounds(20, 37, 319, 86);
		getContentPane().add(txtAccountInfo);

		txtChequingList = new JTextArea();
		txtChequingList.setEditable(false);
		txtChequingList.setFont(f);
		txtChequingList.setForeground(Color.BLACK);
		txtChequingList.setLineWrap(true);
		txtChequingList.setBounds(20, 224, 328, 341);
		getContentPane().add(txtChequingList);

		txtFinalBalance = new JTextArea("");
		txtFinalBalance.setLineWrap(true);
		txtFinalBalance.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		txtFinalBalance.setOpaque(false);
		txtFinalBalance.setEditable(false);
		txtFinalBalance.setBounds(64, 333, 184, 118);
		getContentPane().add(txtFinalBalance);

		lblInfo = new JLabel("Account Information");
		lblInfo.setFont(f);
		lblInfo.setBounds(20, 6, 219, 41);
		getContentPane().add(lblInfo);

		JTextArea txtSavingsList = new JTextArea();
		txtSavingsList.setEditable(false);
		txtSavingsList.setLineWrap(true);
		txtSavingsList.setForeground(Color.BLACK);
		txtSavingsList.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtSavingsList.setBounds(417, 224, 328, 341);
		getContentPane().add(txtSavingsList);

		JTextArea txtWithdraw = new JTextArea();
		txtWithdraw.setLineWrap(true);
		txtWithdraw.setForeground(Color.BLACK);
		txtWithdraw.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtWithdraw.setBounds(351, 634, 161, 29);
		getContentPane().add(txtWithdraw);

		JTextArea txtDeposit = new JTextArea();
		txtDeposit.setLineWrap(true);
		txtDeposit.setForeground(Color.BLACK);
		txtDeposit.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtDeposit.setBounds(351, 582, 161, 29);
		getContentPane().add(txtDeposit);

		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(333, 224, 15, 341);
		getContentPane().add(scrollBar);

		JScrollBar scrollBar_1 = new JScrollBar();
		scrollBar_1.setBounds(730, 224, 15, 341);
		getContentPane().add(scrollBar_1);

		setVisible (true);
	}


	public void actionPerformed(ActionEvent e) 
	{
		TransactionRecord info = new TransactionRecord();
		TransactionList transactionList = new TransactionList();

		if (e.getSource() == btnHome) 
		{
			dispose();
			new LoginGUI();
		}

		if (e.getSource() == btnExit) 
		{
			System.exit(0);
		}

		if (e.getSource() == btnWithdraw) 
		{
			if (type == "Chequing")
			{
				JOptionPane.showMessageDialog(null,"hello");
				double amt = Integer.parseInt(txtWithdraw.getText());

				info.setTransactionType("Withdraw");
				info.setAccountType('c');
				info.setAmount(amt);
				info.setStartAmount(10000);
				info.setEndAmount(10000-amt);
				info.toString();
				txtWithdraw.setText(displayAccountInfo());

				{
					//if (!Chequing.withdraw(amt)) 
					{
						JOptionPane.showMessageDialog(null, "Insufficient funds");
					}

				}
				//else if (!Savings.withdraw(amt)) 
				{
					JOptionPane.showMessageDialog(null, "Insufficient funds");
				}
				//displayAccountInfo();
			}
			else if (type == "Savings")
			{
				JOptionPane.showMessageDialog(null,"bye");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please choose Chequing or Savings!", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}

		if (e.getSource() == btnDeposit) 
		{
			if (type == "Chequing")
			{
				JOptionPane.showMessageDialog(null,"yoyoyo");
			}
			else if (type == "Savings")
			{
				JOptionPane.showMessageDialog(null,"later");
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Please choose Chequing or Savings!");
			}
		}

		if (e.getSource() == btnLoadFile) 
		{
			try {
				FileReader In = new FileReader (JOptionPane.showInputDialog(null, "Enter Account Username", "Admin.txt")); 
				BufferedReader inputFile = new BufferedReader (In);
				for (int m = 0; m < 3; m++)
				{
					name = inputFile.readLine();
					address = inputFile.readLine();
					phone = inputFile.readLine();
					accountNum = inputFile.readLine();
				}
				inputFile.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String accountInfo = "Name: " + name + "\n" + "Address: " + address + "\n" + "Phone: " + phone + "\n" + "Account #: " + accountNum + "\n" + displayAccountInfo();
			txtAccountInfo.append(accountInfo);
		}

		if (e.getSource() == btnWriteFile) 
		{
			transactionList.insert(info);
			try {
				transactionList.saveListToFile();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		}
	}

	public String displayAccountInfo()
	{
		return ("Name: " + customer.toString() + "\nAccount #: " + savingsAcct.readAccountNumber() + "\nSavings Balance: " + savingsAcct.getBalance() + "\nChequing Balance: " + chequingAcct.getBalance());
	}

	public static void main(String[] args) 
	{
		new CustomerAccount ();
	}
}
