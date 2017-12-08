package com.test.hackerrank;

import java.io.Serializable;

import javax.jms.Destination;
import javax.jms.JMSException;

public interface KafkaDestination extends Destination,Serializable {
	String getName() throws JMSException; 
}