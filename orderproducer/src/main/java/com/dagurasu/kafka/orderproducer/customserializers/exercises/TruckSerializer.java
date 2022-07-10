package com.dagurasu.kafka.orderproducer.customserializers.exercises;

import org.apache.kafka.common.serialization.Serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TruckSerializer implements Serializer<Truck> {

	@Override
	public byte[] serialize(String topic, Truck data) {
		byte[] response = null;
		ObjectMapper mapper = new ObjectMapper();

		try {
			response = mapper.writeValueAsString(data).getBytes();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return response;
	}
}
