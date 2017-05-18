/*
 * Name: Muhammad Khan
 * Date: May 4, 2017
 * Description:
 * Method List:
 * 		main(String[]) -- Main method for self testing
 */
public class Chequing extends Account
{
	private double fee;

	public Chequing(Customer owner)
	{
		super(owner);
		this.fee = 1.25;
	}

	public boolean withdraw(double amount)
	{
		return (super.withdraw(amount + fee));
	}

	public boolean deposit(double amount)
	{
		return (super.deposit(amount - 2.50));
	}

	public void setFee(double fee)
	{
		this.fee = fee;
	}

	public String toString()
	{
		return readAccountNumber() + "," + getBalance();
	}

	public static void main(String[] args) 
	{
		Customer owner = new Customer("David Suzuki", "45 Daviselm Drive", "9054577941");
		Chequing cheq = new Chequing(owner);
		Account account = new Account();

		account.setBalance(420.04); //setting balance 
		System.out.println("Owner withdraw Success = " + account.withdraw(420.04)); // Depositing
		System.out.println("Owner withdraw Success = " + account.withdraw(-200.04)); // Depositing
		System.out.println(account.getBalance());

		System.out.println("Owner deposit Success = " + account.deposit(20.00)); // Depositing
		System.out.println("New Balance " + account.getBalance());
		System.out.println("Account Info " + account.toString());
	}
}
