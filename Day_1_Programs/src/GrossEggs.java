import java.util.Scanner;

public class GrossEggs {
	
	
	public static void main(String args[])
	{
		int total, gross, dozen, rem1, rem2;
		
		 System.out.println("Enter the number of eggs");
		 Scanner sc = new Scanner(System.in);
		 total = sc.nextInt();
		 gross = total/144;
		 rem1 = total%144;
		 dozen = rem1/12;
		 rem2 = rem1%12;
		 
		System.out.println("GROSS :: "+gross+"   DOZEN :: "+dozen+"   REMAINING :: "+rem2);
		 
	}

}
