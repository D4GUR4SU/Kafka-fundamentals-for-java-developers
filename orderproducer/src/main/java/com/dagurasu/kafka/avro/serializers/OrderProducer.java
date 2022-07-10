package com.dagurasu.kafka.avro.serializers;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import com.dagurasu.kafka.avro.Order;

import io.confluent.kafka.serializers.KafkaAvroSerializer;

public class OrderProducer {

	private static final String TOPIC_NAME = "OrderAvroTopic";

	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
		props.setProperty("schema.registry.url", "http://localhost:8081");

		KafkaProducer<String, Order> producer = new KafkaProducer<>(props);
		Order order = new Order("Douglas", "Iphone", 3);
		ProducerRecord<String, Order> record = new ProducerRecord<>(TOPIC_NAME, order.getCustomerName().toString(), order);

		try {
			producer.send(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}
	}
}