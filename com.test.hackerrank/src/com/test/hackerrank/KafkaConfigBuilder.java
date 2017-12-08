package com.test.hackerrank;

import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;

public class KafkaConfigBuilder {
	
	private Properties config = new Properties();

	public Properties build() {
		return config;
	}

	/**
	 * @return the brokerList
	 */
	public String getBroker() {
		return (String) config.get(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG);
	}

	/**
	 * @param brokerList
	 *            the brokerList to set
	 */
	public KafkaConfigBuilder broker(String broker) {
		config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, broker);
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, broker);
		return this;
	}

	/**
	 * @return the serializerClass
	 */
	public String getValueSerializerClass() {
		return (String) config
				.get(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG);
	}

	/**
	 * @param serializerClass
	 *            the serializerClass to set
	 */
	public KafkaConfigBuilder valueSerializerClass(String valueSerializerClass) {
		config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
				valueSerializerClass);
		config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, valueSerializerClass);
		return this;
	}

	/**
	 * @return the keySerializerClass
	 */
	public String getKeySerializerClass() {
		return (String) config.get(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG);
	}

	/**
	 * @param keySerializerClass
	 *            the keySerializerClass to set
	 */
	public KafkaConfigBuilder keySerializerClass(String keySerializerClass) {
		config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
				keySerializerClass);
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keySerializerClass);
		return this;
	}
	
	public KafkaConfigBuilder keyDeserializerClass(String keyDeserializerClass) {
		config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, keyDeserializerClass);
		return this;
	}

	public String getAckConfig() {
		return (String) config.get(ProducerConfig.ACKS_CONFIG);
	}

	public KafkaConfigBuilder ackConfig(String acks) {
		config.put(ProducerConfig.ACKS_CONFIG, acks);
		return this;
	}

	public KafkaConfigBuilder batchSize(String value) {
		config.put(ProducerConfig.BATCH_SIZE_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder blockOnBufferFull(String value) {
		config.put(ProducerConfig.BLOCK_ON_BUFFER_FULL_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder bufferMemory(String value) {
		config.put(ProducerConfig.BUFFER_MEMORY_CONFIG, value);
		//config.put(ConsumerConfig.TOTAL_BUFFER_MEMORY_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder clientId(String value) {
		config.put(ProducerConfig.CLIENT_ID_CONFIG, value);
		config.put(ConsumerConfig.CLIENT_ID_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder compressionType(String value) {
		config.put(ProducerConfig.COMPRESSION_TYPE_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder lingerMilli(String value) {
		config.put(ProducerConfig.LINGER_MS_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder maxInflightRequests(String value) {
		config.put(ProducerConfig.MAX_IN_FLIGHT_REQUESTS_PER_CONNECTION, value);
		return this;
	}

	public KafkaConfigBuilder maxRequestSize(String value) {
		config.put(ProducerConfig.MAX_REQUEST_SIZE_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder metaDataFetchTimeout(String value) {
		config.put(ProducerConfig.METADATA_FETCH_TIMEOUT_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder meteaDataMaxAge(String value) {
		config.put(ProducerConfig.METADATA_MAX_AGE_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder metricReporterClasses(String value) {
		config.put(ProducerConfig.METRIC_REPORTER_CLASSES_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder recieveBuffer(String value) {
		config.put(ProducerConfig.RECEIVE_BUFFER_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder reconnectBackoffMilli(String value) {
		config.put(ProducerConfig.RECONNECT_BACKOFF_MS_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder retrieCount(String value) {
		config.put(ProducerConfig.RETRIES_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder retryBackoffMillis(String value) {
		config.put(ProducerConfig.RETRY_BACKOFF_MS_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder sendBuffer(String value) {
		config.put(ProducerConfig.SEND_BUFFER_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder timout(String value) {
		config.put(ProducerConfig.TIMEOUT_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder autoCommitInterval(String value) {
		config.put(ConsumerConfig.AUTO_COMMIT_INTERVAL_MS_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder autoOffsetReset(String value) {
		config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder bootstrapServer(String value) {
		config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder enableAuutoCommit(String value) {
		config.put(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, value);
		return this;
	}

//	public KafkaConfigBuilder fetchBuffer(String value) {
//		config.put(ConsumerConfig.FETCH_BUFFER_CONFIG, value);
//		return this;
//	}

	public KafkaConfigBuilder fetchMaxWait(String value) {
		config.put(ConsumerConfig.FETCH_MAX_WAIT_MS_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder fetchMinBytes(String value) {
		config.put(ConsumerConfig.FETCH_MIN_BYTES_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder groupId(String value) {
		config.put(ConsumerConfig.GROUP_ID_CONFIG, value);
		return this;
	}

//	public KafkaConfigBuilder heartbeatFrequency(String value) {
//		config.put(ConsumerConfig.HEARTBEAT_FREQUENCY, value);
//		return this;
//	}
//
//	public KafkaConfigBuilder metadataFetchTimeout(String value) {
//		config.put(ConsumerConfig.METADATA_FETCH_TIMEOUT_CONFIG, value);
//		return this;
//	}

	public KafkaConfigBuilder metricReporterClass(String value) {
		config.put(ConsumerConfig.METRIC_REPORTER_CLASSES_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder metricNumSamples(String value) {
		config.put(ConsumerConfig.METRICS_NUM_SAMPLES_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder metricSampleWindo(String value) {
		config.put(ConsumerConfig.METRICS_SAMPLE_WINDOW_MS_CONFIG, value);
		return this;
	}

	public KafkaConfigBuilder reconnectBackoffMillis(String value) {
		config.put(ConsumerConfig.RECONNECT_BACKOFF_MS_CONFIG, value);
		return this;
	}

//	public KafkaConfigBuilder sessionTimeout(String value) {
//		config.put(ConsumerConfig.SESSION_TIMEOUT_MS, value);
//		return this;
//	}
//
//	public KafkaConfigBuilder socketReceiveBuffer(String value) {
//		config.put(ConsumerConfig.SOCKET_RECEIVE_BUFFER_CONFIG, value);
//		return this;
//	}
//	
//	public KafkaConfigBuilder partitionAssignmentStrategy(String value) {
//		config.put(ConsumerConfig.PARTITION_ASSIGNMENT_STRATEGY,value);
//		return this;
//	}

}
