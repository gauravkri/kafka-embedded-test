package com.grv.embedded_kafka_example.application;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class Processor {

    public void handle(String message) {
        log.info("Handling message in service: {}", message);
        // your business logic here
    }
}
