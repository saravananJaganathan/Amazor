package com.test.hackerrank;

import java.io.Serializable;
import java.util.Properties;

import javax.jms.BytesMessage;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.MessageProducer;
import javax.jms.ObjectMessage;
import javax.jms.Queue;
import javax.jms.QueueBrowser;
import javax.jms.Session;
import javax.jms.StreamMessage;
import javax.jms.TemporaryQueue;
import javax.jms.TemporaryTopic;
import javax.jms.TextMessage;
import javax.jms.Topic;
import javax.jms.TopicSubscriber;



public class KafkaJmsSession implements Session{
	
	private Properties config;
	//private KafkaMessageProducer producer;

	public KafkaJmsSession(Properties config){
		this.config = config;
	}
	
	public TextMessage createTextMessage(String text) throws JMSException {
		KafkaTextMessage msg = new KafkaTextMessage();
		msg.setText(text);
		return msg;
	}
	
	@Override
	public void close() throws JMSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void commit() throws JMSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public QueueBrowser createBrowser(Queue arg0) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public QueueBrowser createBrowser(Queue arg0, String arg1) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public BytesMessage createBytesMessage() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageConsumer createConsumer(Destination arg0) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageConsumer createConsumer(Destination arg0, String arg1) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageConsumer createConsumer(Destination arg0, String arg1, boolean arg2) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public MessageConsumer createDurableConsumer(Topic arg0, String arg1) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageConsumer createDurableConsumer(Topic arg0, String arg1, String arg2, boolean arg3)
			throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public TopicSubscriber createDurableSubscriber(Topic arg0, String arg1) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TopicSubscriber createDurableSubscriber(Topic arg0, String arg1, String arg2, boolean arg3)
			throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MapMessage createMapMessage() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Message createMessage() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectMessage createObjectMessage() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ObjectMessage createObjectMessage(Serializable arg0) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}
/*
	@Override
	public MessageProducer createProducer(Destination destination) throws JMSException {
		producer = new KafkaMessageProducer(config,destination);
		return producer;
	}
	*/
	

	@Override
	public Queue createQueue(String arg0) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/*@Override
	public MessageConsumer createSharedConsumer(Topic arg0, String arg1) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageConsumer createSharedConsumer(Topic arg0, String arg1, String arg2) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageConsumer createSharedDurableConsumer(Topic arg0, String arg1) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MessageConsumer createSharedDurableConsumer(Topic arg0, String arg1, String arg2) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}*/

	@Override
	public StreamMessage createStreamMessage() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TemporaryQueue createTemporaryQueue() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TemporaryTopic createTemporaryTopic() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TextMessage createTextMessage() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Topic createTopic(String arg0) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getAcknowledgeMode() throws JMSException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public MessageListener getMessageListener() throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean getTransacted() throws JMSException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void recover() throws JMSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rollback() throws JMSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setMessageListener(MessageListener arg0) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unsubscribe(String arg0) throws JMSException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MessageProducer createProducer(Destination arg0) throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}
}
