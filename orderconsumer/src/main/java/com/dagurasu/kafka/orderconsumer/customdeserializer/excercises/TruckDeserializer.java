package com.dagurasu.kafka.orderconsumer.customdeserializer.excercises;

import java.io.IOException;

import org.apache.kafka.common.serialization.Deserializer;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TruckDeserializer implements Deserializer<Truck> {

	@Override
	public Truck deserialize(String topic, byte[] data) {
		ObjectMapper mapper = new ObjectMapper();

		Truck truck = null;
		try {
			truck = mapper.readValue(data, Truck.class);
		} catch (StreamReadException e) {
			e.printStackTrace();
		} catch (DatabindException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return truck;
	}
}
