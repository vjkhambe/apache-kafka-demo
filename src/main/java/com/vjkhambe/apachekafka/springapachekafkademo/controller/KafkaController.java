package com.vjkhambe.apachekafka.springapachekafkademo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.kafka.core.KafkaTemplate;

@RestController
public class KafkaController
{

	@Autowired
	private KafkaTemplate<String,String> kafkaTemplate;

	private static final String TOPIC_NAME = "kafka-demo-topic";

	@GetMapping("/kafka/publish/{message}")
	public String publishMessage(@PathVariable String message){

		kafkaTemplate.send(TOPIC_NAME, message);

		return message + " message publish successfully";
	}
}