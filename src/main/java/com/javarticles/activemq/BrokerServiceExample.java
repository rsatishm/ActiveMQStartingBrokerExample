package com.javarticles.activemq;

import org.apache.activemq.broker.BrokerService;

public class BrokerServiceExample {
    public static void main(String[] args) throws Exception {
        String brokerName = "myBroker";
        BrokerService brokerService = new BrokerService();
        brokerService.setBrokerName(brokerName);
        brokerService.addConnector("tcp://localhost:61616");
        BrokerUtil.startBrokerSendReceiveMessage(brokerService);
    }
}
