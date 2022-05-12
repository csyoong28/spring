package com.soonyoong.youtube.AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T01AOPMain {
	public static void main(String[] args) {
//		usecase1();
		usecase2();
	}

    public static void usecase1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("springAopT01.xml");
		ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		Circle circle = shapeService.getCircle();
		String circleName = circle.getName();
		circle.setNameAndReturn("setNameAndReturn");
		circle.setNameWithException("dummy circle name");
		System.out.println(circleName);
    }
    
    public static void usecase2() {
        ApplicationContext context = new ClassPathXmlApplicationContext("springAopT01.xml");
        ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
        Triangle triangle = shapeService.getTriangle();
        triangle.setName3("abc");
        String triangleName = triangle.getName();
        System.out.println(triangleName);
    }
}
