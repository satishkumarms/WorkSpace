package example;

public class Flowers {
	
	private String color;
	private String name;
	private String size;
	
	// constructors
	public Flowers() {
		super();
	}
	
	public Flowers(String color, String name, String size) {
		super();
		this.color = color;
		this.name = name;
		this.size = size;
	}


  // getters and setters
	
	public String getColor() {
		return color;
	}

	
	
	public void setColor(String color) {
		this.color = color;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSize() {
		return size;
	}
	public void setSize(String size) {
		this.size = size;
	}
	
	

}
