package Client1;

import Client.Customer;

public class CustomerClient {
	
	public static void main(String[] args)
	{
		Customer customer1 = new Customer();
		System.out.println("Customer Created with id"+customer1.getCustomerId());
		System.out.println(customer1);
		
		Customer customer2 = new Customer("Satish",22,"+91 990 227 9423");
		System.out.println("Customer Created with id"+customer1.getCustomerId());
		System.out.println(customer2);
	}

}
