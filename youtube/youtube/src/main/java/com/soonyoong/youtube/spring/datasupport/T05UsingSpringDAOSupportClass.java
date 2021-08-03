package com.soonyoong.youtube.spring.datasupport;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T05UsingSpringDAOSupportClass {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring01DataSupport.xml");
		JdbcWithDaoSupport jdbcWithDaoSupport = context.getBean("jdbcWithDaoSupport", JdbcWithDaoSupport.class);
		//insert into DB using named Parameter JDBC Template
		System.out.println(jdbcWithDaoSupport.getCircleCount());

	}
}
