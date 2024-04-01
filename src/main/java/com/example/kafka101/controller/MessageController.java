package com.example.kafka101.controller;

import com.example.kafka101.kafka.JsonKafkaProducer;
import com.example.kafka101.kafka.SimpleKafkaProducer;
import com.example.kafka101.payloads.PostUserResponse;
import com.example.kafka101.payloads.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/kafka")
public class MessageController {

    private final SimpleKafkaProducer simpleKafkaProducer;
    private final JsonKafkaProducer jsonKafkaProducer;

    public MessageController(SimpleKafkaProducer simpleKafkaProducer, JsonKafkaProducer jsonKafkaProducer) {
        this.simpleKafkaProducer = simpleKafkaProducer;
        this.jsonKafkaProducer = jsonKafkaProducer;
    }

    @GetMapping("/publish")
    public ResponseEntity<String> publish(@RequestParam String message) {
        simpleKafkaProducer.sendMessage(message);
        return ResponseEntity.ok("Message sent to the Kafka Topic first-topic");
    }

    @PostMapping("/publish")
    public ResponseEntity<PostUserResponse> publish(@RequestBody User user) {
        jsonKafkaProducer.sendMessage(user);
        return ResponseEntity
                .ok(new PostUserResponse("User sent to the Kafka Topic first-topic-json", user));
    }
}
