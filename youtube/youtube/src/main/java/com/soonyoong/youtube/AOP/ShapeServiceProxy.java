package com.soonyoong.youtube.AOP;

import com.soonyoong.youtube.AOP.aspect.Loggable;
import com.soonyoong.youtube.AOP.aspect.LoggingAspectProxyConcept;

public class ShapeServiceProxy extends ShapeService{
	//having the proxy, can add code before and after the intended code
	public Circle getCircle() {
		new LoggingAspectProxyConcept().loggingAdvice();
		return super.getCircle();
		
	}
}
