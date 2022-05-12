package com.soonyoong.transaction.management;

import java.util.Arrays;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionSynchronizationManager;

public class CustomerManagerImpl implements CustomerManager, ApplicationContextAware {

    private CustomerDAO customerDAO;
    private ApplicationContext applicationContext;

    public void setCustomerDAO(CustomerDAO customerDAO) {
        this.customerDAO = customerDAO;
    }

    //@Override
    @Transactional
    public void createCustomer(Customer cust) {
        boolean active = TransactionSynchronizationManager.isActualTransactionActive();
        System.out.println(active);
        customerDAO.create(cust);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext= applicationContext;
        
    }
    @Override
    public void getBeanDefinitionNames() {
        String[] beanNames = applicationContext.getBeanDefinitionNames();

        for (String beanName : beanNames) {

            System.out.println(beanName + " : " + applicationContext.getBean(beanName).getClass().toString());
        }
        //System.out.println(Arrays.asList(applicationContext.getBeanDefinitionNames()));
    }

}
