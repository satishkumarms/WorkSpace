package example;

public class Employee {
	
	private long empCode;
	private String empName;
	private Car car;
	
	//constructors
	
	public Car getCar() {
		return car;
	}



	public void setCar(Car car) {
		this.car = car;
	}



	public Employee() {}
	
	

	public Employee(long empCode, String empName,Car car) {
		super();
		this.empCode = empCode;
		this.empName = empName;
		this.car = car;
	}
	
	
	/*	public void setEmpCode(long empCode) {
	this.empCode = empCode;
      }*/



	
	public long getEmpCode() {
		return empCode;
	}

	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	

}
