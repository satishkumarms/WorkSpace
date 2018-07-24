package example;

public class EmployeeDemo {
	
	public static void main(String args[])
	{
	    Car car = new Car("Red","Rangeover");
		Employee sam = new Employee(1234,"WIN",car);
      
		
		/*sam.setEmpCode(1234);
        
		sam.setEmpName("WINDOWS");
		System.out.println(sam.getEmpCode()+" "+sam.getEmpName());
		*/
		
		System.out.println(sam.getEmpName()+" travels in "+ sam.getCar().getColor()+ sam.getCar().getName()+"car");
		
	}

}
