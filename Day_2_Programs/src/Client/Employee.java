package Client;

public class Employee extends Person {
	private int empid;
	private String email;
	private static int count;
	
	//constructor
	public Employee() {
		super();
		this.empid = ++count;
	}

	public Employee(String name, int age, String email) {
		super(name, age);
		this.email = email;
		this.empid = ++count;
	}

	
	//getters and setters
	public int getEmpid() {
		return empid;
	}

	/*public void setEmpid(int empid) {
		this.empid = empid;
	}*/

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	 

	//OVERRIDING toString()
	public String toString()
	{
		return super.toString()+" EMAIL:"+email+" ";
	}

	

}
