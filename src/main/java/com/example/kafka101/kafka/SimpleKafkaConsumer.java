package com.example.kafka101.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class SimpleKafkaConsumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleKafkaConsumer.class);

    @KafkaListener(topics = "${kafka.topic.first.simple}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        LOGGER.info(String.format("#### -> Consumed message -> %s", message));
    }
}
