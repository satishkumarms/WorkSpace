package Client;

public class Customer extends Person {
	

	private long customerId;
	private String mobNo;
	private static int count;
	
	//Constructors
	
	public Customer() {
		super();
		this.customerId = ++count;
	}

	public Customer(String name, int age, String mobNo) {
		super(name, age);
		this.mobNo = mobNo;
		this.customerId = ++count;
	}
	
	//getter and setter

	public long getCustomerId() {
		return customerId;
	}

	/*public void setCustomerId(long customerId) {
		this.customerId = customerId;
	}*/

	public String getMobNo() {
		return mobNo;
	}

	public void setMobNo(String mobNo) {
		this.mobNo = mobNo;
	}
	

	//OVERRIDING THE toString()
	public String toString()
	{
		//return "Mobile:"+mobNo+"  age:"+age+" name:"+name;
		 return super.toString()+"Mobile:"+mobNo;
	}
	
	

}
