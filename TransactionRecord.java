/**
 * 
 */

/**
 * @author Jhenelle
 * Date: May 2017
 * Description:
 * Method List:
 * 
 * 	TransactionRecord()- Constructor; initialises all private variables 
 * 	getTransactionType() - retrieves transaction Type
 * 	setTransactionType(String transactionType)- sets Transaction Type based on its input parameter 
 * 	getAmount() - retrieves amount 
 * 	setAmount(double amount)- sets user amount
 * 	getStartAMount() - retrieves start amount on user account 
 * 	setStartAmount(double startAmount)- sets starts amount from user account 
 * 	getEndAmount() - retrieves end account on account after transaction 
 * 	setEndAmount(double EndAmount)- sets end amount based on account 
 * 	getAccountType() - retrieves the type of account
 * 	setAccountType(char AccountType)- sets user account type 
 *	toString()- returns info as a String
 *	main (String [] args)- self testing method  
 *
 */
	public class TransactionRecord {
		//declares variables 
		private String transactionType;
		private double amount, startAmount, endAmount;
		private char accountType;
		
	
		public TransactionRecord(){
			//initialises variables 
			String transactionType="";
			double amount = 0;
			double startAmount =0;
			double endAmount = 0;
			char accountType = " ".charAt(0);
			
		}
		
	
		public String getTransactionType() {
			return transactionType; // retrieves transaction type
		}
	
		public void setTransactionType(String transactionType) {
			this.transactionType = transactionType; 
		}
	
		public double getAmount() {
			return amount; // retrieves amount 
		}
	
		public void setAmount(double amount) {
			this.amount = amount;
		}
	
		public double getStartAmount() {
			return startAmount; // retrieves start amount 
		}
	
		public void setStartAmount(double startAmount) {
			this.startAmount = startAmount;
		}
	
		public double getEndAmount() {
			return endAmount; // retrieves end amount 
		}
	
		public void setEndAmount(double endAmount) {
			this.endAmount = endAmount;
		}
	
		public char getAccountType() {
			return accountType; // retrieves end amount 
		}
	
		public void setAccountType(char accountType) {
			this.accountType = accountType;
		}
		
		public String toString(){
			return (getTransactionType() +","+ getAccountType()+","+ getAmount()+"," + getStartAmount() +","+ getEndAmount()); 
		}
		
		public static void main(String[] args) {
			//self testing main
			
			TransactionRecord info = new TransactionRecord();
			//sets info 
			info.setTransactionType("Withdraw");
			info.setAccountType('s');
			info.setAmount(574.50);
			info.setStartAmount(950.00);
			info.setEndAmount(375.50);
			System.out.println(info.toString()); //calls toString method and displays info			
	
		}
	
	}
