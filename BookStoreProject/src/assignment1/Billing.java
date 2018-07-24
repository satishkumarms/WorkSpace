package assignment1;

import java.util.ArrayList;
import java.util.List;

public class Billing {
	
	private Client clientbill;
	
	
	

	public Billing() {
		clientbill = new Client();
	}

	public Billing(Client clientbill) {
		super();
		this.clientbill = clientbill;
	}

	public Client getClientbill() {
		return clientbill;
	}

	public void setClientbill(Client clientbill) {
		this.clientbill = clientbill;
	}
	public void addClientBill(Client clientbill)
	{
		this.clientbill = clientbill;
	}
	public void generateBill()
	{
		float total = 0;
		System.out.println("-----------------------");
		System.out.println("INVOICE");
		System.out.println("UserName :"+ clientbill.getUsername());
		System.out.println("UserPhoneNo:"+ clientbill.getPhoneno());
		System.out.println("PRODUCT DETAILS");
		Cart cart = new Cart();
		cart = clientbill.getCart();
		cart.viewCart();
		List<Book> books = new ArrayList<>();
		books = cart.getBooks();
		for(Book book: books)
		{
			total += book.getStock()*book.getPrice();
			
		}
		System.out.println("Date of purchase"+cart.getDateofpurchace());
		System.out.println("Total price :"+ total);
		System.out.println("-----------------------");
		
		
	}
	
	


}
