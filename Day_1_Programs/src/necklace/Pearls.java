package necklace;

public class Pearls {
	
	private String color;
	private String size;
	private String Shapes;
	
	//constructors
	
	public Pearls() {
		super();
	}

	public Pearls(String color, String size, String shapes) {
		super();
		this.color = color;
		this.size = size;
		Shapes = shapes;
	}

	//getter and setter functions
	
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public String getShapes() {
		return Shapes;
	}

	public void setShapes(String shapes) {
		Shapes = shapes;
	}
	

}
