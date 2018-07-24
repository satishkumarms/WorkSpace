package AssignmentDay2;

import java.util.Scanner;

public class ArrayListClient {


	public static void main(String[] args)
	{
		MyArrayList array = new MyArrayList();
		String choice;
		int element;
		do
		{
			System.out.println("Enter ADD: to add INDEX: to get index EXIT to exit");
			choice = new Scanner(System.in).next();
			if(choice.equals("ADD"))
			{
				System.out.println("Enter element");
				element = new Scanner(System.in).nextInt();

				array.add(element);

			}
			else if(choice.equals("INDEX"))
			{
				System.out.println("Enter INDEX");
				int index = new Scanner(System.in).nextInt();

				element = array.get(index);
				if(element==-1)
					System.out.println("NOT ABLE TO FETCH THE ELEMENT");
				else
					System.out.println(" FETCHED ELEMENT IS"+element);
			}
			else 
				System.exit(0);
		}while(!choice.equals("EXIT"));

		System.out.println("TERMINATED!!!!");

	}

}
