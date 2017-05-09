
/**
 * @author Jhenelle
 *
 */
public class Customer {
	
	private String name, address, phone; // declare variables

	public Customer() {
		// initialises data
		this.name = "";
		this.address = "";
		this.phone = "";

	}

	public Customer(String name, String address, String phone) {
		// overrides Customer method and initialises variables with specific
		// info
		setName(name);
		setAddress(address);
		setPhone(phone);

	}

	public String getName() {
		// retrieves name
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		// retrieves address
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		// retrieves phone number
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String toString() {
		// returns client info as a String
		return (getName() + "," + getAddress() + "," + getPhone());
	}

	public static void main(String[] args) {
		// self testing main method
		// test setter methods
		Customer cust = new Customer("Sean Smith", "9 Charlton Terrace", "99971623");
		// test getter methods
		System.out.println(cust.toString());// prints customer info
		cust.setName("John Brown"); // updates name
		System.out.println(cust.toString()); // prints updated info

	}

}
