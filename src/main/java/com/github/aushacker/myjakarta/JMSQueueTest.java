package com.github.aushacker.myjakarta;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.DeliveryMode;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;

public class JMSQueueTest {

	public static void main(String[] args) throws Exception {
        Context context = new InitialContext(); 

        ConnectionFactory factory = (ConnectionFactory) context.lookup("amqFactory");
        Destination destination = (Destination) context.lookup("TestQueue"); 

        // No auth required if AMQ is configured as anonymous
        Connection connection = factory.createConnection("", "");
        connection.start(); 

        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE); 

        MessageProducer messageProducer = session.createProducer(destination); 

        TextMessage message = session.createTextMessage("Hello world!"); 
        messageProducer.send(message, DeliveryMode.NON_PERSISTENT,
                         Message.DEFAULT_PRIORITY, Message.DEFAULT_TIME_TO_LIVE); 

        connection.close(); 
	}
}
