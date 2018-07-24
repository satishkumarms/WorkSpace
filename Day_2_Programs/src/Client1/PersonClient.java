package Client1;

import Client.Person;

public class PersonClient {
	
	public static void main(String[] args)
	{
		Person person = new Person("Satish",22);
		System.out.println(person.getName()+" "+person.getAge());
		System.out.println(person); // calls toString() OF Object
	}

}
