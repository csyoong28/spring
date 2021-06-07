package com.soonyoong.youtube;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SystemPropertyUtils;

public class T2DrawingAppBeanScope {
	
	public static void main(String[] args) {
		//if have multipe application context in same JVM, then though the bean scope is set to singleton,
		//but still can have multiple instance of it
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		ApplicationContext context2 = new ClassPathXmlApplicationContext("spring2.xml");
		
		Triangle triangle= (Triangle) context.getBean("triangle");
		triangle.draw();
		System.out.println("triangle:" + triangle);
		
		Triangle triangle2= (Triangle) context2.getBean("triangle");
		triangle2.draw();
		System.out.println("triangle2:" + triangle2);
		
		
	}
}
