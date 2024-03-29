package com.dagurasu.kafka.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dagurasu.kafka.service.User;
import com.dagurasu.kafka.service.UserProducerService;

@RestController
@RequestMapping("/userapi")
public class UserController {

	@Autowired
	private UserProducerService service;

	@PostMapping("/publishUserData/{name}/{age}")
	public void senUserData(@RequestBody User user) {
		service.sendUserData(user);
	}
}
