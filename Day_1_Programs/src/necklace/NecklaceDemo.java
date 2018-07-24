package necklace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class NecklaceDemo {
	
	public static void main(String[] args)
	{
		
	    Scanner sc = new Scanner(System.in);
	    char ch;
	    String color, size, shape;
	    Boolean flag = true;
		Pearls pearl = new Pearls("red","small","round");
		Necklace necklace = new Necklace(pearl);

		List<Necklace> Necklacelist = new ArrayList<>();

		System.out.println("Before User Providing the list");
		System.out.println("Color of pearl ="+necklace.getPearl().getColor()+ "Size of pearl="+necklace.getPearl().getSize()+"Shape of color is ="+necklace.getPearl().getColor());
		
		
		while(flag==true)
		{ 
			Necklace neck1 = new Necklace();
			System.out.println("Enter the pearl");
			System.out.println("Enter the color");
			color = sc.nextLine();
			neck1.getPearl().setColor("color");
			System.out.println("Enter the shape");
			shape = sc.nextLine();
			System.out.println("Enter the size");
			size = sc.nextLine();
			neck1.getPearl().setShapes(shape);
			neck1.getPearl().setSize(size);
			
			Necklacelist.add(neck1);
			
			System.out.println("After User Providing the list");
			System.out.println("Color of pearl ="+necklace.getPearl().getColor()+ "Size of pearl="+necklace.getPearl().getSize()+"Shape of color is ="+necklace.getPearl().getColor());
			
			
			System.out.println("Enter y|Y if you to add pearls");
			ch = sc.next().charAt(0);
			if(ch!='y' || ch!='Y')
			{
				flag = false;
			}
			
		}
	}
	
	

}
