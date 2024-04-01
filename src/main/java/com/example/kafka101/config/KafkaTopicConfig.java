package com.example.kafka101.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;

@Configuration
public class KafkaTopicConfig {

    @Bean
    NewTopic firstTopic(){
        return TopicBuilder.name("${kafka.topic.first}")
                .partitions(3)
                .replicas(1)
                .build();
    }

    @Bean
    NewTopic firstJsonTopic(){
        return TopicBuilder.name("${kafka.topic.first.json}")
                .partitions(3)
                .replicas(1)
                .build();
    }
}
