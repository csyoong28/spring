package com.soonyoong.youtube.AOP;

//this is to create a fake bean factory 
public class FactoryService {
	
	public Object getBean(String beanType) {
		if (beanType.equals("shapeService")) {
			return new ShapeServiceProxy();		//should return proxy
		} else if (beanType.equals("circle")) {
			return new Circle();
		} else if (beanType.equals("triangle")) {
			return new Triangle();
		} else {
			return null;
		}
	}
}
