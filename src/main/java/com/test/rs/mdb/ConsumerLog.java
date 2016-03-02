package com.test.rs.mdb;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.*;


@MessageDriven(mappedName = "java:/jms/queue/ExpiryQueue", activationConfig = {
    @ActivationConfigProperty(propertyName="destination", propertyValue="java:/jms/queue/ExpiryQueue")
    })
public class ConsumerLog implements MessageListener{

    @Override
    public void onMessage(Message msg) {
        File file = new File(Paths.get("").toAbsolutePath().toString() + "/my_log.txt");
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(ConsumerLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
            }
        }

        try {
            PrintWriter prWr = new PrintWriter(new BufferedWriter(new FileWriter(file, true)));
            try {
                prWr.println(msg.getBody(String.class));
            } catch (JMSException ex) {
                Logger.getLogger(ConsumerLog.class.getName()).log(Level.SEVERE, null, ex);
            }
            prWr.close();
        } catch (IOException ex) {
            Logger.getLogger(ConsumerLog.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
    }  
}
