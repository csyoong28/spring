package com.soonyoong.youtube.AOP;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T04AOPWithXML {
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("springAopT04.xml");
		ShapeService shapeService = context.getBean("shapeService", ShapeService.class);
		Circle circle = shapeService.getCircle();
	}
}
