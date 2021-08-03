package com.soonyoong.youtube.spring.datasupport;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Circle {
	@Id
	private int id;
	private String name;
	

	public Circle(int id, String name) {
		this.id = id;
		this.name = name;
	}

	public Circle() {}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
		//System.out.println(" circle's setName() is called");
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Circle [id=" + id + ", name=" + name + "]";
	}
}
