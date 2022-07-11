package com.dagurasu.kafka.service;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.dagurasu.kafka.dto.User;

@Service
public class UserConsumerService {

	@KafkaListener(topics = { "user-topic" })
	public void consumerUserData(User user) {
		System.out.println("User Age Is: " + user.getAge() + " Fav Genre " + user.getFavGenre());
	}
}
