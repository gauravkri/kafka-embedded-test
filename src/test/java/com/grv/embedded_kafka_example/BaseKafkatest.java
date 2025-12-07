package com.grv.embedded_kafka_example;


import org.springframework.kafka.test.context.EmbeddedKafka;

@EmbeddedKafka(partitions = 1, topics = "testone")
public abstract class BaseKafkatest extends EmbeddedKafkaExampleApplicationTests{
}
