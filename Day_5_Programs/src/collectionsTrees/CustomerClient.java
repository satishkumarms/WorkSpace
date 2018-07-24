package com.collections;

import java.util.Scanner;
import java.util.Set;

public class CustomerClient {

	public static void main(String[] args) {

		Customer sam = new Customer();
		Set<Book> bookSet = sam.getBookSet();

		for(Book book:bookSet)
		{
			System.out.println(book);
		}
		System.out.println("----------------------------Store----------");


		while(true)
		{
			System.out.println("Enter the isbn of the book to be added to Cart");
			Scanner sc = new Scanner(System.in);

			if(sam.addToCart(sc.next()));
			System.out.println("1 item added to Cart..");

			System.out.println("Press 1 to continue shopping..else any other number");
			sc.reset();
			if(sc.nextInt()!=1)
				break;


		}
		System.out.println("Your Cart Details........");
		// cart
		System.out.println(sam.viewCart());


	}

}
