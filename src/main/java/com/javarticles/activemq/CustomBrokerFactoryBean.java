package com.javarticles.activemq;

import org.apache.activemq.broker.BrokerService;
import org.apache.activemq.xbean.BrokerFactoryBean;

public class CustomBrokerFactoryBean extends BrokerFactoryBean {
    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        System.out.println("CustomBrokerFactoryBean.afterPropertiesSet called");
    }
    
    public void init() throws Exception {
        System.out.println("CustomBrokerFactoryBean.init called");
        BrokerService broker = this.getBroker();
        setStart(true);
        broker.start();
        System.out.println("Broker started");
    }
}
