package com.grv.embedded_kafka_example.application.config.kafka;

import org.apache.kafka.clients.admin.AdminClientConfig;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaAdmin;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaTopicConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${spring.kafka.event.topic}")
    private String topicName;

    @Bean
    public KafkaAdmin kafkaAdmin(){
        Map<String, Object> config = new HashMap<>();
        config.put(AdminClientConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress);
        return new KafkaAdmin(config);
    }

    @Bean
    public NewTopic newTopic(){
        return new NewTopic(topicName,1, (short) 1);
    }
}
