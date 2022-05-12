package com.logicbig.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

@Component
public class OrderItemClientBean {

    @Autowired
    private PlatformTransactionManager transactionManager;
    @Autowired
    private Dao<OrderItem> dao;

    public void persistOrderItems() {
        TransactionStatus ts =
                transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            long id = dao.save(new OrderItem("BWell Ethernet Cable", 5));
            System.out.println("id generated: "+id);
            id = dao.save(new OrderItem("EDrive SSD", 2000));
            System.out.println("id generated: "+id);
            transactionManager.commit(ts);
        } catch (Exception e) {
                transactionManager.rollback(ts);
                System.out.println("-- exception message --");
                System.err.println(e.getMessage());
                System.out.println("---------");
        }
        System.out.println("loaded items: " + dao.loadAll());

        System.out.println("-- second attempt --");
        //new transaction boundary
        ts = transactionManager.getTransaction(new DefaultTransactionDefinition());
        try {
            long id = dao.save(new OrderItem("BWell Ethernet Cable", 5));
            System.out.println("id generated: "+id);
            id = dao.save(new OrderItem("EDrive SSD", 20));
            System.out.println("id generated: "+id);
            transactionManager.commit(ts);
        } catch (Exception e) {
            transactionManager.rollback(ts);
            System.out.println("-- exception message --");
            System.err.println(e.getMessage());
            System.out.println("---------");
        }
        System.out.println("loaded items: " + dao.loadAll());
    }
}