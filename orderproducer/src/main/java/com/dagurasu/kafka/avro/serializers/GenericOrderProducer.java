package com.dagurasu.kafka.avro.serializers;

import java.util.Properties;

import org.apache.avro.Schema;
import org.apache.avro.Schema.Parser;
import org.apache.avro.generic.GenericData;
import org.apache.avro.generic.GenericRecord;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import io.confluent.kafka.serializers.KafkaAvroSerializer;

public class GenericOrderProducer {

	public static void main(String[] args) {
		Properties props = new Properties();
		props.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
		props.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
		props.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, KafkaAvroSerializer.class.getName());
		props.setProperty("schema.registry.url", "http://localhost:8081");

		KafkaProducer<String, GenericRecord> producer = new KafkaProducer<String, GenericRecord>(props);
		Parser parser = new Schema.Parser();
		Schema schema = parser.parse("{" 
				+ "\"namespace\": \"com.dagurasu.kafka.avro\",\n" 
				+ "\"type\": \"record\",\n"
				+ "\"name\": \"Order\",\n" 
				+ "\"fields\": [\n" 
				+ "{\"name\": \"customerName\",\"type\": \"string\"},\n"
				+ "{\"name\": \"product\",\"type\": \"string\"},\n" 
				+ "{\"name\": \"quantity\",\"type\": \"int\"}\n" 
				+ "]\n"
				+ "}");

		GenericRecord order = new GenericData.Record(schema);
		order.put("customerName", "Théo");
		order.put("product", "Rog Phone");
		order.put("quantity", 255);

		ProducerRecord<String, GenericRecord> record = new ProducerRecord<>("OrderAvroGRTopic", order.get("customerName").toString(), order);

		try {
			producer.send(record);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			producer.close();
		}
	}
}
