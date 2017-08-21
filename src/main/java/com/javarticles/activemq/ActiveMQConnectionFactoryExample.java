package com.javarticles.activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerRegistry;
import org.apache.activemq.broker.BrokerService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ActiveMQConnectionFactoryExample {
    public static void main(String[] args) throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "connectionFactory.xml");
        ActiveMQConnectionFactory connectionFactory = (ActiveMQConnectionFactory) context.getBean("localFactory");
        ActiveMQConnection connection = (ActiveMQConnection) connectionFactory.createConnection();
        connection.start();
        BrokerService broker = BrokerRegistry.getInstance().lookup("myBroker");
        try {
            System.out.println("Started? " + broker.isStarted());
        } finally {
            broker.stop();
            context.close();
        }
    }

}
