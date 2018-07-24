package basic;

import java.util.Scanner;

import com.assignmentday3.UserAuthentication;

public class Client {

	public static void main(String[] args)
	{
		String choice;
		do{		
		System.out.println("Enter the User Name");
		String username = new Scanner(System.in).next();
		UserAuthentication user = new UserAuthentication();
		user.setUsername(username);
		Boolean result = user.validateUserName();
		if(result)
		{
			System.out.println("UserName is valid");
			System.out.println("Enter the password");
			String password = new Scanner(System.in).next();
			user.setPassword(password);
			result = user.validateUserPassword();
			if(result)
			{
				System.out.println("Password is valid");
 
			}
			else
			{
				System.out.println("Password is invalid");
			}
		}
		else{

			System.out.println("UserName is invalid");

		}

		System.out.println("Want to try press key y|Y");
		 choice = new Scanner(System.in).next();
		}while(choice.equals("y") || choice.equals("Y"));
			
		System.out.println("terminated");
	}
	

}

