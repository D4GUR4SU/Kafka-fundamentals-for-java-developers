package com.dagurasu.kafka.orderconsumer.customdeserializer.excercises;

import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.serialization.IntegerDeserializer;

public class TruckConsumer {

	private static final String TOPIC_NAME = "TruckTopic";

	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, IntegerDeserializer.class.getName());
		props.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, TruckDeserializer.class.getName());
		props.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "TruckTrackGroup");

		KafkaConsumer<Integer, Truck> consumer = new KafkaConsumer<>(props);
		consumer.subscribe(Collections.singletonList(TOPIC_NAME));

		ConsumerRecords<Integer, Truck> truckrecords = consumer.poll(Duration.ofSeconds(40));
		for (ConsumerRecord<Integer, Truck> consumerRecord : truckrecords) {
			int id = consumerRecord.key();
			Truck value = consumerRecord.value();
			System.out.println("Truck ID => " + id);
			System.out.println("Truck Latitude => " + value.getLatitude());
			System.out.println("Truck Longitude => " + value.getLongitude());
		}
		consumer.close();
	}
}
