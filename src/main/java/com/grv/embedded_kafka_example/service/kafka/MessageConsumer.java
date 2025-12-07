package com.grv.embedded_kafka_example.service.kafka;

import com.grv.embedded_kafka_example.application.Processor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class MessageConsumer {

    private final Processor messageHandler;

    public MessageConsumer(Processor messageHandler) {
        this.messageHandler = messageHandler;
    }

    @KafkaListener(topics = "${spring.kafka.event.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(String message) {
        log.info("Received message: {}", message);
        messageHandler.handle(message);
    }
}
