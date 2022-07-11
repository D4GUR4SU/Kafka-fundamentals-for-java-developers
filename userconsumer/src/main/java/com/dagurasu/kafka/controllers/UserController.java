package com.dagurasu.kafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dagurasu.kafka.dto.User;
import com.dagurasu.kafka.service.UserConsumerService;

@RestController
@RequestMapping("/userapi")
public class UserController {

	@Autowired
	private UserConsumerService service;

	@PostMapping("/publishUserData/{name}/{age")
	public void senUserData(@RequestBody User user) {
		service.consumerUserData(user);
	}
}
