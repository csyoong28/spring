package com.soonyoong.youtube;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;

public class Circle implements Shape, ApplicationEventPublisherAware {
	private Point center;
	private Point pointA;
	@Autowired
	private MessageSource messageSource;
	
	private ApplicationEventPublisher applicationEventPublisher;
	
	public void draw() {
		MyDrawEvent myDrawEvent = new MyDrawEvent(this);
		applicationEventPublisher.publishEvent(myDrawEvent);
		System.out.println("Circle [center=" + center.getX() + "," + center.getY() + ",pointA:" + pointA.getX() + "," + pointA.getY() + "]");
	}
	
	public void drawWithMessageSource() {
		System.out.println(messageSource.getMessage("drawing.point", new Object[] {center.getX(), center.getY()}, "Default drawing", null));
	}

	public Point getCenter() {
		return center;
	}
	@Required
	@Autowired
	@Qualifier("circleRelated")
	public void setCenter(Point center) {
		this.center = center;
	}

	public Point getPointA() {
		return pointA;
	}
	
	@Resource(name="pointC")
	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}
	
	@PostConstruct
	public void myInitCircle() {
		System.out.println("myInitCircle run");
	}
	@PreDestroy
	public void myDestroyCircle() {
		System.out.println("myDestroyCircle run");
	}

	public MessageSource getMessageSource() {
		return messageSource;
	}
	
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.applicationEventPublisher = applicationEventPublisher;
		
	}

	public ApplicationEventPublisher getApplicationEventPublisher() {
		return applicationEventPublisher;
	}


}
