package assingment2;

import java.util.Scanner;

public class Abstraction {

	public static void main(String[] args)
	{
		System.out.println("Enter the choice R/T/C");
		String choice = new Scanner(System.in).next();
		Shape shape = null;
		shape = Factory.getInstance(choice);
		if(shape==null)
		{
			System.out.println("Not Implemented");
		}
		else
			shape.draw();
		shape.finish();
	}

}
