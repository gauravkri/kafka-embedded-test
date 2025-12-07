package com.grv.embedded_kafka_example.service.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class Producer {

    @Value(value = "${spring.kafka.event.topic}")
    private String topicName;
    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message){
        kafkaTemplate.send(topicName,message);
    }
}
