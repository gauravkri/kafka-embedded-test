package com.grv.embedded_kafka_example.application.config.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;

import java.util.HashMap;
import java.util.Map;

public class KafkaConsumerConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${spring.kafka.event.topic}")
    private String topicName;

    @Value(value="${spring.kafka.consumer.key-deserializer}")
    private String keyDeSerializer;

    @Value(value="${spring.kafka.consumer.value-deserializer}")
    private String valueDeSerializer;

    @Value(value = "${spring.kafka.consumer.group-id}")
    private String groupId;


    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        Map<String, Object> configProp =  new HashMap<>();
        configProp.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress);
        configProp.put(ConsumerConfig.GROUP_ID_CONFIG,groupId);
        configProp.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,keyDeSerializer);
        configProp.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,valueDeSerializer);
        return new DefaultKafkaConsumerFactory<>(configProp);
    }

    @Bean
    public ConcurrentKafkaListenerContainerFactory<String,String> concurrentKafkaListenerContainerFactory(){
        ConcurrentKafkaListenerContainerFactory<String, String> c = new ConcurrentKafkaListenerContainerFactory<>();
        c.setConsumerFactory(consumerFactory());
        return c;
    }
}
