package com.soonyoong.youtube.AOP;

import com.soonyoong.youtube.AOP.aspect.Loggable;

public class ShapeService {
	private Circle circle;
	private Triangle triangle;
	
	@Loggable	//is custom annotation for AOP pointcut
	public Circle getCircle() {
		System.out.println("circle getter is called");
		return circle;
	}

	public void setCircle(Circle circle) {
		this.circle = circle;
	}

	public Triangle getTriangle() {
		return triangle;
	}

	public void setTriangle(Triangle triangle) {
		this.triangle = triangle;
	}

}
