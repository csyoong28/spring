package com.soonyoong.youtube.spring.datasupport;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T04UsingSpringNamedParameterJdbcTemplate {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring01DataSupport.xml");
		SpringJDBCDaoImpl springJDBCDaoImpl = context.getBean("springJDBCDaoImpl", SpringJDBCDaoImpl.class);
		//insert into DB using named Parameter JDBC Template
		springJDBCDaoImpl.insertCircleByNamedParameter(new Circle(4, "4th, which is being inserted"));

	}
}
