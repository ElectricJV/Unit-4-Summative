import javax.swing.*;

/**
 * 
 */

/**
 * @author Joshua
 * Date: May 2017
 * Description: 
 * Method List: Savings(Customer owner) - Constructor to create a savings account.
 * 				withdraw(double amt) - Method that withdraws a sum of money from the savings account.
 * 				changeFee(double fee) - Method to change the fee.
 * 				toString() - Method which returns the owner's information and the balance in their account.
 * 				main(String[] args) - Self-Testing main method.
 */
public class Savings extends Account {

	// Private data variables
	private double minBalance = 2000.00;
	private double fee = 1.25;

	/**
	 * Constructor to create a Savings account.
	 * Calls the parent constructor.
	 */
	public Savings(Customer owner) {
		super(owner);
	}

	/**
	 * Method to withdraw a sum of money from the savings account.
	 * Checks if balance is sufficient.
	 * Charges a fee if balance is below the minimum.
	 */
	public boolean withdraw(double amt) {
		double balance = super.getBalance();

		if (balance >= minBalance) {
			return super.withdraw(amt);
		}
		else {
			return super.withdraw(amt + fee);
		}
	}

	/**
	 * Method to change the fee when withdrawing.
	 */
	public double changeFee(double newFee) {
		this.fee = newFee;
		return fee;
	}

	/**
	 * Method to convert the owner and their balance to a string.
	 */
	public String toString() {
		return getOwner() + ", " + getBalance();
	}

	/**
	 * Self-Testing Main
	 */
	public static void main(String[] args) {

		Customer cust = new Customer("Boss", "123 Money Street", "123-456-7890");

		Savings account = new Savings(cust);

		JOptionPane.showMessageDialog(null, "Account number: " + account.readAccountNumber() + "\nCustomer: " + account.getOwner());

		double newFee = Double.parseDouble(JOptionPane.showInputDialog(null, "Enter Fee: "));
		account.changeFee(newFee);

		double amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter the initial amount for your account: "));
		account.setBalance(amount);

		System.out.println("Account: $" + account.getBalance());

		amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter amount to deposit: ")); 
		account.deposit(amount);

		System.out.println("Account (after deposit): $" + account.getBalance());

		amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Please enter amount to withdraw: "));

		while (!account.withdraw(amount))
		{
			amount = Double.parseDouble(JOptionPane.showInputDialog(null, "Not enough funds. Please enter new amount: "));;
		}

		System.out.println("New balance: $" + account.getBalance());
		System.out.println("Final Account: " + account.toString());
	}
}