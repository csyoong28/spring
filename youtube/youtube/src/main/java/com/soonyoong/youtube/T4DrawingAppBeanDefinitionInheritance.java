package com.soonyoong.youtube;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SystemPropertyUtils;

public class T4DrawingAppBeanDefinitionInheritance {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
	
		Triangle triangleInherit = (Triangle) context.getBean("triangleInherit");
		triangleInherit.draw();
		
	}
}
