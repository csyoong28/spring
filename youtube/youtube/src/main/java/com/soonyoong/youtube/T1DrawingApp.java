package com.soonyoong.youtube;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SystemPropertyUtils;

public class T1DrawingApp {
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		Triangle triangle= (Triangle) context.getBean("triangle");
		triangle.draw();
		
		
		//using inner bean
		Triangle triangleInnerBean= (Triangle) context.getBean("triangleInnerBean");
		triangleInnerBean.draw();
		
		//using alias by tag
		Triangle triangleInnerBeanAlias= (Triangle) context.getBean("triangleInnerBeanAlias");
		triangleInnerBeanAlias.draw();
		//using alias by bean name
		Triangle triangleInnerBeanName= (Triangle) context.getBean("triangleInnerBeanName");
		triangleInnerBeanName.draw();
		
		//using list
		System.out.println("using list");
		TriangleList triangleList= (TriangleList) context.getBean("triangleList");
		triangleList.draw();
		System.out.println("using autowire");
		Triangle triangleAutoWire= (Triangle) context.getBean("triangleAutoWire");
		triangleAutoWire.draw();
		
		System.out.println("using prototype");
		Triangle triangleProto= (Triangle) context.getBean("triangleProto");
		triangleProto.draw();
		System.out.println("proto:" + triangleProto);
		Triangle triangleProto1= (Triangle) context.getBean("triangleProto");
		triangleProto1.draw();
		System.out.println("proto1:" + triangleProto1);
		Triangle triangle1= (Triangle) context.getBean("triangle");
		System.out.println("singleton: " + triangle);
		System.out.println("singleton1: " + triangle1);
		
		
	}
}
