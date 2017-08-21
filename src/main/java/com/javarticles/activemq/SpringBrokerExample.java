package com.javarticles.activemq;

import org.apache.activemq.broker.BrokerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringBrokerExample {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "spring_broker.xml");
        BrokerService broker = (BrokerService) context.getBean("myBroker");
        try {
            System.out.println("Started? " + broker.isStarted());
        } finally {
            broker.stop();
            context.close();
        }
    }

}
