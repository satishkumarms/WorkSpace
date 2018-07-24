package Client;

public class Person {

	protected String name;
	protected int age;

	//constructor
	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	//getters and setter
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}

	//override toString()

	public String toString()
	{
		return name+" "+age;
	}

}
