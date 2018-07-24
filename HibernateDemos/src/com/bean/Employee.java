package com.bean;

public class Employee {
	
	private Long empId;
	private String name;
	private String email;
	
	//reference of depId
	private Department dept;
	public Department getDept() {
		return dept;
	}
	public void setDept(Department dept) {
		this.dept = dept;
	}
	//reference of address
	private Address address;
	public Employee() {
		super();
	}
	public Employee(String name, String email, Address address, Department dept) {
		super();

		this.name = name;
		this.email = email;
		this.address = address;
		this.dept = dept;
	}

	public Long getEmpId() {
		return empId;
	}
	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", email=" + email + ", address=" + address + "]";
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	

}
