package com.grv.embedded_kafka_example.application.config.kafka;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String bootstrapAddress;

    @Value(value = "${spring.kafka.event.topic}")
    private String topicName;

    @Value(value="${spring.kafka.producer.key-serializer}")
    private String keySerializer;

    @Value(value="${spring.kafka.producer.value-serializer}")
    private String valueSerializer;


    @Bean
    public ProducerFactory<String,String> producerFactory(){
        Map<String, Object> configProp =  new HashMap<>();
        configProp.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,bootstrapAddress);
        configProp.put(
                ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                keySerializer);
        configProp.put(
                ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                valueSerializer);
        return new DefaultKafkaProducerFactory<>(configProp);
    }

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate(){
        return new KafkaTemplate<>(producerFactory());
    }
}
