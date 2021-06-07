package com.soonyoong.youtube;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SystemPropertyUtils;

public class T3DrawingAppApplicationContext {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	
		TriangleContextAware triangleContextAware= (TriangleContextAware) context.getBean("triangleContextAware");
		triangleContextAware.getBeanDefinitionNames();
		System.out.println(triangleContextAware.getBeanName());
		
	}
}
