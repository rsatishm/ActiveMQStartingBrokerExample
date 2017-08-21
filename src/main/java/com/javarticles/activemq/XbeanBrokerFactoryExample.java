package com.javarticles.activemq;

public class XbeanBrokerFactoryExample {
    public static void main(String[] args) throws Exception {
        String brokerName = "myBroker";
        String brokerSchemeUrl = "xbean:broker.xml";
        BrokerUtil.createBrokerSendReceiveMessage(brokerSchemeUrl, brokerName);
    }
}
