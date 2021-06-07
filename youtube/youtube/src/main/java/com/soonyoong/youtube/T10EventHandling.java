package com.soonyoong.youtube;

import java.util.Locale;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T10EventHandling {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring6EventHandling.xml");
		context.registerShutdownHook();

		Circle circle = (Circle) context.getBean("circle");
		circle.draw();
	}
}
