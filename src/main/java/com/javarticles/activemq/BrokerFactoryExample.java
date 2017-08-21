package com.javarticles.activemq;

public class BrokerFactoryExample {
    public static void main(String[] args) throws Exception {
        String brokerName = "myBroker";
        String brokerSchemeUrl = "broker://(tcp://localhost:61616)?brokerName="
                + brokerName;
        BrokerUtil.createBrokerSendReceiveMessage(brokerSchemeUrl, brokerName);
    }
}
