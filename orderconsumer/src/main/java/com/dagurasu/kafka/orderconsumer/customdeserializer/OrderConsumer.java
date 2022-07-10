package com.dagurasu.kafka.orderconsumer.customdeserializer;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.StringDeserializer;

public class OrderConsumer {

	private static final String TOPIC_NAME = "OrderCSTopic";

	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class.getName());
		props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, OrderDeserializer.class.getName());
		props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "OrderGroup");

		KafkaConsumer<String, Order> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Collections.singletonList(TOPIC_NAME));

		try {
			while (true) {
				ConsumerRecords<String, Order> records = consumer.poll(Duration.ofSeconds(20));
				for (ConsumerRecord<String, Order> record : records) {
					String customerName = record.key();
					Order order = record.value();
					System.out.println("Customer Name: " + customerName);
					System.out.println("Product: " + order.getProduct());
					System.out.println("Quantity: " + order.getQuantity());
				}
			}
		} finally {
			consumer.close();
		}
	}
}
