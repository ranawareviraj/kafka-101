package com.example.kafka101.kafka;

import com.example.kafka101.payloads.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

@Service
public class JsonKafkaConsumer {
    private static final Logger LOGGER = LoggerFactory.getLogger(JsonKafkaConsumer.class);

    @KafkaListener(topics = "${kafka.topic.first.json}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(Message<User> message) {
        LOGGER.info("###### Consuming message ######");
        StringBuilder headers = new StringBuilder();
        headers.append("{");
        message.getHeaders()
                .forEach((key, value) ->
                        headers.append(String.format("\n %s : %s", key, value)));
        headers.append("\n}");
        LOGGER.info(String.format("#### Headers -> %s", headers));
        LOGGER.info(String.format("#### Payload -> %s", message.getPayload()));
        LOGGER.info("###### Consumed message ######");
        System.out.println();
    }

}
