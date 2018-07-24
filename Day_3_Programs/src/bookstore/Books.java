package bookstore;

public class Books {
	
	private int isbn;
	private String authorname;
	private String title;
	private float price;
	private int stock;
	//constructors
	public Books() {
		super();
	}
	
	
	
	public Books(int isbn, String authorname, String title, float price, int stock) {
		super();
		this.isbn = isbn;
		this.authorname = authorname;
		this.title = title;
		this.price = price;
		this.stock = stock;
	}



	//getters and setters
	public int getIsbn() {
		return isbn;
	}
	
	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}
	public String getAuthorname() {
		return authorname;
	}
	public void setAuthorname(String authorname) {
		this.authorname = authorname;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	
	
	
	

}
