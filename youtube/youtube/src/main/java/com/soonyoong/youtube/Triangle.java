package com.soonyoong.youtube;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Triangle implements Shape{
	private Point pointA;
	private Point pointB;
	private Point pointC;
	
	public void draw() {
		System.out.println("Triangle [pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + "]");
	}
	
	public void myInit() {
		System.out.println("myInit is called");
	}
	
	public void myDestroy() {
		System.out.println("myDestroy is called");
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	

	
}
