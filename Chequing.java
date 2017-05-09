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

	public void setFee(double fee)
	{
		this.fee = fee;
	}

	public String toString()
	{
		return generateAcctNumber() + "," + getBalance();
	}

	public static void main(String[] args) 
	{
		
	}
}
