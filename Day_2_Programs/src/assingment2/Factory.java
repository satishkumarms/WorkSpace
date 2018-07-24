package assingment2;

public class Factory {


	public static Shape getInstance(String choice)
	{
		Shape shape= null;
		switch(choice)
		{
		case "R": shape = new Rectangle();
		break;
		case "T": shape = new Triangle();
		break;


		}
		return shape;
	}

}
