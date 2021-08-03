package com.soonyoong.youtube.spring.datasupport;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T02UsingSpringJDBC {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring01DataSupport.xml");
		SpringJDBCDaoImpl springJDBCDaoImpl = context.getBean("springJDBCDaoImpl", SpringJDBCDaoImpl.class);
		
		Circle circle = springJDBCDaoImpl.getCircle(1);
		System.out.println(circle);
		
		int circleCount = springJDBCDaoImpl.getCircleCount();
		System.out.println(circleCount);
		String circleName = springJDBCDaoImpl.getCircleName(1);
		System.out.println(circleName);
		Circle circleForId = springJDBCDaoImpl.getCircleForId(1);
		System.out.println(circleForId);
		List<Circle> allCircles = springJDBCDaoImpl.getAllCircles();
		System.out.println(allCircles);
	}
}
