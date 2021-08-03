package com.soonyoong.youtube.spring.datasupport;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T06UsingHibernate {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring01DataSupport.xml");
		HibernateDaoImpl hibernateDaoImpl = context.getBean("hibernateDaoImpl", HibernateDaoImpl.class);
		//insert into DB using named Parameter JDBC Template
		System.out.println(hibernateDaoImpl.getCircleCount());

	}
}
