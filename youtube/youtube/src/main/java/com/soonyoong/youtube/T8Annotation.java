package com.soonyoong.youtube;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T8Annotation {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring4Annotation.xml");
		context.registerShutdownHook();
		//using @Autowired
		Shape shape1 = (Shape) context.getBean("circle");
		shape1.draw();
	}
}
