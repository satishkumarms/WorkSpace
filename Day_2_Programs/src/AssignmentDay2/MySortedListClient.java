package AssignmentDay2;

import java.util.Scanner;

public class MySortedListClient {

	public static void main(String[] args)
	{
		MySortedList array = new MySortedList();
		String choice;
		int element;
		do
		{
			System.out.println("Enter ADD to get SORT EXIT to exit");
			choice = new Scanner(System.in).next();
			if(choice.equals("ADD"))
			{
				System.out.println("Enter element");
				element = new Scanner(System.in).nextInt();

				array.add(element);

			}
			else if(choice.equals("SORT"))
			{
				System.out.println("AFTER SORTING");
				array.sort();

			}
			else 
				System.exit(0);
		}while(!choice.equals("EXIT"));
		System.out.println("TERMINATED!!!!");
	}
}