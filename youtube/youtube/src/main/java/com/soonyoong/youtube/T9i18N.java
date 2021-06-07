package com.soonyoong.youtube;

import java.util.Locale;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class T9i18N {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring5i18N.xml");
		context.registerShutdownHook();
		System.out.println(context.getMessage("greeting", null, "Default Greeting", new Locale("ms","MY")));
		Circle circle = (Circle) context.getBean("circle");
		circle.drawWithMessageSource();
	}
}
