package Client;

public class Utility {
	
	public static void printDetails(Person c)
	{
		System.out.print(c);
		
		if(c instanceof Customer)
		{
			System.out.println(((Customer) c).getMobNo());
			System.out.println("YOU ARE ELLIGIBLE FOR 10 POINTS");
			
		}
		else if( c instanceof Employee)
		{
			System.out.println("This is a employee object");
			System.out.println(((Employee)c).getEmail());
		}
	}

}
