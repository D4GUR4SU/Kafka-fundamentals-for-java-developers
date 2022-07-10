package com.dagurasu.kafka.avro.deserializers;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import io.confluent.kafka.serializers.KafkaAvroDeserializer;

public class GenericOrderConsumer {

	private static final String TOPIC_NAME = "OrderAvroGRTopic";

	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
		props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, KafkaAvroDeserializer.class.getName());
		props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "OrderGroup");
		props.setProperty("schema.registry.url", "http://localhost:8081");

		KafkaConsumer<String, GenericRecord> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Collections.singletonList(TOPIC_NAME));

		ConsumerRecords<String, GenericRecord> records = consumer.poll(Duration.ofSeconds(20));
		for (ConsumerRecord<String, GenericRecord> record : records) {
			String customerName = record.key();
			GenericRecord order = record.value();
			System.out.println("Customer Name: " + customerName);
			System.out.println("Product: " + order.get("product"));
			System.out.println("Quantity: " + order.get("quantity"));
		}
		consumer.close();
	}
}
