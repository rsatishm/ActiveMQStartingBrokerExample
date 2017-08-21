package com.javarticles.activemq;

public class PropertiesBrokerFactoryExample {
    public static void main(String[] args) throws Exception {
        String brokerName = "myBroker";
        String brokerSchemeUrl = "properties:broker.properties";
        BrokerUtil.createBrokerSendReceiveMessage(brokerSchemeUrl, brokerName);
    }
}
