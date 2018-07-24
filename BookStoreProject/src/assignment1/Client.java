package assignment1;

import java.util.HashMap;
import java.util.Scanner;

public class Client {
	
	private String username;
	private String userpass;
	private String phoneno;
	private Cart cart;
	private HashMap<String, String> userdetails;
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}
	
	
	
	
	public Client() {
		cart = new Cart();
		 userdetails = new HashMap<String, String>();
		 userdetails.put("user1", "pass1");
		 userdetails.put("user2", "pass2");
		 userdetails.put("user3", "pass3");
		 userdetails.put("user4", "pass4");
	}
	public Client(String username, String userpass, String phoneno, HashMap<String, String> userdetails) {
		super();
		this.username = username;
		this.userpass = userpass;
		this.phoneno = phoneno;
		this.userdetails = userdetails;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUserpass() {
		return userpass;
	}
	public void setUserpass(String userpass) {
		this.userpass = userpass;
	}
	public String getPhoneno() {
		return phoneno;
	}
	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public HashMap<String, String> getUserdetails() {
		return userdetails;
	}
	public void setUserdetails(HashMap<String, String> userdetails) {
		this.userdetails = userdetails;
	}
	
	public Boolean validateUser()
	{
		
		System.out.println("Enter the USERNAME:");
		username = new Scanner(System.in).next();
		System.out.println("Enter the USER-PASSWORD");
		userpass = new Scanner(System.in).next();
		
		if(userdetails.containsKey(username) && userdetails.containsValue(userpass))
		{
			System.out.println("Vola! login was successful");
			System.out.println("Enter the Phone number");
			phoneno = new Scanner(System.in).next();
			return true;
		}
		return false;
		
	}
	public void addCart(Cart cart)
	{
		this.cart = cart;
	}
	

}
