package com.test.hackerrank;

import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
//import javax.jms.JMSContext;
import javax.jms.JMSException;
import javax.jms.Session;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;


public class KafkaJmsConnectionFactory implements ConnectionFactory {
	
	private static final String DEFAULT_AUTO_COMMIT_INTERVAL = "10000";
	private static final String DEFAULT_ASSIGNMENT_STRATEGY = "range";
	private static final String DEFAULT_AUTO_COMMIT = "false";
	private static final String DEFAULT_TIMOUT = "1000";
	private static String DEFAULT_BROKER = "localhost:9092";
	private static String DEFAULT_VALUE_SERIALIZER = StringSerializer.class.getName();
	private static String DEFAULT_KEY_SERIALIZER = StringSerializer.class.getName();
	private static String DEFAULT_KEY_DESERIALIZER = StringDeserializer.class.getName();
	private KafkaConfigBuilder builder = new KafkaConfigBuilder();
	Session session = null;
	
	/**
	 * @return the builder
	 */
	public KafkaConfigBuilder getBuilder() {
		return builder;
	}

	private Properties config;

	@PostConstruct
	public void initializeConfig() {
		builder.broker(DEFAULT_BROKER).valueSerializerClass(DEFAULT_VALUE_SERIALIZER)
			.keySerializerClass(DEFAULT_KEY_SERIALIZER).enableAuutoCommit(DEFAULT_AUTO_COMMIT)
			.autoCommitInterval(DEFAULT_AUTO_COMMIT_INTERVAL).keyDeserializerClass(DEFAULT_KEY_DESERIALIZER);
	}
	
	public void setGroupId(String value){
		builder.groupId(value);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.ConnectionFactory#createConnection()
	 */
	@Override
	public Connection createConnection() throws JMSException {
		initializeConfig();
		builder.broker(DEFAULT_BROKER).valueSerializerClass(DEFAULT_VALUE_SERIALIZER)
		.keySerializerClass(DEFAULT_KEY_SERIALIZER).enableAuutoCommit(DEFAULT_AUTO_COMMIT)
		.autoCommitInterval(DEFAULT_AUTO_COMMIT_INTERVAL).keyDeserializerClass(DEFAULT_KEY_DESERIALIZER);
		config = builder.build();
		return new KafkaJmsConnection(config);
	}
	public Session createSession(){
		KafkaJmsConnection kc=new KafkaJmsConnection(config);
		
		try {
			session= kc.createSession() ;
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.ConnectionFactory#createConnection(java.lang.String,
	 * java.lang.String)
	 */
	@Override
	public Connection createConnection(String userName, String password)
			throws JMSException {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.ConnectionFactory#createContext()
	 
	@Override
	public JMSContext createContext() {
		// TODO Auto-generated method stub
		return null;
	}

	
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.ConnectionFactory#createContext(java.lang.String,
	 * java.lang.String)
	 
	@Override
	public JMSContext createContext(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}

	
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.ConnectionFactory#createContext(java.lang.String,
	 * java.lang.String, int)
	 
	@Override
	public JMSContext createContext(String userName, String password,
			int sessionMode) {
		// TODO Auto-generated method stub
		return null;
	}

	
	 * (non-Javadoc)
	 * 
	 * @see javax.jms.ConnectionFactory#createContext(int)
	 
	@Override
	public JMSContext createContext(int sessionMode) {
		// TODO Auto-generated method stub
		return null;
	}*/

}
