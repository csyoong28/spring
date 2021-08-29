package io.javabrains.springbootquickstart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication	//this annotation tells this is the starting point
class T01_CourseApiApp {
	public static void main(String[] args) throws Exception {
		//this is enough to create spring boot app, to have servlet container and run it
		SpringApplication.run(T01_CourseApiApp.class, args);
	}
}
