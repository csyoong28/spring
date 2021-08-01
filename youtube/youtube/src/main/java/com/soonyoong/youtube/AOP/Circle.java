package com.soonyoong.youtube.AOP;

public class Circle {
	private String name;
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		System.out.println(" circle's setName() is called"); 
	}
	
	public void setNameWithException(String name) {
		this.name = name;
		System.out.println(" circle's setName() is called");
		throw new RuntimeException(); 
	}
	
	public String setNameAndReturn(String name) {
		this.name = name;
		System.out.println(" circle's setName() is called"); 
		return name;
	}
	
}
