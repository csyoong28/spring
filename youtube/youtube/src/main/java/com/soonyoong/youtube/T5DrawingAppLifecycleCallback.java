package com.soonyoong.youtube;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.SystemPropertyUtils;

public class T5DrawingAppLifecycleCallback {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
		context.registerShutdownHook();
		TriangleLifeCycle triangleLifeCycle = (TriangleLifeCycle) context.getBean("triangleLifeCycle");
		triangleLifeCycle.draw();
		
		Triangle triangleLifeCycleByConfig = (Triangle) context.getBean("triangleLifeCycleByConfig");
		triangleLifeCycle.draw();
		
		
	}
}
