package com.soonyoong.transaction.management;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class T01_TransactionManagerMain {
    
    
    
    public static void main(String[] args) {
        T01_TransactionManagerMain t01_TransactionManagerMain = new T01_TransactionManagerMain();
        t01_TransactionManagerMain.case1();
    }

    public void case1() {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring07TransactionManagement.xml");
        
        CustomerManager customerManager = ctx.getBean("customerManager", CustomerManagerImpl.class);
        customerManager.getBeanDefinitionNames();
        Customer cust = createDummyCustomer();
        boolean active = TransactionSynchronizationManager.isActualTransactionActive();

        customerManager.createCustomer(cust);

        ctx.close();
    }

    private static Customer createDummyCustomer() {
        Customer customer = new Customer();
        customer.setId(2);
        customer.setName("Pankaj");
        Address address = new Address();
        address.setId(2);
        address.setCountry("India");
        // setting value more than 20 chars, so that SQLException occurs
        address.setAddress("aaa");
        //address.setAddress("Albany Dr, San Jose, CA 95129");
        customer.setAddress(address);
        return customer;
    }


}
