package com.soonyoong.youtube;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class T6BeanPostProcessor implements BeanPostProcessor{
	//both need to return the object back, so that spring can continue on it
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor before init, beanName: " + beanName);
		return bean;
	}

	public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
		System.out.println("BeanPostProcessor after init, beanName: " + beanName);
		return bean;
	}

}
