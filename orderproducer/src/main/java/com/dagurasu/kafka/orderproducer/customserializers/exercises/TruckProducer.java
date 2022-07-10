package com.dagurasu.kafka.orderproducer.customserializers.exercises;

import java.util.Properties;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

public class TruckProducer {

	private static final String TOPIC_NAME = "TruckTopic";

	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, "org.apache.kafka.common.serialization.IntegerSerializer");
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, "com.dagurasu.kafka.orderproducer.customserializers.exercises.TruckSerializer");

		KafkaProducer<Integer, Truck> producer = new KafkaProducer<Integer, Truck>(props);
		Truck truck = new Truck();
		truck.setID(1);
		truck.setLatitude(-1826267.0F);
		truck.setLongitude(16756267.0F);
		
		ProducerRecord<Integer, Truck> record = new ProducerRecord<>(TOPIC_NAME, truck.getID(), truck);

		try {
			producer.send(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}
	}
}
