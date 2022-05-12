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

@Aspect		//this annotation turn this class into an Aspect
public class LoggingAspect {
	
	
	//can uncomment to test those jointcut
	//@Before(value = "execution(* get*())")
	public void LoggingAdvice() {
		System.out.println("Advice run. Get Method Called");
	}
	
	//with joinPoint
	//@Before(value = "allCircleMethods()")
	public void LoggingAdvice(JoinPoint joinPoint) {
		System.out.println("Advice run. joinPoint:" + joinPoint.toString());
		//can get a handle to the object that trigger the advice, if want can do something on that object
		System.out.println("Advice run. the object that trigger this advice:" + joinPoint.getTarget());
	}
	
	//@Before("args(String)")
	public void stringArgumentMethods() {
		System.out.println("method that takes string args has been called");
	}
	
	//can get the argument value too, name is string as defined in method
	//@Before("args(name)")
	public void stringArgumentMethods(String name) {
		System.out.println("method that takes string args has been called, name:" + name);
	}
	
	
	//@Before("allGetters()")	//just tell the method name that has the pointcut
	public void SecondAdvice() {
		System.out.println("Second Advice run.");
	}
	
	//using @After
	//@AfterReturning(pointcut="args(name)", returning="returnString")
	public void stringAfterArgumentMethods(String name, String returnString) {
		System.out.println("@After method that takes string args has been called, name:" + name + ", return object:" + returnString);
	}
	
	//@AfterThrowing(pointcut="args(name)", throwing="ex")
	public void stringAfterThrowingArgumentMethods(String name, RuntimeException ex) {
		System.out.println("@AfterThrowing method that takes string args has been called, name:" + name);
	}
	
	//@Around(value = "allGetters()")
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
	
	//@Around(value = "@annotation(com.soonyoong.youtube.AOP.aspect.Loggable)")
	public Object myAroundAdvice2(ProceedingJoinPoint proceedingJoinPoint) {
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
	
	//define a point cut, hold by the method name. the method is just dummy
	@Pointcut("execution(* get*())")
	public void allGetters() {}
	
	@Pointcut("within(com.soonyoong.youtube.AOP.Circle)")
	public void allCircleMethods() {}
	
	@Pointcut("execution(* com.soonyoong.youtube.AOP.Triangle.setName2(*))")
    public void setName2() {}
	
	@Pointcut("execution(* com.soonyoong.youtube.AOP.Triangle.setName3(*))")
    public void setName3() {}
	
	@After("setName2() || setName3()")  //just tell the method name that has the pointcut
    public void triangleSetName2And3Advice() {
        System.out.println("triangleSetName2And3Advice run.");
    }
}
