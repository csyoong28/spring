package com.soonyoong.youtube.spring.datasupport;

public class T01UsingJDBC {
	
	public static void main(String[] args) {
		Circle circle = new JDBCDaoImpl().getCircle(1);
		System.out.println(circle);
	}
}
