package com.grv.embedded_kafka_example.service.impl;


import com.grv.embedded_kafka_example.service.TestService;
import com.grv.embedded_kafka_example.service.kafka.Producer;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {


    private final Producer kafkaProducer;

    public TestServiceImpl(Producer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }


    public void produceMessageToKafka(String message){
        kafkaProducer.sendMessage(message);
    }
}
