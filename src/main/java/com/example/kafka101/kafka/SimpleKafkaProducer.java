package com.example.kafka101.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SimpleKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleKafkaProducer.class);

    @Value("${kafka.topic.first.simple}")
    String topic;
    private final KafkaTemplate<String, String> kafkaTemplate;

    public SimpleKafkaProducer(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String message) {
        LOGGER.info(String.format("#### -> Producing message -> %s", message));
        kafkaTemplate.send(topic, message);
    }
}
