package Client1;

import Client.Employee;

public class EmployeeClient {

	public static void main(String[] args[])
	{
		 Employee employee1 = new Employee();
		 System.out.println("Employee id created with "+ employee1.getEmpid());
		 System.out.print(employee1);
		 
		 Employee employee2 = new Employee("Shesha",22,"shesha@gmail.com");
		 System.out.println("Employee id created with "+ employee2.getEmpid());
		 System.out.print(employee2);
		 
	}
	
}
