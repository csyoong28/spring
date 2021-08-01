package com.soonyoong.youtube.AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T03AOPCustomAnnotation {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springAopT01.xml");
		ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		Circle circle = shapeService.getCircle();
		/*String circleName = circle.getName();
		circle.setNameAndReturn("setNameAndReturn");
		circle.setNameWithException("dummy circle name");
		System.out.println(circleName);*/
	}
}
