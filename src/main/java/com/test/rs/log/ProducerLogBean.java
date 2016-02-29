package com.test.rs.log;

import javax.annotation.Resource;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.jms.*;

@Stateless
@LocalBean
public class ProducerLogBean {
    
    @Inject
    @JMSConnectionFactory("java:/ConnectionFactory")
    private JMSContext context;
    
    @Resource(lookup = "java:/jms/queue/ExpiryQueue")
    private Queue queue;
    
    public void sendMessage(String message){
        context.createProducer().send(queue, message);
    }
}
