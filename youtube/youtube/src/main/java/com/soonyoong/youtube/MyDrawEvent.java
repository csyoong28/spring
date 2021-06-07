package com.soonyoong.youtube;

import org.springframework.context.ApplicationEvent;

public class MyDrawEvent extends ApplicationEvent{

	public MyDrawEvent(Object source) {
		super(source);		
	}

	@Override
	public String toString() {
		return "MyDrawEvent occurred";
	}	
	
}
