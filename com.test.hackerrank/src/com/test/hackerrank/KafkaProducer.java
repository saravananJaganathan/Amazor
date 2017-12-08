package com.test.hackerrank;

import java.util.Properties;

import javax.jms.JMSException;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.json.simple.JSONObject;

import kafka.admin.AdminUtils;
import kafka.admin.RackAwareMode;
import kafka.utils.ZkUtils;

public class KafkaProducer {

	private static Session session;
	static org.apache.kafka.clients.producer.Producer<String, String> kafkaProducer = null;
	private static String DEFAULT_VALUE_SERIALIZER = StringSerializer.class.getName();
   	private static String DEFAULT_KEY_SERIALIZER = StringSerializer.class.getName();
   	
   	public void init(JSONObject json){
   		KafkaJmsConnectionFactory kafkaConnectionFactory = new KafkaJmsConnectionFactory();
		Properties configProperties = new Properties();
		try
		{
			KafkaJmsConnection kafkaConnection = (KafkaJmsConnection) kafkaConnectionFactory.createConnection();
			session = kafkaConnection.createSession();
			configProperties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, DEFAULT_KEY_SERIALIZER);
			configProperties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, DEFAULT_VALUE_SERIALIZER);
			kafkaProducer = (Producer<String, String>) new KafkaProducer();
			createKafaTopic("Test");
			sendmessage(json);
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
   	}
	
	

	private void sendmessage(JSONObject json) {
		try {
			TextMessage jmsRequest1=(TextMessage) session.createObjectMessage(json);
			ProducerRecord<String, String> input = new ProducerRecord<String, String>("Test",json.toJSONString());
			kafkaProducer.send(input);
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	public static void createKafaTopic(String destination) {
		ZkClient zkClient = new ZkClient("localhost:2181", 10000, 10000, null);
		ZkUtils zkutils = new ZkUtils(zkClient, new ZkConnection("locahost:2181"), false);
		int noOfPartitions = 2;
		int noOfReplication = noOfPartitions;
		Properties topicConfiguration = new Properties();
		if(!AdminUtils.topicExists(zkutils, destination)){
		AdminUtils.createTopic(zkutils, destination, noOfPartitions, noOfReplication, topicConfiguration,
				RackAwareMode.Safe$.MODULE$);
		System.out.println("Kafka topic created successfully with the destination:"+destination);
		}
		else{
		System.out.println("Kafka topic is not created for the destination:"+destination+".It is already exists");
		}
	}
}
