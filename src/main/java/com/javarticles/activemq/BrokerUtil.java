package com.javarticles.activemq;

import javax.jms.Connection;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.broker.BrokerFactory;
import org.apache.activemq.broker.BrokerRegistry;
import org.apache.activemq.broker.BrokerService;

public class BrokerUtil {
    public static void createBrokerSendReceiveMessage(String brokerSchemeUrl,
            String brokerName) throws Exception {
        BrokerService brokerService = BrokerFactory
                .createBroker(brokerSchemeUrl);
        startBrokerSendReceiveMessage(brokerService);        
    }
    
    public static void startBrokerSendReceiveMessage(BrokerService brokerService) throws Exception {
        brokerService.start();
        String brokerName = brokerService.getBrokerName();
        System.out.println("Broker " + brokerName
                + " started? " + brokerService.isStarted());

        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                "vm://" + brokerService.getBrokerName() + "?create=false");
        Connection connection = connectionFactory.createConnection();
        connection.start();

        Session session = connection.createSession(false,
                Session.AUTO_ACKNOWLEDGE);
        try {
            Queue destination = session.createQueue("Q");
            MessageProducer producer = session.createProducer(destination);
            Message message = session.createTextMessage("Hi!");
            producer.send(message);
            MessageConsumer consumer = session.createConsumer(destination);
            System.out.println("Message received "
                    + ((TextMessage) consumer.receive()).getText());
        } finally {
            session.close();
            connection.close();
            BrokerRegistry.getInstance().lookup(brokerName).stop();
        }
    }
}
