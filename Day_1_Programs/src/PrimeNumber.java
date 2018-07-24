import java.util.Scanner;


public class PrimeNumber {
	
	 public static void main(String args[])
	 {
		 Scanner sc = new Scanner(System.in);
		 System.out.println("ENTER THE NUMBER");
		 int prime = sc.nextInt();
		 Boolean result = Utilities.isprime(prime);
		 if(result==true)
		 {
			  System.out.println("ITS PRIME NUMBER");
		 }
		 else
		 {
			 System.out.println("NOT A PRIME NUMBER");
		 }
	 }

}
