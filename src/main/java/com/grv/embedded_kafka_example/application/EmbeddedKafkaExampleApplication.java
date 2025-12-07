package com.grv.embedded_kafka_example.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.grv.embedded_kafka_example")
public class EmbeddedKafkaExampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(EmbeddedKafkaExampleApplication.class, args);
	}

}
