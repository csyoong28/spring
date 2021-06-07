package com.soonyoong.youtube;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class TriangleContextAware implements ApplicationContextAware, BeanNameAware{
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private ApplicationContext applicationContext;
	private String beanName;
	
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}
	public void setBeanName(String name) {
		this.beanName = name;
	}
	//show all beans in the context
	public void getBeanDefinitionNames() {
		System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
	}
	
	public void draw() {
		System.out.println("Triangle [pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + "]");
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
	public String getBeanName() {
		return beanName;
	}
	

	
}
