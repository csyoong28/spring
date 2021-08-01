 package com.soonyoong.youtube.AOP.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

public class LoggingAspectInXml {
	
	public Object myAroundAdvice(ProceedingJoinPoint proceedingJoinPoint) {
		Object returnObject = null;
		try {
			System.out.println("@Around is run before target method executed");
			returnObject = proceedingJoinPoint.proceed();
			System.out.println("@Around is run after target method executed");
		} catch (Throwable e) {
			System.out.println("@Around is throwing exception");
		}
		System.out.println("@Around is after finally");
		return returnObject;
	}

}
