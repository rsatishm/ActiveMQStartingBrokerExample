package com.javarticles.activemq;

import org.apache.activemq.broker.BrokerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomBrokerFactoryBeanExample {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "customBrokerFactoryBean.xml");
        BrokerService broker = (BrokerService) context.getBean("brokerViaFactory");
        try {
            System.out.println("Started? " + broker.isStarted());
        } finally {
            broker.stop();
            context.close();
        }
    }

}
