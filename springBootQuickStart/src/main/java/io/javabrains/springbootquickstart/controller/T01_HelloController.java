package io.javabrains.springbootquickstart.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController		//make this as REST controller
public class T01_HelloController {
	
	@RequestMapping("/hello")
	public String sayHi() {
		return "Hi";
	}
}
