package bookstore;

import java.util.List;

public class BillGenerator {
	
	/*//private List<Books> book;
	private Cart cart;
	
	public BillGenerator() {
		cart = new Cart();
	}*/

	public void generateBill(Cart cart,String dateDetails)
	{
		System.out.println("INVOICE");
		cart.displayBooks();
		System.out.print(dateDetails);
	}

}
