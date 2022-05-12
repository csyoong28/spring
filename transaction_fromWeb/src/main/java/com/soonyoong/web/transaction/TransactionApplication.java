package com.soonyoong.web.transaction;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class TransactionApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionApplication.class, args);
	}
	
	//@PostConstruct   //this is to run after all init done, uncomment it when want to run this
    public void start() {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);
        OrderItemClientBean orderItemClientBean = context.getBean(OrderItemClientBean.class);
        orderItemClientBean.persistOrderItems();
    }

}
