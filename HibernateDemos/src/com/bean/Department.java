package com.bean;

public class Department {
	
	
	private Long depId;
	private String name;
	public Department() {
		super();
	}
	public Department(String name) {
		super();
		this.name = name;
	}
	public Long getDepId() {
		return depId;
	}
	public void setDepId(Long depId) {
		this.depId = depId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	

}
