package com.soonyoong.youtube;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T7CodingToInterface {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		//coding to interface of shape
		Shape shape = (Shape) context.getBean("triangle");
		shape.draw();
		Shape shape1 = (Shape) context.getBean("circle");
		shape1.draw();
	}
}
