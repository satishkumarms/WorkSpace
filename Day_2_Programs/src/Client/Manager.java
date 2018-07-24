package Client;

public class Manager extends Employee {
	
    private String department;
    
    

	public Manager() {
		super();
	}

	public Manager(String name, int age, String email, String department) {
		super(name, age, email);
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}
    
    
	//OVERRIDING toString()
	
	public String toString()
	{
		return super.toString()+" department:"+department;
	}
	
}
