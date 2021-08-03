package com.soonyoong.youtube.spring.datasupport;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T03UsingSpringJDBCWriteToDB {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring01DataSupport.xml");
		SpringJDBCDaoImpl springJDBCDaoImpl = context.getBean("springJDBCDaoImpl", SpringJDBCDaoImpl.class);
		//insert into DB
		springJDBCDaoImpl.insertCircle(new Circle(3, "3rd, which is being inserted"));
		
		//DDL, create triangle table
		springJDBCDaoImpl.createTriangleTable();
	}
}
