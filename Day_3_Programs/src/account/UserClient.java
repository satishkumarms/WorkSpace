package account;

import java.util.Scanner;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserClient {

	public static void main(String[] args)
	{
		String choice;
		String password;
		String password1;
		
		UserAccount useraccount = new UserAccount();
		
		do{
			System.out.println("Enter the User Details");
			System.out.println("Enter the Name");
			String name = new Scanner(System.in).next();
			useraccount.setName(name);
			System.out.println("Enter the pancard number");
			String pancardno = new Scanner(System.in).next();
			useraccount.setPancardno(pancardno);
			System.out.println("Enter the date");
			String pattern = new Scanner(System.in).next();
			SimpleDateFormat simpledateformat = new SimpleDateFormat(pattern);
			String date = simpledateformat.format(new Date());
			System.out.println(date);
			useraccount.setDate(date);
			
			while(true)
			{
				System.out.println("Enter the password");
			     password = new Scanner(System.in).next();
			if(password.length()<4 || password.length()>8)
			{
				System.out.println("PASS IS NOT CORRECT");
				System.out.println("re-enter the password");
			}
			else
				break;
			}
			while(true)
			{
			System.out.println("Enter the password again to confirm");
		       password1 = new Scanner(System.in).next();
			if(password.equals(password1))
			{
				System.out.println("Password is right");
				useraccount.setPassword(password);
				break;
			}
			
			
			}
			System.out.println("Enter the forgot password question");
			String forgotpassques = new Scanner(System.in).nextLine();
			useraccount.setForgotpassques(forgotpassques);
			System.out.println("Enter the forgot password answer");
			String forgotpassans = new Scanner(System.in).nextLine();
			useraccount.setForgotpassans(forgotpassans);
			
			
			System.out.println("Username:"+useraccount.generateUsername());
			System.out.println("Enter y to continue");
			choice = new Scanner(System.in).next();
			
		}while(choice.equals("y"));
	}
}
