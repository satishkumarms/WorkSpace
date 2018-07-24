package example;

public class FlowerDemo {
	
	
	public static void main(String[] args)
	{
		Flowers flower = new Flowers("White","Jasmine","small");
		
		System.out.println("Before Setter and getter functions");
	    System.out.println("name of flower:"+ flower.getName()+  "color of the flower: "+flower.getColor()+" size of the flower"+flower.getSize());
	
	    System.out.println("After Setter and getter functions");
	    flower.setColor("yellow");
	    flower.setName("marigold");
	    flower.setSize("Big");
	    
	    System.out.println("name of flower:"+ flower.getName()+" color of the flower: "+flower.getColor()+" size of the flower"+flower.getSize());
	
	}

}
