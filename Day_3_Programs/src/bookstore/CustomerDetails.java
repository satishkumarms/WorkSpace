package bookstore;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class CustomerDetails {

	private HashMap<String, String> map;
	private Date date;
	private String dateDetails;
	private Cart cart;
	private BillGenerator bill;

	public CustomerDetails(HashMap<String, String> map) {

		this.map = map;
	}

	public CustomerDetails() {

		map = new HashMap<>();
		map.put("user1", "user11234");
		map.put("user2", "user21234");
		map.put("user3", "user31234");
		map.put("user4", "user41234");
		bill = new BillGenerator();

	}
	public Boolean validateUser(String user, String password)
	{
		if(map.containsKey(user) && map.containsValue(password))
		{
			System.out.println("VALID USER");
			SimpleDateFormat format =  new SimpleDateFormat("dd-M-yyyy hh:mm:ss");
			date = new Date();
			dateDetails = format.format(date);
			
			return true;
		}
		return false;
	}
	public void sendCustomerCartDetails(Cart cart)
	{
		this.cart = cart;
	}

	public void generateBillForCustomer()
	{
		bill.generateBill(cart,dateDetails);
		
	
	}





}